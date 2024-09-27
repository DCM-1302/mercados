package com.example.demo.controller.dto;

import com.example.demo.controller.logica.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @PostMapping(path="Producto")
    public String guardarProducto(@RequestBody ProductoDTO productoDTO) {

    }
}
