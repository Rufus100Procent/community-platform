package se.stykle.communityplatform.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import se.stykle.communityplatform.security.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwt;

    public AuthController(AuthenticationManager authManager, JwtService jwt) {
        this.authManager = authManager;
        this.jwt = jwt;
    }

    // curl -s -X POST http://localhost:8080/api/auth/login      -H "Content-Type: application/json"      -d '{"username":"joe","password":"pass"}' | jq
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password()));
        String token = jwt.generate((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    public record AuthRequest(String username, String password) {}
    public record AuthResponse(String token) {}
}
