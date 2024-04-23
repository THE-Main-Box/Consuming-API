package br.com.alura.cepgetter.jsonmanagers;

import br.com.alura.cepgetter.records.CepData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUsage {

    private Gson gson;

    public GsonUsage(){

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

    }

    public CepData convertFile(String response){

        return gson.fromJson(response, CepData.class);

    }



}
