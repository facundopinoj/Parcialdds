package com.utn.parcialdds.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Libro")
public class Libro extends Base {

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @Column(name = "titulo")
    private String titulo;

    //Libro a autor - Relacion
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;


}
