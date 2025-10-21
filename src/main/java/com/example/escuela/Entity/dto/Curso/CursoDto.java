package com.example.escuela.Entity.dto.Curso;



import com.example.escuela.Entity.dto.Estudiante.EstudianteDto;
import com.example.escuela.Entity.dto.Profesor.ProfesorDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CursoDto {
    private Long id;
    private String nombre;
    private ProfesorDto profesor;
    private List<EstudianteDto> estudiantes;
}
