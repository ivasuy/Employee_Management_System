package com.intern.emp_sys.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private final String SECRET_KEY = "sIoVC8OFOgmxbk9XRYtY2zMKXuYXBGL2d3x1IV37";
    private final Long EXPIRATION_TIME = 60*60*1000L;

    private Claims parseToken(String token){

        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build();

        try {
             return jwtParser.parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | SignatureException | IllegalArgumentException |
                 MalformedJwtException ignored) {
        }

        return null;
    }

    public boolean validateToken(String token){
        return parseToken(token) != null;
    }

    public String getUsernameFromToken(String token){
        Claims claims = parseToken(token);

        if(claims != null){
            return claims.getSubject();
        }

        return null;
    }

    public String generateToken(String username){
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        var currentDate = new Date();
        var expirationDate = new Date(currentDate.getTime()+EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }
}
