package com.example.demo.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenJPA extends JpaRepository<OrdenJPA,Long> {
}
