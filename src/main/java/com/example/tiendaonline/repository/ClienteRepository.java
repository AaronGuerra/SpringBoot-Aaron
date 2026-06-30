package com.example.tiendaonline.repository;


import com.example.tiendaonline.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    // Query Method
    List<ClienteModel> findByDireccion(String direccion);

    // Query
    @Query("SELECT c FROM ClienteModel c WHERE c.nombre = :nombre")
    List<ClienteModel> buscarByNombre(@Param("nombre") String nombre);

}
