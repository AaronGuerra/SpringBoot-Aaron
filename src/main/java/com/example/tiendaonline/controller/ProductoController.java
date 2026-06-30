package com.example.tiendaonline.controller;

import com.example.tiendaonline.dto.ProductoRequestDTO;
import com.example.tiendaonline.dto.ProductoResponseDTO;
import com.example.tiendaonline.service.ProductoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @PostMapping
    public ProductoResponseDTO createProducto(@Valid @RequestBody ProductoRequestDTO request) {
        return service.crearProducto(request);
    }

    @GetMapping
    public List<ProductoResponseDTO> obtenerProductos() {
        return service.obtenerProductos();
    }

    @GetMapping("/{id_producto}")
    public ProductoResponseDTO productoById(@PathVariable Long id_producto) {
        return service.productoById(id_producto);
    }

    @PutMapping("/{id_producto}")
    public ProductoResponseDTO actualizarProducto(@PathVariable Long id_producto, @Valid @RequestBody ProductoRequestDTO request) {
        return service.actualizarProducto(id_producto,request);
    }

    @DeleteMapping("/{id_producto}")
    public ProductoResponseDTO eliminarProducto(@PathVariable Long id_producto){
        return service.eliminarProducto(id_producto);
    }

    @GetMapping("/nombres/{nombre}")
    public List<ProductoResponseDTO> ListaPorNombres(@PathVariable String nombre){
        return service.buscarByNombre(nombre);
    }

    @GetMapping("/categorias/{categoria}")
    public List<ProductoResponseDTO> ListaPorCategoria(@PathVariable String categoria) {
        return service.findByCategoria(categoria);
    }

}