package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Curso.CursoCreate;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Curso.CursoEdit;
import com.example.escuela.Repository.CursoRepository;
import com.example.escuela.Repository.EstudianteRepository;
import com.example.escuela.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CursoServiceImp extends BaseServiceImp<Curso, CursoDto, CursoCreate, Long> implements CursoService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void addEstudiante(Long idCurso, Long idEstudiante) {
        var curso = cursoRepository.getById(idCurso);
        var estudiante = estudianteRepository.getById(idEstudiante);
        curso.getEstudiantes().add(estudiante);
        cursoRepository.save(curso);
        estudiante.getCursos().add(curso);
        estudianteRepository.save(estudiante);
    }

    @Override
    public CursoDto update(Long id, CursoEdit dto) throws Exception {
        var curso = cursoRepository.findById(id)
                .orElseThrow(() -> new Exception("Curso no encontrado con id " + id));

        if (dto.nombre() != null) curso.setNombre(dto.nombre());

        if (dto.profesorId() != null) {
            var profesor = profesorRepository.findById(dto.profesorId())
                    .orElseThrow(() -> new Exception("Profesor no encontrado con id " + dto.profesorId()));
            curso.setProfesor(profesor);
        }



        var actualizado = cursoRepository.save(curso);
        return baseMapper.toDto(actualizado);
    }
}
