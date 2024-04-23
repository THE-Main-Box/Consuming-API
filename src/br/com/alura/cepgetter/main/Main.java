package br.com.alura.cepgetter.main;

import br.com.alura.cepgetter.urlmanagers.ConnectToApi;
import br.com.alura.cepgetter.jsonmanagers.GsonUsage;
import br.com.alura.cepgetter.jsonmanagers.WriteJson;
import br.com.alura.cepgetter.records.CepData;
import br.com.alura.cepgetter.urlmanagers.UrlCreator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> cepList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        List<CepData> jsonCep = new ArrayList<>();

        ConnectToApi connect = new ConnectToApi();
        UrlCreator urlCreator = new UrlCreator();
        GsonUsage gsonUsage = new GsonUsage();
        WriteJson writer = new WriteJson();
        Menu menu = new Menu();
        menu.insertCep(cepList);

        String searchResponse;

        urlCreator.create(cepList, urlList);

        for (String url : urlList) {
            searchResponse = connect.search(url);

            if (!searchResponse.equals("")) {
                jsonCep.add(gsonUsage.convertFile(searchResponse));
                System.out.println(url);

            }

        }
//        42713710


        writer.write(jsonCep, "ceps.json");


    }
}
