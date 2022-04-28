package br.com.project.cancermama.dataproviders.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_regiao")
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String regiao;
    private Long qnt_exames;

    public Regiao() {
    }

    public Regiao(String regiao, Long qnt_exames) {
        this.regiao = regiao;
        this.qnt_exames = qnt_exames;
    }

    public Long getId() {
        return id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getQnt_exames() {
        return qnt_exames;
    }

    public void setQnt_exames(Long qnt_exames) {
        this.qnt_exames = qnt_exames;
    }
}
