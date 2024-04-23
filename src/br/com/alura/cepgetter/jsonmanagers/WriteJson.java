package br.com.alura.cepgetter.jsonmanagers;

import br.com.alura.cepgetter.records.CepData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJson {

    private Gson gson;
    private String currentDirectory;
    private String fileDirectory;
    private File cepsFile;

    public WriteJson() {

        currentDirectory = new File(".").getAbsolutePath();
        fileDirectory = currentDirectory + "/src/br/com/alura/cepgetter/cepsarchive/";




        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public void write(List<CepData> json, String file) {

        fileDirectory += file;
        cepsFile = new File(fileDirectory);

        try (FileWriter writer = new FileWriter(cepsFile)) {

            gson.toJson(json, writer);
            writer.write("\n");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

}
