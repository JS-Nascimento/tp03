package br.edu.infnet.tp03.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
