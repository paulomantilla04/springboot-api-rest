package com.application.rest.SpringBootRestFootball.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugador")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "edad")
    private int age;

    @Column(name = "dorsal")
    private int number;

    @Column(name = "goles")
    private int goals;

    @Column(name = "asistencias")
    private int assists;

    @Column(name = "estado")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_club", nullable = false)
    @JsonIgnore
    private Club club;
}
