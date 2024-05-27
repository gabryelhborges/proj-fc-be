package unoeste.fipp.ativooperante_be.security;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;

public class JWTTokenProvider {
    private static final SecretKey CHAVE = Keys.hmacShaKeyFor(
            "MINHANOVACHAVESECRETA_MINHANOVACHAVESECRETA".getBytes(StandardCharsets.UTF_8));

    static public String getToken(Usuario usuario)
    {
        int nivel = usuario.getNivel();
        String email= usuario.getEmail();
        Long id = usuario.getId();
        String jwtToken = Jwts.builder()
            .setSubject("usuario")
            .setIssuer("localhost:8080")
                .claim("nivel", nivel)
                .claim("email", email)
                .claim("id", id)
            .setIssuedAt(new Date())
            .setExpiration(Date.from(LocalDateTime.now().plusMinutes(30L)
                .atZone(ZoneId.systemDefault()).toInstant()))
            .signWith(CHAVE)
            .compact();
        return jwtToken;
        //mais claims podem ser adicionados.
    }

    static public boolean verifyToken(String token)
    {
        try {
            Jwts.parserBuilder()
                .setSigningKey(CHAVE)
                .build()
                .parseClaimsJws(token).getSignature();
                return true;
       } catch (Exception e) {
                System.out.println(e);
       }
       return false;       
    }

    static public Claims getAllClaimsFromToken(String token) 
    {
        Claims claims=null;
        try {
            claims = Jwts.parserBuilder()
            .setSigningKey(CHAVE)
            .build()
            .parseClaimsJws(token)
            .getBody();
        } catch (Exception e) {
            System.out.println("Erro ao recuperar as informações (claims)");
        }
        return claims;        
    }

}
