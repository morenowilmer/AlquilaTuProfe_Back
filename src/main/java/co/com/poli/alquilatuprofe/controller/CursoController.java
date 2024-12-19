package co.com.poli.alquilatuprofe.controller;

import co.com.poli.alquilatuprofe.model.commons.Curso;
import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.commons.InformacionMatricula;
import co.com.poli.alquilatuprofe.model.requester.MatricularCursoRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCursoRequester;
import co.com.poli.alquilatuprofe.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(value = "*")
@Validated
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @ResponseBody
    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<GeneralResponse<Curso>> registrarCurso(@Valid @RequestBody RegistrarCursoRequester requester) throws Exception {
        Curso curso = cursoService.registrarCurso(requester);

        if (Objects.nonNull(curso)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(curso));
        }
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @GetMapping(value = "/mis-cursos-registrados/{idProfesor}", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<Curso>>> cursosRegistrados(
            @NotNull @PathVariable("idProfesor") Integer idProfesor) throws Exception {
        List<Curso> cursos = cursoService.consultarCursosPropios(idProfesor);

        if (Objects.nonNull(cursos) && !cursos.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(cursos));
        }
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PostMapping(value = "/matricular", produces = "application/json")
    public ResponseEntity<GeneralResponse<Boolean>> matricularCurso(@Valid @RequestBody MatricularCursoRequester requester) throws Exception {
        Boolean matricular = cursoService.matricularCurso(requester);

        if (Objects.nonNull(matricular)) {
            return ResponseEntity.ok().body(GeneralResponse.exito(matricular));
        }
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @GetMapping(value = "/matriculados/{idAlumno}", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<InformacionMatricula>>> cursosMatriculados(
            @NotNull @PathVariable("idAlumno") Integer idAlumno) throws Exception {
        List<InformacionMatricula> cursos = cursoService.cursosMatriculados(idAlumno);

        if (Objects.nonNull(cursos) && !cursos.isEmpty()) {
            return ResponseEntity.ok().body(GeneralResponse.exito(cursos));
        }
        return ResponseEntity.noContent().build();
    }
}
