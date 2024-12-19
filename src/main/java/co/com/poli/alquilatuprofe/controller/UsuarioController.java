package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.commons.TipoUsuario;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.requester.ConsultarUsuarioRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistroUsuarioRequester;
import co.com.poli.alquilatuprofe.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ResponseBody
    @PutMapping("/registrar")
    public ResponseEntity<GeneralResponse<Usuario>> registrar(
            @Valid @RequestBody RegistroUsuarioRequester requester) throws Exception {
        Usuario usuario = usuarioService.registrarUsuario(requester);

        if (Objects.nonNull(usuario)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(usuario));
        }

        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @GetMapping("/tipo-usuarios")
    public ResponseEntity<GeneralResponse<List<TipoUsuario>>> tiposUsuarios() {
        List<TipoUsuario> tiposUsuarios = usuarioService.consultarTiposUsuarios();

        if (Objects.nonNull(tiposUsuarios) && !tiposUsuarios.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(tiposUsuarios));
        }

        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PostMapping("/consultar-usuario")
    public ResponseEntity<GeneralResponse<Usuario>> consultarUsuario(@Valid @RequestBody ConsultarUsuarioRequester requester) {
        Usuario usuario = usuarioService.consultarUsuario(requester);

        if (Objects.nonNull(usuario)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(usuario));
        }

        return ResponseEntity.noContent().build();
    }
}
