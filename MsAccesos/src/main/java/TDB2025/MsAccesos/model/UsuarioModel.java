package TDB2025.MsAccesos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UsuarioModel {
    @Id
    @Column(name="id_usuario")
    public Integer idUsuario;

    @Column(name= "nombre")
    public String nombre;

    @Column(name= "username")
    public String username;

    @Column(name= "password")
    public String password;

    @Column(name= "rol")
    public Integer rol;

    @Column(name= "fecha")
    public String fecha;
}
