package br.com.project.cancermama.entrypoints.response;

import br.com.project.cancermama.dataproviders.entities.Regiao;

import java.util.List;

public class RegiaoResponse {

    private static String regiao;
    private static Long qnt_exames;

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

    /*public static void toResponse(List<Regiao> model){
        for (Regiao list: model) {
            regiao = model.getRegiao();
            qnt_exames = model.getQnt_exames();
        }
    }*/

}
