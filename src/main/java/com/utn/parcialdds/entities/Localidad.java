package com.utn.parcialdds.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Localidad")
public class Localidad extends Base{

    @Column(name = "denominacion")
    private String denominacion;

}
