package com.example.escuela.Entity.dto.Estudiante;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EstudianteDto {
    private Long id;
    private String nombre;
    private String matricula;
}