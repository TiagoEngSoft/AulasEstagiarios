package com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.PF;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPF02 {

    public static void main(String[] args) {
        // Lista original de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 6, 8, 10, 11, 4, 5, 12, 13);

        // Funções de alta ordem declarativas
        Predicate<Integer> osImpares = n -> n % 2 == 1;
        Predicate<Integer> osMaioresQueCinco = n -> n > 5;
        Predicate<Integer> osQueSaoPrimos = n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0);

        List<Integer> sublistaFiltrada = numeros.stream()
                .filter(osImpares)
                .filter(osMaioresQueCinco)
                .filter(osQueSaoPrimos)
                .collect(Collectors.toList());

        // Exibe a sublista
        System.out.println("Números ímpares, maiores que 5 e primos: " + sublistaFiltrada);
    }
}
