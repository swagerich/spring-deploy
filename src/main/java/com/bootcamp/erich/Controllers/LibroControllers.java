package com.bootcamp.erich.Controllers;

import com.bootcamp.erich.Entity.Libro;
import com.bootcamp.erich.Service.LibroServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class LibroControllers {

    @Value("${app.message}")
    String mensage;
    @Autowired
    private LibroServiceImpl libroService;

    @GetMapping("/listar")
    public List<?> findAll() {
        System.out.println(mensage);
        return libroService.listar();
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.crearLibro(libro), HttpStatus.CREATED);
    }

    @Operation(summary = "Busquedad por id")
    @GetMapping("/libro/{id}")
    public Libro buscar(@Parameter(name = "Clave primary tipo long") @PathVariable Long id) {
        return libroService.findName(id);
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.update(id, libro), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> delete(@PathVariable Long id) {

        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
