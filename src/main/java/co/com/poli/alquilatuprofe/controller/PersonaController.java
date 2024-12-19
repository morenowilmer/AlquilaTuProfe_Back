package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.commons.TipoDocumento;
import co.com.poli.alquilatuprofe.service.TipoDocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/persona")
@CrossOrigin(value = "*")
@Validated
public class PersonaController {

    private final TipoDocumentoService tipoDocumentoService;

    public PersonaController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @ResponseBody
    @GetMapping("/tipos-documentos")
    public ResponseEntity<GeneralResponse<List<TipoDocumento>>> tiposDocumento() {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoService.consultarTiposDocumentosActivos();
        if (Objects.nonNull(tipoDocumentos) && !tipoDocumentos.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(tipoDocumentos));
        }

        return ResponseEntity.noContent().build();
    }
}
