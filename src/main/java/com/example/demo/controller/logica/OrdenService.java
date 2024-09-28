package com.example.demo.controller.logica;

import com.example.demo.db.jpa.OrdenJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdenService {

    private final OrdenJPA ordenJPA;
}
