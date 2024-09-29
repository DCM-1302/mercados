package com.example.demo.controller.integration;

import com.example.demo.controller.dto.ProductoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void TestProductoController() {
        ProductoDTO nuevoProducto = new ProductoDTO("Giorno","Giovanna",5000,1L,10,"XS","Passione" );
        ResponseEntity<String> respuestaInsercion = restTemplate.postForEntity("/producto",nuevoProducto, String.class);
        System.out.println(respuestaInsercion);
        Assertions.assertEquals("Cancion guardada", respuestaInsercion.getBody());
        ResponseEntity<List> resultado = restTemplate.getForEntity("/mercancia", List.class);
        Assertions.assertFalse(Objects.requireNonNull(resultado.getBody()).isEmpty());
        Assertions.assertTrue(resultado.getStatusCode().is2xxSuccessful());

    }
}
