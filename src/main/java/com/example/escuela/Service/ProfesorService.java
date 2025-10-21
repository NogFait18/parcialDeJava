package com.example.escuela.Service;


import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import com.example.escuela.Entity.dto.Profesor.ProfesorEdit;

public interface ProfesorService extends BaseService<ProfesorDto, ProfesorCreate,Long> {
    ProfesorDto update(Long id, ProfesorEdit dto) throws Exception;
}
