package com.example.escuela.Service;

import com.example.escuela.Entity.Profesor;
import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import org.springframework.stereotype.Service;


@Service
public class ProfesorServiceImp extends BaseServiceImp<Profesor, ProfesorDto, ProfesorCreate, Long> implements ProfesorService {
}

