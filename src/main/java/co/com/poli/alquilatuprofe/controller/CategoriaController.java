package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.Categoria;
import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCategoriaRequester;
import co.com.poli.alquilatuprofe.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping(value = "/listar-subcategorias/{idCategoriaPadre}", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<Categoria>>> listarSubCategorias(
            @NotNull @PathVariable("idCategoriaPadre") Integer idCategoriaPadre) throws Exception {
        List<Categoria> categorias = categoriaService.consultarSubCategorias(idCategoriaPadre);

        if (Objects.nonNull(categorias) && !categorias.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(categorias));
        }
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PutMapping (value = "/registrar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GeneralResponse<Categoria>> registrarCategoria(@Valid @RequestBody RegistrarCategoriaRequester requester) throws Exception {
        Categoria categorias = categoriaService.registrarCategoria(requester);

        if (Objects.nonNull(categorias)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(categorias));
        }
        return ResponseEntity.noContent().build();
    }
}
