package com.example.tiendaonline.security;

import com.example.tiendaonline.exception.RecursoNoEncontradoException;
import com.example.tiendaonline.model.ClienteModel;
import com.example.tiendaonline.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteDetailsService implements UserDetailsService {

    private ClienteRepository cRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws RecursoNoEncontradoException {
        ClienteModel clienteMod = cRepository.findByCorreo(username).orElseThrow(()-> new RecursoNoEncontradoException("Cliente no encontrado"));
        return new ClienteDetails(clienteMod);
    }





}
