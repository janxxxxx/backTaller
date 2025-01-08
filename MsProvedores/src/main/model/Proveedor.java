package MsProductos.MsProductos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proveedor {

    @Id
    private int id;
    private String numProveedor;  // Changed the field to reflect "Proveedor"
    private String nombre;
    private double costos;
    private double impuestos;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumProveedor() {  // Changed the getter method
        return numProveedor;
    }

    public void setNumProveedor(String numProveedor) {  // Changed the setter method
        this.numProveedor = numProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostos() {
        return costos;
    }

    public void setCostos(double costos) {
        this.costos = costos;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }
}
