package tech.ada.java;
import tech.ada.java.entity.Tarefa;
import tech.ada.java.service.TarefaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        boolean executando = true;
        TarefaService tarefaService = new TarefaService();
        Scanner sc = new Scanner(System.in);
        while (executando){

            System.out.println("################################################");
            System.out.println("=======Menu=======");
            System.out.println("1- Cadastrar tarefa");
            System.out.println("2- Listar tarefas pendentes");
            System.out.println("3- Buscar tarefa por título");
            System.out.println("4- Marcar tarefa compo concluida");
            System.out.println("5- Remover uma tarefa");
            System.out.println("0- Sair");
            System.out.println("################################################");

            System.out.println("Digite uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();


            executando = switch (opcao) {
                case 1 -> {
                    System.out.println("======CADASTRAR TAREFA======");
                    System.out.println("Digite o título da tarefa: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite a a descrição da tarefa: ");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a data de entrega (YYYY-MM-dd): ");
                    LocalDate dataEntrega = LocalDate.parse(sc.nextLine());

                    Tarefa tarefa = new Tarefa(titulo, descricao, dataEntrega);
                    tarefaService.adicionar(tarefa);

                    yield true;
                }
                case 2 -> {
                    System.out.println("======LISTAR TAREFAS PENDENTES======");
                    List<Tarefa> pendentes = tarefaService.listarTarefasPendentes();

                    if (pendentes.isEmpty()) {
                        System.out.println("Não há tarefas pendentes.");
                    } else {
                        pendentes.forEach(System.out::println);
                    }

                    yield true;
                }
                case 3 -> {
                    System.out.println("======BUSCAR TAREFA POR TITULO======");
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = sc.nextLine();
                    Tarefa tarefa = tarefaService.buscarTarefaPortitulo(titulo);
                    System.out.println(tarefa.toString());
                    yield true;
                }
                case 4 -> {
                    System.out.println("======MARCAR TAREFA COMO CONCLUÍDA======");
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = sc.nextLine();
                    if (tarefaService.concluir(titulo)) {
                        System.out.println("Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }

                    yield true;
                }
                case 5 -> {
                    System.out.println("======REMOVER TAREFA======");
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = sc.nextLine();
                    tarefaService.excluir(titulo);
                    yield true;
                }
                case 0 -> false;
                default -> {
                    System.out.println("Opção invalida");
                    yield true;
                }
            };
        }
    }
}