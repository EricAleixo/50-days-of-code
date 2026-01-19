package com.aleixo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Integer validationInputNumber(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        }
    }


    void main() throws InterruptedException {

        List<Integer> numeros = new ArrayList<>();

        boolean keyControlNumero = true;
        while (keyControlNumero){
            Integer numero = validationInputNumber("Digite um número para adicionar na lista: ");
            numeros.add(numero);

            boolean keyControlEscolha = true;

            while (keyControlEscolha){
                Integer escolha = validationInputNumber(
                        "Escolha a opção desejada:\n\n1 - Continuar\n2 - parar\n\nDigite: "
                );

                if(escolha == 1){
                    System.out.println("Lista atual: " + numeros);
                    Thread.sleep(1000);
                    keyControlEscolha = false;
                } else if(escolha == 2){
                    System.out.println("Parando o sistema...");
                    Thread.sleep(1000);
                    keyControlNumero = false;
                    keyControlEscolha = false;
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        }



        scanner.close();
    }
}
