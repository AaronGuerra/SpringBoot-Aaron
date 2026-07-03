package com.example.tiendaonline.service;

import com.example.tiendaonline.dto.ProductoRequestDTO;
import com.example.tiendaonline.dto.ProductoResponseDTO;
import com.example.tiendaonline.exception.RecursoNoEncontradoException;
import com.example.tiendaonline.mapper.ProductoMapper;
import com.example.tiendaonline.model.ProductoModel;
import com.example.tiendaonline.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    // Métodos
    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO request){
        ProductoModel productoMod = mapper.toModel(request);
        repository.save(productoMod);
        return mapper.toDTO(productoMod);
    }

    @Override
    public List<ProductoResponseDTO> obtenerProductos(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO) // producto -> mapper.toDTO(producto)
                .toList();
    }

    @Override
    public ProductoResponseDTO productoById(Long id_producto){
        ProductoModel productoMod = repository.findById(id_producto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado"));
        return mapper.toDTO(productoMod);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long id_producto, ProductoRequestDTO request){
        ProductoModel productoMod = repository.findById(id_producto).orElseThrow(() ->new RecursoNoEncontradoException("Producto no encontrado"));
        productoMod.setNombre(request.nombre());
        productoMod.setDescripcion(request.descripcion());
        productoMod.setPrecio(request.precio());
        productoMod.setStock(request.stock());
        productoMod.setCategoria(request.categoria());
        ProductoModel actualizado = repository.save(productoMod);
        return mapper.toDTO(actualizado);
    }

    @Override
    public ProductoResponseDTO eliminarProducto(Long id_producto){
        ProductoModel productoMod = repository.findById(id_producto)
                .orElseThrow(()->new RuntimeException("No encontrado"));
        repository.delete(productoMod);
        return mapper.toDTO(productoMod);

    }

   @Override
    public List<ProductoResponseDTO> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }


    @Override
    public List<ProductoResponseDTO> buscarByNombre(String nombre) {
        return repository.buscarByNombre(nombre)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

}
