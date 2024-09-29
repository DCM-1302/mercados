package com.example.demo.controller.logica;

import com.example.demo.db.jpa.CategoriaJPA;
import com.example.demo.db.jpa.ProductoJPA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    ProductoJPA productoJPA;
    @Mock
    CategoriaJPA categoriaJPA;

    @InjectMocks
    ProductoService service;


    @Test
    void GivenNoExisteLaCategoria_When_GuardarProducto_Then_ThrowRuntimeException() {
        Long categoriaId = 1L;
        Mockito.when(categoriaJPA.findById(categoriaId)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class,
                ()->service.guardarProducto("Traje Kira","Lorem ipsum",400000,categoriaId,80,"XL","Morioh")
        );
        Mockito.verify(categoriaJPA, Mockito.times(1)).findById(categoriaId);
        Mockito.verify(productoJPA, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    void GivenExisteLaCategoria_When_GuardarProducto_Then_ReturnTrue() {

    }
}