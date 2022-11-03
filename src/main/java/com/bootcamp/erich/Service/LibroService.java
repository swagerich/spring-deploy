package com.bootcamp.erich.Service;

import com.bootcamp.erich.Entity.Libro;
import com.bootcamp.erich.Exception.NotFoundException;
import com.bootcamp.erich.Repository.LibroRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibroService implements LibroServiceImpl {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro crearLibro(Libro libro) {
        if(libro.getId() !=null){
            throw  new NotFoundException("ID EXISTE!");
        }
        return libroRepository.save(libro);
    }

    @Override
    public Libro findName(Long name) {
        return libroRepository.findById(name).orElseThrow(() -> new NotFoundException("Libro no encontrado"));
    }

    @Override
    public Libro update(Long id,Libro libro) {
    /*    return libroRepository.findById(id).map(li -> {
            li.setTitulo(libro.getTitulo());
            li.setAutor(libro.getAutor());
            li.setNroPages(libro.getNroPages());
            li.setPrecio(libro.getPrecio());
            return libroRepository.save(li);
        }).orElseThrow(() -> new NotFoundException("No encontrado"));*/
        /*if(libro.getId() != null){
            throw  new NotFoundException("No existe el book");
        }
        if(!libroRepository.existsById(libro.getId())){
            throw  new NotFoundException("No existe el book");
        }*/
        /*if(libroRepository.findById(id).isPresent()){
            Libro libro1  = new Libro();
           // libro1.setId(libro.getId());
            libro1.setTitulo(libro.getTitulo());
            libro1.setAutor(libro.getAutor());
            libro1.setPrecio(libro.getPrecio());
            return libroRepository.save(libro);
        }*/
        return libroRepository.findById(id).map(up ->{
            libro.setTitulo(up.getTitulo());
            libro.setAutor(up.getAutor());
            return libroRepository.save(up);
        }).orElseThrow(() -> new NotFoundException("aaaa"));
    }

    @Override
    public void delete(Long id) {
        if(!libroRepository.existsById(id)){
           throw  new NotFoundException("No hay data ");
        }
         libroRepository.findById(id).map(ids -> {
            libroRepository.deleteById(ids.getId());
            return "";
        });
    }
}
