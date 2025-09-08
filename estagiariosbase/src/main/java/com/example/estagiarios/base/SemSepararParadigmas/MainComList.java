package com.example.estagiarios.base.SemSepararParadigmas;

import java.util.*;
import java.util.stream.Collectors;

public class MainComList {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 3, 5, 7, 9, 2, 8, 4, 6, 10);

        NumeroService service = new NumeroService();

        //Cálculo da média
        double media = service.calcularMedia(numeros);
        System.out.println("Média de todos os números: " + media);

        //Filtrar maiores que 5
        List<Integer> maioresQue5 = service.filtrarMaioresQue5(numeros);
        System.out.println("Números maiores que 5: " + maioresQue5);

        //Filtrar maiores que 6
        List<Integer> maioresQue6 = numeros.stream()
                .filter(n -> n > 6)
                .collect(Collectors.toList());
        System.out.println("Números maiores que 6 : " + maioresQue6);

        //Filtrar maiores que 8
        List<Integer> maioresQue8 = numeros.stream()
                .filter(n -> n > 8)
                .collect(Collectors.toList());
        System.out.println("Números maiores que 8 : " + maioresQue8);
    }

}

class NumeroService {

    // Método imperativo para filtrar maiores que 5
    public List<Integer> filtrarMaioresQue5(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero > 5) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    // Método imperativo para calcular a média
    public double calcularMedia(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }

        int soma = 0;
        for (Integer numero : numeros) {
            soma += numero;
        }

        return (double) soma / numeros.size();
    }
}
