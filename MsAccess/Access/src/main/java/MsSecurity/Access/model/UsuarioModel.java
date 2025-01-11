package MsSecurity.Access.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class UsuarioModel {
    @Id
    @Column(name="idUsuario")
    public Integer idAlumno;

    @Column(name= "nombre")
    public String nombre;

    @Column(name= "username")
    public String username;

    @Column(name= "password")
    public String nota;

    @Column(name= "rol")
    public Integer rol;

    @Column(name= "fecha")
    public String fecha;
}
