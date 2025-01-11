package main.java.MsProveedores.MsProveedores.Mapper;

import org.springframework.stereotype.Component;

import main.java.MsProveedores.MsProveedores.dto.AuthRequest;
import main.java.MsProveedores.MsProveedores.model.modelProvedor;

@Component
public class ProveedorMapper {

    // Método para convertir una entidad ProveedorModel a un DTO ProveedorDTO
    public AuthRequest entityToDto(ModelProvedor modelProvedor) {
        AuthRequest dto = new AuthRequest();
        // Asignar los valores de ModelProvedor a los campos de AuthRequest
        dto.setProveedor_id(modelProvedor.getProveedor_id());
        dto.setRuc_proveedor(modelProvedor.getRuc_proveedor());
        dto.setNombre_proveedor(modelProvedor.getNombre_proveedor());
        dto.setCorreo_proveedor(modelProvedor.getCorreo_proveedor());
        dto.setTelefono_proveedor(modelProvedor.getTelefono_proveedor());
        dto.setDireccion_proveedor(modelProvedor.getDireccion_proveedor());
        dto.setEstado_proveedor(modelProvedor.getEstado_proveedor());

        return dto;
    }

    // Método para convertir un DTO ProveedorDTO a una entidad ProveedorModel
    public modelProvedor dtoToEntity(AuthRequest dto) {
        modelProvedor proveedorModel = new modelProvedor();
        proveedorModel.setProveedor_id(dto.getProveedor_id());
        proveedorModel.setRuc_proveedor(dto.getRuc_proveedor());
        proveedorModel.setNombre_proveedor(dto.getNombre_proveedor());
        proveedorModel.setCorreo_proveedor(dto.getCorreo_proveedor());
        proveedorModel.setTelefono_proveedor(dto.getTelefono_proveedor());
        proveedorModel.setDireccion_proveedor(dto.getDireccion_proveedor());
        proveedorModel.setEstado_proveedor(dto.getEstado_proveedor());
        return proveedorModel;
    }
}
