package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import co.com.poli.alquilatuprofe.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/categorias")
@Validated
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @ResponseBody
    @GetMapping(value = "/listar", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<Categoria>>> consultarCategorias() throws IOException {
        List<Categoria> categorias = categoriaService.consultarCategorias();

        if (Objects.nonNull(categorias) && !categorias.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(categorias));
        }
        return ResponseEntity.noContent().build();
    }
}
