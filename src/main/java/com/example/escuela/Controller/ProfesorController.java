package com.example.escuela.Controller;

import com.example.escuela.Entity.dto.Profesor.ProfesorCreate;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("profesor")
public class ProfesorController extends BaseController<ProfesorDto, ProfesorCreate,Long> {
}