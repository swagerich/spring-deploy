package com.bootcamp.erich.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
@Schema(name = "Entidad libro para representar un elemento didactico compuesto por laminas celulosa")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Clave ficticia autoincremental tipo Long")
    private Long id;
    private String titulo;
    private String autor;
    private int nroPages;
    @Schema(name = "Precio en soles, con dos decimales")
    private BigDecimal precio;
    private LocalDate releaseDate;
    private Boolean online;

}
