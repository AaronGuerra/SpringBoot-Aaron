package com.example.tiendaonline.service;

import com.example.tiendaonline.dto.ClienteRequestDTO;
import com.example.tiendaonline.dto.ClienteResponseDTO;
import com.example.tiendaonline.mapper.ClienteMapper;
import com.example.tiendaonline.model.ClienteModel;
import com.example.tiendaonline.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    // Métodos
    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO request){
        ClienteModel clienteMod = mapper.toModel(request);
        repository.save(clienteMod);
        return mapper.toDTO(clienteMod);
    }

    @Override
    public List<ClienteResponseDTO> obtenerClientes(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO) // cliente -> mapper.toDTO(cliente)
                .toList();
    }

    @Override
    public ClienteResponseDTO clienteById(Long id_cliente){
        ClienteModel clienteMod = repository.findById(id_cliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return mapper.toDTO(clienteMod);
    }


    @Override
    public ClienteResponseDTO actualizarCliente(Long id_cliente, ClienteRequestDTO request){
        ClienteModel clienteMod = repository.findById(id_cliente).orElseThrow(() ->new RuntimeException("Cliente no encontrado"));
        clienteMod.setNombre(request.nombre());
        clienteMod.setDireccion(request.direccion());
        clienteMod.setTelefono(request.telefono());
        clienteMod.setCorreo(request.correo());
        clienteMod.setApellido(request.apellido());
        ClienteModel actualizado = repository.save(clienteMod);
        return mapper.toDTO(actualizado);
    }

    @Override
    public ClienteResponseDTO eliminarCliente(Long id_cliente){
        ClienteModel clienteMod = repository.findById(id_cliente)
                .orElseThrow(()->new RuntimeException("No encontrado"));
        repository.delete(clienteMod);
        return mapper.toDTO(clienteMod);

    }

    @Override
    public List<ClienteResponseDTO> findByDireccion(String direccion) {
        return repository.findByDireccion(direccion)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }


    @Override
    public List<ClienteResponseDTO> buscarByNombre(String nombre) {
        return repository.buscarByNombre(nombre)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

}
