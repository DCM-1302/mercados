package com.example.demo.controller.logica;

import com.example.demo.db.jpa.OrdenJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.ProductoORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoService {

 private final OrdenJPA ordenJPA;
 private final ProductoJPA productoJPA;

 public boolean guardarProducto(String nombre, String descripcion, int precio,int stock,String talla, String marca) {
  ProductoORM nuevoProducto = new ProductoORM();
  nuevoProducto.setNombre(nombre);
  nuevoProducto.setDescripcion(descripcion);
  nuevoProducto.setPrecio(precio);
  nuevoProducto.setStock(stock);
  nuevoProducto.setTalla(talla);
  nuevoProducto.setMarca(marca);
  productoJPA.save(nuevoProducto);
  return true;
 }
}
