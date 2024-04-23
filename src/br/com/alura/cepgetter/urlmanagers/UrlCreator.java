package br.com.alura.cepgetter.urlmanagers;

import java.util.List;

public class UrlCreator {

    public void create(List<String> ceps, List<String> urlList){

        for (String cep : ceps) {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            urlList.add(url);
        }

    }

}
