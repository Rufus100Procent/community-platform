package se.stykle.communityplatform.security.service;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private static final long EXPIRY = Duration.ofHours(24).toMillis();

    public String generate(UserDetails user) {
        Date now = new Date();
        return Jwts.builder()
                .setClaims(Map.of())
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + EXPIRY))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    public String username(String token) {
        return parser(token).getBody().getSubject();
    }

    public boolean isValid(String token, UserDetails user) {
        return username(token).equals(user.getUsername())
                && !parser(token).getBody().getExpiration().before(new Date());
    }

    private Jws<Claims> parser(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);
    }
}
