package br.com.alura.cepgetter.main;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private String userResponse;
    private Scanner reader;

    public Menu() {
        reader = new Scanner(System.in);
        userResponse = "";
    }

    public void insertCep(List<String> cepList) {

        while (!userResponse.equalsIgnoreCase("c")) {

            System.out.println("Insira o cep.");
            System.out.println("Escreva 'c' para PARAR de adicionar.");

            //lê a escolha do usuário
            userResponse = reader.nextLine();

            //caso o usuário escreva "c" o loop acaba caso contrário cep recebe o cep
            if (userResponse.equalsIgnoreCase("c")) {
                break;
            } else {
                if (userResponse.length() > 7) {
                    cepList.add(userResponse);
                }
            }
        }
    }

}
