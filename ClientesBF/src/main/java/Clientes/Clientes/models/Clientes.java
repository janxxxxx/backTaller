package Clientes.Clientes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Clientes {
    
    @Id
    public Integer id;

    public String nombres;

    public String apellidos;

    public String email;

    public LocalDate fecha;

    public String descripcion;

    public String numtelef;
    
    public String tipofactura;

}
