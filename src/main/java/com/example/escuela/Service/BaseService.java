package com.example.escuela.Service;

import java.util.List;

public interface BaseService <D, DC, ID>{
    public D save (DC dc);
    public D findById(ID id);
    public List<D> findAll();
    public void deleteById(ID id);
}