package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.commons.LoginResponse;
import co.com.poli.alquilatuprofe.model.requester.LoginRequester;
import co.com.poli.alquilatuprofe.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/login")
@CrossOrigin(value = "*")
@Valid
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<GeneralResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequester requester) throws IOException {
        LoginResponse loginResponse = loginService.login(requester);

        if (Objects.nonNull(loginResponse)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(loginResponse));
        }
        return ResponseEntity.status(401).body(GeneralResponse.error("Credenciales incorrectas"));
    }

    @ResponseBody
    @PutMapping("/cerrar-sesion")
    public ResponseEntity<GeneralResponse<String>> cerrarSesion() {
        loginService.cerrarSesion();
        return ResponseEntity.ok().body(GeneralResponse
                .exito("Se ha cerrado la sesión exitosamente"));
    }
}
