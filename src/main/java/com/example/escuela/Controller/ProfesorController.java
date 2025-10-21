package com.example.escuela.Controller;

import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import com.example.escuela.Entity.dto.Profesor.ProfesorEdit;
import com.example.escuela.Service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("profesor")
public class ProfesorController extends BaseController<ProfesorDto, ProfesorCreate, Long> {

    @Autowired
    ProfesorService profesorService;

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProfesorEdit dto) {
        try {
            var actualizado = profesorService.update(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
}
