package com.example.estagiarios.base.ComSeparacaoParadigmas.PF;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainPF {
    public static void main(String[] args) {

        // Regra descrita por HOF
        Predicate<Double> alunosDeRecuperacao = nota -> (nota > 5) && (nota < 6);
        Predicate<Double> alunosMedia = nota -> (nota > 6) && (nota < 8);
        Predicate<Double> alunosPremio = nota -> (nota > 8);

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

        // Cálculo da média (funcional, print direto)
        alunos.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresentOrElse(
                        media -> System.out.println("Média da Tuma: " + media),
                        () -> System.out.println("Média da Tuma: 0.0"));

        // Filtros com pipelines + HOFs + print direto
        System.out.println("Alunos em recuperação: " +
                alunos.entrySet().stream()
                        .filter(entry -> alunosDeRecuperacao.test(entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        System.out.println("Alunos medianos: " +
                alunos.entrySet().stream()
                        .filter(entry -> alunosMedia.test(entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        System.out.println("Alunos premio: " +
                alunos.entrySet().stream()
                        .filter(entry -> alunosPremio.test(entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        // ***********************************************************************************
        // Única pipeline funcional que resolve tudo                               - Desafio -
        // ***********************************************************************************
        System.out.println("\n***** Única pipeline funcional que resolve tudo *****  \n");
        
        System.out.println(
                alunos.entrySet().stream().collect(
                    Collectors.teeing(

                        // Primeiro coletor: calcula a média das notas
                        Collectors.averagingDouble(Map.Entry::getValue),

                        // Segundo coletor: separa os alunos em três grupos
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        Map.Entry::getKey, // nome do aluno
                                        Map.Entry::getValue // nota do aluno
                                ),
                                mapa -> {
                                    Map<String, Map<String, Double>> resultado = new HashMap<>();

                                    // Alunos em recuperação
                                    resultado.put("Recuperação", mapa.entrySet().stream()
                                            .filter(e -> alunosDeRecuperacao.test(e.getValue()))
                                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                                    // Alunos na média
                                    resultado.put("Média", mapa.entrySet().stream()
                                            .filter(e -> alunosMedia.test(e.getValue()))
                                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                                    // Alunos com nota excelente (prêmio)
                                    resultado.put("Prêmio", mapa.entrySet().stream()
                                            .filter(e -> alunosPremio.test(e.getValue()))
                                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                                    return resultado;
                                }),

                        // Função combinadora: junta a média com os grupos e monta o texto final
                        (media, categorias) -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Média da Turma: ").append(media).append("\n");

                            // Para cada categoria, imprime os alunos que pertencem a ela
                            categorias.forEach((categoria, grupo) -> sb.append("Alunos ").append(categoria).append(": ")
                                    .append(grupo).append("\n"));

                            return sb.toString(); // Resultado final formatado
                        }
                    )
                )
        );
    }
}
