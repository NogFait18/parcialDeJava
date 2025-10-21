package com.example.escuela.Service;

import com.example.escuela.Entity.dto.Curso.CursoCreate;
import com.example.escuela.Entity.dto.Curso.CursoDto;

// No tengo campos los cuales editar
public interface CursoService extends BaseService<CursoDto, CursoCreate,Long> {
    void addEstudiante(Long idCuso, Long idEstudiante);
}
