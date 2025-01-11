package main.java.MsProveedores.MsProveedores.dto;

import java.io.Serializable;

public class AuthRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private int proveedor_id; // Identificador único del proveedor
    private String ruc_proveedor; // Número único de registro tributario
    private String nombre_proveedor; // Nombre o razón social del proveedor
    private String correo_proveedor; // Correo electrónico del proveedor
    private String telefono_proveedor; // Teléfono de contacto del proveedor
    private String direccion_proveedor; // Dirección física del proveedor
    private String estado_proveedor; // Estado del proveedor (activo, inactivo)

    // Constructor vacío
    public AuthRequest() {
    }

    // Constructor con parámetros
    public AuthRequest(int proveedor_id, String ruc_proveedor, String nombre_proveedor,
            String correo_proveedor, String telefono_proveedor,
            String direccion_proveedor, String estado_proveedor) {
        this.proveedor_id = proveedor_id;
        this.ruc_proveedor = ruc_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.correo_proveedor = correo_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.estado_proveedor = estado_proveedor;
    }

    // Getters y setters
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
