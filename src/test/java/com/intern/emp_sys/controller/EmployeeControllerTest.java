package com.intern.emp_sys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.intern.emp_sys.model.Employee;
import com.intern.emp_sys.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    Employee employee;
    Employee employee1;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        employee = new Employee(1, "Vasu", "vasu7yadav@gmail.com", "1234567890", "Delhi");

        employee1 = new Employee(2, "Daksh", "daksh8malik@gmail.com", "9999999999", "Meerut");

        employeeList.add(employee);
        employeeList.add(employee1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateNewEmployee() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employee);

        when(employeeService.createNewEmployee(employee)).thenReturn(employee);
        this.mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(employeeList);
        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(1)).thenReturn(employee);
        this.mockMvc.perform(get("/employees/{id}", 1)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateEmployeeById() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employee);

        when(employeeService.updateEmployeeById(1, employee)).thenReturn(employee);
        this.mockMvc.perform(put("/employees/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteEmployeeById() throws Exception {
        doNothing().when(employeeService).deleteEmployeeById(1);
        this.mockMvc.perform(delete("/employees/{id}", 1)).andDo(print()).andExpect(status().isOk());
    }
}