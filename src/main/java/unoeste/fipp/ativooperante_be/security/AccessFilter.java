package unoeste.fipp.ativooperante_be.security;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;


public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization"); 
        if(token!=null && JWTTokenProvider.verifyToken(token)) {
            String nivel = JWTTokenProvider.getAllClaimsFromToken(token).get("nivel").toString();
            String rotaDestino = (((HttpServletRequest) request).getRequestURI());
            if((rotaDestino.contains("adm") && nivel.equals("1"))  || (rotaDestino.contains("cidadao") && nivel.equals("2"))) {
                chain.doFilter(request, response);
            }
        }
        else {
            ((HttpServletResponse) response).setStatus(500);
            response.getOutputStream().write("Não autorizado ".getBytes());
        }
    }
}

    
