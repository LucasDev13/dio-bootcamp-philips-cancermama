package br.com.project.cancermama.dataproviders.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_faixa_etaria")
public class FaixaEtaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private Long faixa_i;
    private Long faixa_n;
    private String descricao;

    public FaixaEtaria() {
    }

    public FaixaEtaria(Long faixa_i, Long faixa_n, String descricao) {
        this.faixa_i = faixa_i;
        this.faixa_n = faixa_n;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Long getFaixa_i() {
        return faixa_i;
    }

    public void setFaixa_i(Long faixa_i) {
        this.faixa_i = faixa_i;
    }

    public Long getFaixa_n() {
        return faixa_n;
    }

    public void setFaixa_n(Long faixa_n) {
        this.faixa_n = faixa_n;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
