package com.example.demo.controller.dto;

import com.example.demo.controller.logica.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;
    List<ProductoDTO> productos= new ArrayList<>();

    @PostMapping(path="/producto")
    public String guardarProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.guardarProducto(productoDTO.nombre(),productoDTO.descripcion(),productoDTO.precio(),productoDTO.stock(),productoDTO.talla(),productoDTO.marca());
        return "Producto creado";
    }

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productos;
    }
}
