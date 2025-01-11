package main.java.MsProveedores.MsProveedores.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ruc_proveedor; // Solo tomamos un parámetro (ruc_proveedor)

    // Constructor
    public AuthResponse(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    // Getter
    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

}
