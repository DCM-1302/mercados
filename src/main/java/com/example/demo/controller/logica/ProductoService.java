package com.example.demo.controller.logica;

import com.example.demo.db.jpa.ProductoJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoService {

 private final ProductoJPA productoJPA;
}
