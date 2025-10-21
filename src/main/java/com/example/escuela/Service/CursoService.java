package com.example.escuela.Service;

import com.example.escuela.Entity.dto.Curso.CursoCreate;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Curso.CursoEdit;


public interface CursoService extends BaseService<CursoDto, CursoCreate,Long> {
    void addEstudiante(Long idCuso, Long idEstudiante);
    CursoDto update(Long id, CursoEdit dto) throws Exception;
}
