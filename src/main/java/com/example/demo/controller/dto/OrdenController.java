package com.example.demo.controller.dto;

import com.example.demo.controller.logica.OrdenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrdenController {

    private OrdenService ordenService;

}