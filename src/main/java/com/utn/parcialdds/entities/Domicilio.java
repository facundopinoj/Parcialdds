package com.utn.parcialdds.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Domicilio")
public class Domicilio extends Base{


    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    //Domicilio a localidad - Relacion
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}
