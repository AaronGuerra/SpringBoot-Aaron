package com.example.tiendaonline.mapper;


import com.example.tiendaonline.dto.ProductoRequestDTO;
import com.example.tiendaonline.dto.ProductoResponseDTO;
import com.example.tiendaonline.model.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoModel toModel(ProductoRequestDTO request){
        ProductoModel productoMod = new ProductoModel();
        productoMod.setNombre(request.nombre());
        productoMod.setPrecio(request.precio());
        productoMod.setCategoria(request.categoria());
        return productoMod;
    }

    public ProductoResponseDTO toDTO(ProductoModel productoMod){
        return ProductoResponseDTO.builder()
                .id_producto(productoMod.getId_producto())
                .nombre(productoMod.getNombre())
                .precio(productoMod.getPrecio())
                .categoria(productoMod.getCategoria())
                .build();
    }



}
