package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteCreate;
import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteEdit;

import java.util.List;


public interface EstudianteService  extends BaseService<EstudianteDto, EstudianteCreate,Long> {
    void addCurso(Curso curso, Estudiante e);
    List<CursoDto> getCursosById(Long idEstudiante);
    EstudianteDto update(Long id, EstudianteEdit dto) throws Exception;
}