package com.bootcamp.erich.Service;

import com.bootcamp.erich.Entity.Libro;

import java.util.List;
import java.util.Optional;


public interface LibroServiceImpl {
    List<Libro> listar();

    Libro crearLibro(Libro libro);

    Libro findName(Long name);

    Libro update(Long id,Libro libro);
    void delete(Long id);
}
