package com.example.demo.controller.logica;

import com.example.demo.db.jpa.OrdenJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.OrdenORM;
import com.example.demo.db.orm.ProductoORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdenService {

    private final OrdenJPA ordenJPA;
    private final ProductoJPA productoJPA;

    public boolean guardarOrden(Long producto, int cantidad ) {
        ProductoORM productoORM= productoJPA.findById(producto).orElseThrow(() -> new RuntimeException("No existe el producto"));
        if(productoORM.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }
        OrdenORM nuevaOrden = new OrdenORM();
        nuevaOrden.setProducto(productoORM);
        nuevaOrden.setFecha(LocalDate.now());
        nuevaOrden.setCantidad(cantidad);
        nuevaOrden.setPrecio(this.calcularPrecioOrden(producto, cantidad));
        productoORM.setStock(productoORM.getStock() - cantidad);
        return true;
    }

    public List<OrdenORM> consultarOrden(LocalDate fecha) {
        List<OrdenORM> list = ordenJPA.findByFecha(fecha);
        if(list.isEmpty()) {
            throw new ArithmeticException("No se encontraron las ventas");
        }
        return list;
    }

    public double calcularPrecioOrden(Long producto, int cantidad) {
        ProductoORM productoORM= productoJPA.findById(producto).orElseThrow();
        return productoORM.getPrecio()*cantidad;
    }
}
