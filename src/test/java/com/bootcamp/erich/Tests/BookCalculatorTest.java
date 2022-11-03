package com.bootcamp.erich.Tests;

import com.bootcamp.erich.Entity.Libro;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookCalculatorTest {

    @Test
    void calculator() {
        Libro libro  = new Libro(1L,"El señor de los","Author",200,new BigDecimal(240), LocalDate.now(),true);
        BookCalculator calculator = new BookCalculator();

        //Ejecutamos el comportamiento del testing
        BigDecimal precio = calculator.calculatorPrecio(libro);

        System.out.println(precio);
        //compraciones aserciones
        assertTrue(Double.parseDouble(String.valueOf(precio)) > 0 );
        assertEquals(240,Double.parseDouble(String.valueOf(precio)));
    }
}