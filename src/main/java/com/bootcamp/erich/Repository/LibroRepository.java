package com.bootcamp.erich.Repository;

import com.bootcamp.erich.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
