package com.example.demo.db.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="ordenes")
@Entity
@Data
@NoArgsConstructor
public class OrdenORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private UsuarioORM cliente;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.PENDIENTE;

    public enum Estado {
        PENDIENTE,
        PROCESADO,
        ENVIADO,
        ENTREGADO,
        CANCELADO
    }
}
