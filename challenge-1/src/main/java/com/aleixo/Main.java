package com.aleixo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Double validationInputNumber(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Entrada vazia! Digite um número.");
                continue;
            }

            try {
                Double value = Double.parseDouble(input);

                if (value.isNaN() || value.isInfinite()) {
                    System.out.println("Número inválido!");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Você digitou letras ou símbolos.");
            }
        }
    }

    static Double maiorNumero(List<Double> numeros) {
        validarListaVazia(numeros);

        Double maior = numeros.get(0);
        for (Double n : numeros) {
            if (n > maior) maior = n;
        }
        return maior;
    }

    static Double menorNumero(List<Double> numeros) {
        validarListaVazia(numeros);

        Double menor = numeros.get(0);
        for (Double n : numeros) {
            if (n < menor) menor = n;
        }
        return menor;
    }

    static Double somaNumeros(List<Double> numeros) {
        validarListaVazia(numeros);

        Double soma = 0.0;
        for (Double n : numeros) soma += n;
        return soma;
    }

    static Double mediaNumeros(List<Double> numeros) {
        validarListaVazia(numeros);
        return somaNumeros(numeros) / numeros.size();
    }

    static void validarListaVazia(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalStateException("A lista está vazia! Não é possível calcular.");
        }
    }

    static void requirementsOfArrayPrint(List<Double> numeros) {
        if (numeros.isEmpty()) {
            System.out.println("\nNenhum número foi informado.");
            return;
        }

        System.out.println("\nRESULTADOS:");
        System.out.println("Soma dos valores: " + somaNumeros(numeros));
        System.out.println("Maior número: " + maiorNumero(numeros));
        System.out.println("Menor número: " + menorNumero(numeros));
        System.out.println("Média: " + mediaNumeros(numeros));
    }

    static void main(String[] args) throws InterruptedException {

        List<Double> numeros = new ArrayList<>();

        boolean keyControlNumero = true;

        while (keyControlNumero) {
            Double numero = validationInputNumber("Digite um número para adicionar na lista: ");
            numeros.add(numero);

            boolean keyControlEscolha = true;

            while (keyControlEscolha) {
                Double escolha = validationInputNumber(
                        "Escolha a opção desejada:\n\n1 - Continuar\n2 - Parar\n\nDigite: "
                );

                if (escolha == 1.0) {
                    System.out.println("Lista atual: " + numeros);
                    Thread.sleep(500);
                    keyControlEscolha = false;

                } else if (escolha == 2.0) {
                    System.out.println("Parando o sistema...");
                    Thread.sleep(500);
                    keyControlNumero = false;
                    keyControlEscolha = false;

                } else {
                    System.out.println("Opção inválida! Digite apenas 1 ou 2.");
                }
            }
        }

        requirementsOfArrayPrint(numeros);
        scanner.close();
    }
}
