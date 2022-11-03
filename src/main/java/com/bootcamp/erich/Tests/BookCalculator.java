package com.bootcamp.erich.Tests;

import com.bootcamp.erich.Entity.Libro;

import java.math.BigDecimal;

public class BookCalculator {

    public BigDecimal calculatorPrecio(Libro libro) {
        BigDecimal precio = libro.getPrecio();

        if (libro.getNroPages() > 300) {
            precio = precio.add(new BigDecimal(5));
        }
        return precio;
    }
}
