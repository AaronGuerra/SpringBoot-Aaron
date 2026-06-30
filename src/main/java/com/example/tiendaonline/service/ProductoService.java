package com.example.tiendaonline.service;


import com.example.tiendaonline.dto.ProductoRequestDTO;
import com.example.tiendaonline.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO crearProducto(ProductoRequestDTO producto);
    List<ProductoResponseDTO> obtenerProductos();
    ProductoResponseDTO productoById(Long id_producto);
    ProductoResponseDTO actualizarProducto (Long id_producto, ProductoRequestDTO request);
    ProductoResponseDTO eliminarProducto(Long id_producto);
    List<ProductoResponseDTO> findByCategoria(String categoria);
    List<ProductoResponseDTO> buscarByNombre(String nombre);
}
