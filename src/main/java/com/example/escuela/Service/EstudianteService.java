package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteCreate;
import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;

import java.util.List;

// No tengo campos los cuales editar
public interface EstudianteService  extends BaseService<EstudianteDto, EstudianteCreate,Long> {
    void addCurso(Curso curso, Estudiante e);
    List<CursoDto> getCursosById(Long idEstudiante);
}