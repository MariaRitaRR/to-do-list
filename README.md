# ToDo List em Java

Aplicação de ToDo List desenvolvida em Java com foco em boas práticas de
arquitetura, separação de responsabilidades e futura migração para Spring Boot.

## Funcionalidades

- Cadastrar tarefa
- Listar tarefas pendentes
- Buscar tarefa por título
- Marcar tarefa como concluída
- Remover tarefa

## Arquitetura

O projeto segue uma separação em camadas inspirada no padrão MVC:

- **Entity**: representa a tarefa e seus atributos
- **Service**: contém as regras de negócio da aplicação
- **Main**: atua como camada de entrada (Controller no futuro)

Essa estrutura foi pensada para facilitar a migração futura para Spring Boot.

```bash
Main (entrada)
  └── TarefaService (regra de negócio)
        └── Tarefa (entidade)
````

## Tecnologias utilizadas

- Java 17
- Maven (ou Java puro, se for o caso)
- Lombok

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/MariaRitaRR/to-do-list

```


---

### 6️⃣ Exemplo de uso (menu)
Isso deixa o README **mais concreto**:

```md
## Exemplo de uso

Ao executar a aplicação, o seguinte menu é exibido no console:

1 - Cadastrar tarefa  
2 - Listar tarefas pendentes  
3 - Buscar tarefa por título  
4 - Marcar tarefa como concluída  
5 - Remover tarefa  
0 - Sair
```
## Próximos passos

- Criar Controller REST com Spring Boot
- Implementar Repository com Spring Data JPA
- Persistência em banco de dados
- Validações e tratamento de erros
- Documentação da API com Swagger

## Autora

Maria Rita Raposo Rosa  
Estudante de Engenharia da Computação





