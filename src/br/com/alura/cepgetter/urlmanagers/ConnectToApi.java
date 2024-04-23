package br.com.alura.cepgetter.urlmanagers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectToApi {

    //"https://viacep.com.br/ws/01001000/json/"

    public String search(String uri){

        if(uri.equals("")) {
            return "";
        }

        try (HttpClient client = HttpClient.newHttpClient()){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        }catch(InterruptedException | IOException e){
            System.out.println("Erro na conexão com a api");
            return "";
        }
    }

}
