package tech.ada.java.service;

import lombok.Getter;
import lombok.Setter;
import tech.ada.java.entity.Tarefa;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefa){

        tarefas.add(tarefa);

    }

    public List<Tarefa> listarTarefas(){
        return tarefas;
    }

    public List<Tarefa> listarTarefasPendentes(){
        List<Tarefa> tarefasPendentes = new ArrayList<>();
        for(Tarefa tarefa : tarefas){
            if (!tarefa.isConcluido()){
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public Tarefa buscarTarefaPortitulo(String titulo){
        for(Tarefa tarefa : tarefas){
            if (tarefa.getTitulo().equalsIgnoreCase(titulo.trim())) return tarefa;
        }
        return null;
    }

    public Tarefa buscarTarefaPorId(int id){
        for(Tarefa tarefa : tarefas){
            if(tarefa.getId() == id)  return tarefa;
        }
        return null;
    }

    public boolean concluir(String titulo){
        Tarefa tarefa = buscarTarefaPortitulo(titulo);
        if (tarefa != null){
            tarefa.setConcluido(true);
            return true;
        }
        return false;
    }


    public boolean excluir(String titulo){
        return tarefas.removeIf(t ->
                t.getTitulo().equalsIgnoreCase(titulo.trim())
        );
    }

}
