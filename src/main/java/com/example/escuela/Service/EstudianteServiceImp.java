package com.example.escuela.Service;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Curso.CursoDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteCreate;
import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;
import com.example.escuela.Entity.dto.Estudiante.EstudianteEdit;
import com.example.escuela.Entity.mapper.CursoMapper;
import com.example.escuela.Repository.CursoRepository;
import com.example.escuela.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EstudianteServiceImp extends BaseServiceImp<Estudiante, EstudianteDto, EstudianteCreate, Long> implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public void addCurso(Curso curso, Estudiante e) {
        e.getCursos().add(curso);
        baseRepository.save(e);
    }

    @Override
    public List<CursoDto> getCursosById(Long idEstudiante) {
        return estudianteRepository.findCursosById(idEstudiante)
                .stream()
                .map(cursoMapper::toDto)
                .toList();
    }

    @Override
    public EstudianteDto update(Long id, EstudianteEdit dto) throws Exception {
        var estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new Exception("Estudiante no encontrado con id " + id));

        if (dto.nombre() != null) estudiante.setNombre(dto.nombre());
        if (dto.matricula() != null) estudiante.setMatricula(String.valueOf(dto.matricula()));


        var actualizado = estudianteRepository.save(estudiante);
        return baseMapper.toDto(actualizado);
    }
}
