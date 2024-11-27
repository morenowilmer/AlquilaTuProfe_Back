package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.LoginAdapter;
import co.com.poli.alquilatuprofe.bd.adapter.SesionAdapter;
import co.com.poli.alquilatuprofe.model.commons.LoginResponse;
import co.com.poli.alquilatuprofe.model.commons.Sesion;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.requester.LoginRequester;
import co.com.poli.alquilatuprofe.util.TokenJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${jwt.tiempo.horas}")
    private Integer tiempoHoras;
    @Value("${jwt.secret}")
    private String secret;

    private final LoginAdapter loginAdapter;
    private final SesionAdapter sesionAdapter;
    private final HttpServletRequest httpServletRequest;

    public LoginServiceImpl(LoginAdapter loginAdapter,
                            SesionAdapter sesionAdapter,
                            HttpServletRequest httpServletRequest) {
        this.loginAdapter = loginAdapter;
        this.sesionAdapter = sesionAdapter;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public LoginResponse login(LoginRequester requester) {
        String contrasena = Base64.getEncoder().encodeToString(requester.getContrasena().getBytes());
        Usuario usuario = loginAdapter.login(requester.getTipoUsuario(), requester.getCorreo(),
                contrasena, "S");

        if (Objects.isNull(usuario)) return null;

        String nombreCompleto = usuario.getNombre();

        if (Objects.nonNull(usuario.getApellido()))
            nombreCompleto = nombreCompleto.concat(" " + usuario.getApellido());

        UUID uuid = UUID.randomUUID();

        Sesion sesion = Sesion.builder()
                .id(uuid.toString())
                .usuario(usuario)
                .fechaInicio(LocalDateTime.now())
                .fechaFin(LocalDateTime.now().plusHours(tiempoHoras)).build();

        sesionAdapter.eliminarSesionesUsuario(usuario.getId());
        sesionAdapter.guardarSesion(sesion);

        String token = TokenJWT.generateToken(usuario, uuid.toString(), secret, tiempoHoras);

        return LoginResponse.builder()
                .id(usuario.getId())
                .nombreCompleto(nombreCompleto)
                .foto(usuario.getFoto())
                .token(token)
                .build();
    }

    @Override
    public Sesion obtenerSesion(String id) {
        return sesionAdapter.obtenerSesion(id);
    }

    @Override
    public void cerrarSesion() {
        String header = httpServletRequest.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String jwtToken = header.substring(7);

            String subject = TokenJWT.obtenerSubjectToken(jwtToken);

            sesionAdapter.eliminarSesion(subject);
        }
    }
}
