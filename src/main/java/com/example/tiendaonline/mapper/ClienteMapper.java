package com.example.tiendaonline.mapper;


import com.example.tiendaonline.dto.ClienteRequestDTO;
import com.example.tiendaonline.dto.ClienteResponseDTO;
import com.example.tiendaonline.model.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteModel toModel(ClienteRequestDTO request){
        ClienteModel clienteMod = new ClienteModel();
        clienteMod.setNombre(request.nombre());
        clienteMod.setApellido(request.apellido());
        clienteMod.setDireccion(request.direccion());
        clienteMod.setCorreo(request.correo());
        clienteMod.setTelefono(request.telefono());
        clienteMod.setRol(request.rol());
        return clienteMod;
    }

    public ClienteResponseDTO toDTO (ClienteModel clienteMod){
        return ClienteResponseDTO.builder()
                .id_cliente(clienteMod.getId_cliente())
                .nombre(clienteMod.getNombre())
                .correo(clienteMod.getCorreo())
                .build();
    }

}
