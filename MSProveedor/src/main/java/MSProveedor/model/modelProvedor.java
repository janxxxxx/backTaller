package MSProveedor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores") // Nombre de la tabla en la base de datos
public class modelProvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column(name = "proveedor_id")
    private int proveedor_id; // Identificador único del proveedor

    @Column(name = "ruc_proveedor", unique = true, nullable = false)
    private String ruc_proveedor; // Número único de registro tributario

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombre_proveedor; // Nombre o razón social del proveedor

    @Column(name = "correo_proveedor")
    private String correo_proveedor; // Correo electrónico del proveedor

    @Column(name = "telefono_proveedor")
    private String telefono_proveedor; // Teléfono de contacto del proveedor

    @Column(name = "direccion_proveedor")
    private String direccion_proveedor; // Dirección física del proveedor

    @Column(name = "estado_proveedor", nullable = false, columnDefinition = "VARCHAR(45) DEFAULT 'activo'")
    private String estado_proveedor = "activo"; // Estado del proveedor (activo, inactivo)

    // Getters y Setters

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo_proveedor) {
        this.correo_proveedor = correo_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getEstado_proveedor() {
        return estado_proveedor;
    }

    public void setEstado_proveedor(String estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }
}
