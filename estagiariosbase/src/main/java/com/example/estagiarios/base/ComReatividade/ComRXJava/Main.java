package com.example.estagiarios.base.ComReatividade.ComRXJava;


import com.example.estagiarios.base.ComReatividade.ComRXJava.service.*;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PessoaService service = new PessoaService();

        // Criar Pessoas
        service.criarPessoa(1L, "Alice")
            .subscribe(p -> System.out.println("Criada: " + p));

        service.criarPessoa(2L, "Bob")
            .subscribe(p -> System.out.println("Criada: " + p));

        service.criarPessoa(3L, "Belmiro")
            .subscribe(p -> System.out.println("Criada: " + p));
      

        Thread.sleep(100); // Espera um pouco para os dados serem inseridos

        // Listar todas
        System.out.println(" ");
        service.listarPessoas()
            .subscribeOn(Schedulers.io())
            .subscribe(p -> System.out.println("Encontrada: " + p));
        

        // Buscar por ID
        service.buscarPessoa(1L)
            .subscribe(
                p -> System.out.println("\nBuscada por ID: " + p),
                Throwable::printStackTrace,
                () -> System.out.println("Pessoa não encontrada")
            );

        // Atualizar Pessoa
        service.atualizarPessoa(2L, "Robert")
            .subscribe(p -> System.out.println("Atualizada: " + p));

        // Deletar Pessoa
        service.deletarPessoa(1L)
            .subscribe(() -> System.out.println("Pessoa deletada"));

        Thread.sleep(500); // Espera para ver todos os resultados

        // Listar todas
        System.out.println(" ");
        service.listarPessoas()
            .subscribeOn(Schedulers.io())
            .subscribe(p -> System.out.println("Encontrada: " + p));
    }
}
