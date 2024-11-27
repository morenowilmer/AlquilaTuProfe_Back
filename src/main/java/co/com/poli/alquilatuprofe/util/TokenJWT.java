package co.com.poli.alquilatuprofe.util;

import co.com.poli.alquilatuprofe.model.commons.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class TokenJWT {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(Usuario usuario, String uuid, String secret, Integer tiempoHoras) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + (tiempoHoras * 3600000));

        return Jwts.builder()
                .setSubject(uuid)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .claim("uuid", uuid)
                .compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String obtenerSubjectToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
