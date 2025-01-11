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
@Table(name="Usuario")
public class UsuarioModel {
    @Id
    @Column(name="idUsuario")
    public Integer idAlumno;

    @Column(name= "username")
    public String nombre;

    @Column(name= "password")
    public String nota;

    @Column(name= "rol")
    public Integer rol;
}
