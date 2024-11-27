package co.com.poli.alquilatuprofe.intercetor;

import co.com.poli.alquilatuprofe.model.commons.Sesion;
import co.com.poli.alquilatuprofe.service.LoginService;
import co.com.poli.alquilatuprofe.util.TokenJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${url.sesion.no.validar}")
    private List<String> urlsNoValidar;

    private final LoginService loginService;

    public JwtFilter(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String urlPath = request.getServletPath();

        if (urlsNoValidar.contains(urlPath)) {
            filterChain.doFilter(request, response);
        } else {
            final String header = request.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer ")) {
                String jwtToken = header.substring(7);

                if (!TokenJWT.validateToken(jwtToken))
                    throw new ServletException("Usuario no autorizado.");

                String subject = TokenJWT.obtenerSubjectToken(jwtToken);

                Sesion sesion = loginService.obtenerSesion(subject);

                if (Objects.isNull(sesion))
                    throw new ServletException("Usuario no autorizado.");

                validarVigenciaSesion(sesion);

                filterChain.doFilter(request, response);
            } else {
                throw new ServletException("Usuario no autorizado.");
            }
        }
    }

    private void validarVigenciaSesion(Sesion sesion) throws ServletException{
        if (sesion.getFechaFin().isBefore(LocalDateTime.now())) {
            loginService.cerrarSesion();
            throw new ServletException("Sesion expirada.");
        }
    }
}
