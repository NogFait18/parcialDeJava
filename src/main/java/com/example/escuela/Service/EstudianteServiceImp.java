package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteCreate;
import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;
import com.example.escuela.Entity.mapper.CursoMapper;
import com.example.escuela.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImp extends BaseServiceImp<Estudiante, EstudianteDto, EstudianteCreate,Long> implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    CursoMapper cursoMapper;

    @Override
    public void addCurso(Curso curso, Estudiante e) {
        e.getCursos().add(curso);
        baseRepository.save(e);
    }

    @Override
    public List<CursoDto> getCursosById(Long idEstudiante) {
        return estudianteRepository.findCursosById(idEstudiante).stream().map(cursoMapper::toDto).toList();
    }
}
