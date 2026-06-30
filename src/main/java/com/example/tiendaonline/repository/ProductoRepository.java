package com.example.tiendaonline.repository;

import com.example.tiendaonline.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {


    // Query Method
    List<ProductoModel> findByCategoria (String categoria);

    // Query
    @Query("SELECT p FROM ProductoModel p WHERE p.nombre = :nombre")
    List<ProductoModel> buscarByNombre(@Param("nombre") String nombre);


}
