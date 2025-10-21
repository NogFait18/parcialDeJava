package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.dto.Curso.CursoCreate;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImp extends BaseServiceImp<Curso, CursoDto, CursoCreate, Long> implements CursoService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public void addEstudiante(Long idCuso, Long idEstudiante) {
        var c = baseRepository.getById(idCuso);
        var e = estudianteRepository.getById(idEstudiante);
        c.getEstudiantes().add(e);
        baseRepository.save(c);
        e.getCursos().add(c);
        estudianteRepository.save(e);
    }
}