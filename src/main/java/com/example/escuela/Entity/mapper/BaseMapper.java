package com.example.escuela.Entity.mapper;

public interface BaseMapper <E,DTO,DC>{
    public E toEntity(DC dc);
    public DTO toDto(E e);
}

