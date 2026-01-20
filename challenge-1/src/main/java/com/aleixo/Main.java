package com.aleixo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Double validationInputNumber(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        }
    }

    static Double maiorNumero(List<Double> numeros) {
        Double maior = numeros.get(0);

        for (Double n : numeros) {
            if (n > maior) {
                maior = n;
            }
        }
        return maior;
    }

    static Double menorNumero(List<Double> numeros) {
        Double menor = numeros.get(0);

        for (Double n : numeros) {
            if (n < menor) {
                menor = n;
            }
        }
        return menor;
    }

    static Double mediaNumeros(List<Double> numeros) {
        return somaNumeros(numeros) / numeros.size();
    }

    static Double somaNumeros(List<Double> numeros) {
        Double soma = 0.0;

        for (Double n : numeros) {
            soma += n;
        }
        return soma;
    }
    static void requirementsOfArrayPrint(List<Double> numeros) {
        System.out.println("\nRESULTADOS:");
        System.out.println("Soma dos valores: " + somaNumeros(numeros));
        System.out.println("Maior número: " + maiorNumero(numeros));
        System.out.println("Menor número: " + menorNumero(numeros));
        System.out.println("Média: " + mediaNumeros(numeros));
    }


    void main() throws InterruptedException {

        List<Double> numeros = new ArrayList<>();

        boolean keyControlNumero = true;
        while (keyControlNumero){
            Double numero = validationInputNumber("Digite um número para adicionar na lista: ");
            numeros.add(numero);

            boolean keyControlEscolha = true;

            while (keyControlEscolha){
                Double escolha = validationInputNumber(
                        "Escolha a opção desejada:\n\n1 - Continuar\n2 - parar\n\nDigite: "
                );

                if(escolha == 1.0){
                    System.out.println("Lista atual: " + numeros);
                    Thread.sleep(1000);
                    keyControlEscolha = false;
                } else if(escolha == 2.0){
                    System.out.println("Parando o sistema...");
                    Thread.sleep(1000);
                    keyControlNumero = false;
                    keyControlEscolha = false;
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        }

        requirementsOfArrayPrint(numeros);

        scanner.close();
    }
}
