package com.example.escuela.Entity.mapper;

import com.example.escuela.Entity.Estudiante;
import com.example.escuela.Entity.dto.Estudiante.EstudianteCreate;
import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper implements BaseMapper<Estudiante, EstudianteDto, EstudianteCreate> {
    @Override
    public Estudiante toEntity(EstudianteCreate estudianteCreate) {
        Estudiante e = new Estudiante();
        e.setNombre(estudianteCreate.nombre());
        e.setMatricula(String.valueOf(estudianteCreate.matricula()));
        return e;
    }

    @Override
    public EstudianteDto toDto(Estudiante estudiante) {
        return new EstudianteDto(estudiante.getId(), estudiante.getNombre(), estudiante.getMatricula());
    }
}
