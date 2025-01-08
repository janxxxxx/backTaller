package com.example.Productos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Productos {
    @Id
    public Integer id;

    public String nombre;

    public String descripcion;

    public String categoria;
    
    public String almacen;
}
