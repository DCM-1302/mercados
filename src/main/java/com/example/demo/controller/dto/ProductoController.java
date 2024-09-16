package com.example.demo.controller.dto;

import com.example.demo.controller.logica.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;
}
