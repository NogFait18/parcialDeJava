package com.example.escuela.Controller;

import com.example.escuela.Entity.dto.Curso.CursoCreate;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Curso.CursoEdit;
import com.example.escuela.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("curso")
public class CursoController extends BaseController<CursoDto, CursoCreate, Long> {

    @Autowired
    CursoService cursoService;

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CursoEdit dto) {
        try {
            var actualizado = cursoService.update(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @PutMapping("addEstudiante/{idCurso}/{idEstudiante}")
    public ResponseEntity<?> addEstudiante(@PathVariable Long idCurso, @PathVariable Long idEstudiante) {
        try {
            cursoService.addEstudiante(idCurso, idEstudiante);
            return ResponseEntity.ok("Estudiante agregado con exito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
}
