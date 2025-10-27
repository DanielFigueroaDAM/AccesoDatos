package model;

import jakarta.persistence.*;

public class EPokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPokedex;

    @Column(name = "nome",nullable = false,length = 50)
    private String nome;

    @



}
