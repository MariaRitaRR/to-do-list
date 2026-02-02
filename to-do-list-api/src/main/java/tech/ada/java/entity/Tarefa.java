package tech.ada.java.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluido;

    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluido = false;
    }




    public Tarefa buscarTarefa(String titulo, List<Tarefa> tarefas) {
        for (Tarefa tarefa : tarefas) {
            if(tarefa.getTitulo().equals(titulo))  return tarefa;
        }
        return null;
    }
    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", concluido=" + concluido +
                '}';
    }


}
