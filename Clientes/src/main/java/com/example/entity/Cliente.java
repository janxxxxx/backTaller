package main.java.com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity

@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String apellido;

    @Email
    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 60)
    private BigInteger numtel;

    @Column(nullable = false, length = 60)
            private String tipofactura;

    private String descripcion;

    @Column(name = "fecha")
    //Temporal indica en que formato se va a guardar la fecha
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Serial
    private static final long serialVersionUID = 1L;

    //Metodo que se invoca antes de insertar registro en la DB
    @PrePersist
    private void prePersist(){
        fecha = new Date();
    }


    public Cliente(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigInteger getNumtel() {
        return numtel;
    }

    public void setNumtel(BigInteger numtel) {
        this.numtel = numtel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipofactura() {
        return tipofactura;
    }

    public void setTipofactura(String tipofactura) {
        this.tipofactura = tipofactura;
    }

    //El orderBY lo que hace es ordenar de manera descendente todas las fechas
    @OrderBy(value = "fecha DESC")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
