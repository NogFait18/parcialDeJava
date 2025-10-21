package com.example.escuela.Entity.dto.Profesor;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ProfesorDto {
    private Long id;
    private String nombre;
    private String email;
}
