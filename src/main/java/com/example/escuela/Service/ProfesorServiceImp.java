package com.example.escuela.Service;

import com.example.escuela.Entity.Profesor;
import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import com.example.escuela.Entity.dto.Profesor.ProfesorEdit;
import com.example.escuela.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImp extends BaseServiceImp<Profesor, ProfesorDto, ProfesorCreate, Long> implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ProfesorDto update(Long id, ProfesorEdit dto) throws Exception {
        // Buscar profesor por ID
        var profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new Exception("Profesor no encontrado con id " + id));

        // Actualizar campos editables
        if (dto.nombre() != null) profesor.setNombre(dto.nombre());
        if (dto.mail() != null) profesor.setMail(dto.mail());

        // Guardar cambios
        var actualizado = profesorRepository.save(profesor);

        // Mapear a DTO y devolver
        return baseMapper.toDto(actualizado);
    }
}
