package com.example.escuela.Controller;

import com.example.escuela.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController <D,DC,ID>{

    @Autowired
    BaseService<D,DC,ID> baseService;

    @PostMapping
    public ResponseEntity<?> save (@RequestBody DC dc){
        try{
            return ResponseEntity.ok(baseService.save(dc));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll (){
        try{
            return ResponseEntity.ok(baseService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al obtener todas las entidades: " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById (@PathVariable ID id){
        try{
            return ResponseEntity.ok(baseService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al buscar entidad con id " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable ID id){
        try{
            baseService.deleteById(id);
            return ResponseEntity.ok("Entidad con id " + id + " eliminada con exito");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al eliminar entidad con id " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
}

