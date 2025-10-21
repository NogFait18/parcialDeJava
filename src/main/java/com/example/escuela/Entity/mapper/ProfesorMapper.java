package com.example.escuela.Entity.mapper;

import com.example.escuela.Entity.Profesor;
import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper implements BaseMapper<Profesor, ProfesorDto, ProfesorCreate> {
    @Override
    public Profesor toEntity(ProfesorCreate profesorCreate) {
        Profesor p = new Profesor();
        p.setMail(profesorCreate.mail());
        p.setNombre(profesorCreate.nombre());
        return p;
    }

    @Override
    public ProfesorDto toDto(Profesor profesor) {
        ProfesorDto p = new ProfesorDto(profesor.getId(), profesor.getNombre(),profesor.getMail());
        return p;
    }
}
