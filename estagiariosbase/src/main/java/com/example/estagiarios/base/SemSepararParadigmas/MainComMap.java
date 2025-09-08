package com.example.estagiarios.base.SemSepararParadigmas;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainComMap {
    public static void main(String[] args) {
        Map<String, Double> alunos = new HashMap<>();
        alunos.put("Ana", 1.0);
        alunos.put("Bruno", 3.0);
        alunos.put("Carlos", 5.0);
        alunos.put("Daniela", 7.0);
        alunos.put("Eduardo", 9.0);
        alunos.put("Fernanda", 2.0);
        alunos.put("Gustavo", 8.0);
        alunos.put("Helena", 4.0);
        alunos.put("Igor", 6.0);
        alunos.put("Julia", 10.0);

        ServicoGerenciadorNumeros service = new ServicoGerenciadorNumeros();

        // Cálculo da média 
        service.calcularMedia(alunos);

        // Filtrar maiores que 5 
        service.filtrarMaioresQue5(alunos);

        // Filtrar maiores que 6 
        Map<String, Double> maioresQue6 = alunos.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 6)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println("Alunos com nota maior que 6 : " + maioresQue6);

        // Filtrar maiores que 8 
        Map<String, Double> maioresQue8 = alunos.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 8)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println("Alunos com nota maior que 8 : " + maioresQue8);
    }
}

class ServicoGerenciadorNumeros {

    // Calcular a média das notas 
    public void calcularMedia(Map<String, Double> alunos) {
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("Média das notas : 0.00");
            return;
        }

        double soma = 0.0;
        int quantidade = 0;

        for (Double nota : alunos.values()) {
            soma += nota;
            quantidade++;
        }

        System.out.println("Média das notas : " + (soma / quantidade));
    }

    // Filtrar alunos com nota > 5 
    public void filtrarMaioresQue5(Map<String, Double> alunos) {
        Map<String, Double> resultado = new HashMap<>();

        for (Map.Entry<String, Double> entry : alunos.entrySet()) {
            if (entry.getValue() > 5) {
                resultado.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Alunos com nota maior que 5 : " + resultado);
    }
}