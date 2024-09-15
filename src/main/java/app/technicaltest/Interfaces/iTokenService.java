package app.technicaltest.Interfaces;

public interface iTokenService {
    String generateToken(String username);
    String extractUsername(String token);
    Boolean validateToken(String token, String username);
}
