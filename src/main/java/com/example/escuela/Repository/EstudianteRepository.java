package com.example.escuela.Repository;

import com.example.escuela.Entity.Curso;
import com.example.escuela.Entity.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository  extends BaseRepository<Estudiante, Long> {
    @Query("SELECT e.cursos FROM Estudiante e WHERE e.id = :id")
    List<Curso> findCursosById(Long id);
}
