package com.example.demo.controller.logica;

import com.example.demo.db.jpa.OrdenJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.OrdenORM;
import com.example.demo.db.orm.ProductoORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

class OrdenServiceTest {

    @Mock
    OrdenJPA ordenJPA;
    @Mock
    ProductoJPA productoJPA;

    @InjectMocks
    OrdenService service;

    @Test
    void Given_ExisteElProducto_When_GuardarOrden(){
        ProductoORM producto = new ProductoORM();
        producto.setId(1L);
        producto.setStock(10);

        OrdenORM ordenSimulada = new OrdenORM();
        ordenSimulada.setId(1L);
        ordenSimulada.setProducto(producto);
        ordenSimulada.setCantidad(2);
        ordenSimulada.setFecha(LocalDate.now());
        Mockito.when(productoJPA.findById(1L)).thenReturn(Optional.of(producto));
        Mockito.when(ordenJPA.save(Mockito.any())).thenReturn(ordenSimulada);

        OrdenORM orden = service.guardarOrden(producto.getId(),ordenSimulada.getCantidad());

        Assertions.assertNotNull(orden);
        Assertions.assertEquals(orden.getId(),ordenSimulada.getId());
        Mockito.verify(ordenJPA, Mockito.times(1)).save(ordenSimulada);
        Mockito.verify(ordenJPA).save(Mockito.any());
    }
}