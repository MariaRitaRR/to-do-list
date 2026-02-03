# ToDo List em Java

API REST de gerenciamento de tarefas (ToDo List) desenvolvida em **Java com Spring Boot**, com foco em boas práticas de arquitetura, separação de responsabilidades e escalabilidade.

O projeto consome dados externos, persiste informações em banco de dados H2 e expõe endpoints REST para gerenciamento de usuários e tarefas.

---

## Funcionalidades

### Usuários
- Cadastro e persistência de usuários
- Importação automática de usuários via API externa (`dummyjson.com`)

### Tarefas
- Criar tarefas associadas a um usuário
- Listar tarefas visíveis por usuário
- Definir status da tarefa (`TODO`, `DOING`, `DONE`)
- Definir tarefas públicas ou privadas
- Associar participantes a uma tarefa
- Importação automática de tarefas via API externa

---


## Arquitetura

O projeto segue uma **arquitetura em camadas**, inspirada no padrão MVC:

```md
Controller
↓
Service
↓
Repository
↓
Entity
```

### Camadas

- **Controller**
  - Exposição dos endpoints REST
  - Recebimento e validação das requisições HTTP

- **Service**
  - Regras de negócio
  - Conversão entre DTOs e entidades
  - Integração com APIs externas
  - Lógica de seed do banco de dados

- **Repository**
  - Acesso a dados via Spring Data JPA

- **Entity**
  - Representação das entidades persistidas no banco

- **DTO**
  - Objetos de transferência de dados
  - Separação entre modelo interno e contrato da API

- **Exception**
  - Tratamento global de erros e validações

---

## Modelos Principais

### TaskStatus (Enum)
- `TODO`
- `DOING`
- `DONE`

### Entidades
- **User**
- **Task**
  - Relacionamento com usuário (owner)
  - Relacionamento com participantes

---

## Integrações Externas

- Consumo da API **dummyjson.com**
  - `/users`
  - `/todos`

Os dados são carregados automaticamente na inicialização da aplicação através do `SeedService`.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- WebClient
- H2 Database
- Lombok
- Maven

---

## Configuração do Projeto

### Banco de Dados (H2)

- Banco em memória
- Console disponível em: http://localhost:8080/h2-console


Configurações principais (`application.properties`):

```properties
spring.datasource.url=jdbc:h2:mem:todo-db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=mr
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
````


## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/MariaRitaRR/to-do-list

```
2. Acesse a pasta do projeto:
```bash
cd todo-list-api
```
3. Execute a aplicação:
```bash
mvn spring-boot:run
```
---

### Exemplos de Endpoints

```bash
POST /api/tasks
```
-> Exemplo de body:
```json
{
  "title": "Estudar Spring Boot",
  "description": "Criada via Postman",
  "dueDate": "2026-02-10T18:00",
  "status": "TODO",
  "isPublic": false,
  "ownerId": 1,
  "participantIds": [2, 3]
}


```
## Tratamento de Erros

-Validações automáticas com Bean Validation
-Handler global de exceções (@RestControllerAdvice)
-Respostas padronizadas para erros de validação e regras de negócio

## Próximos passos

-Paginação e ordenação de tarefas
-Autenticação e autorização
-Documentação da API com Swagger / OpenAPI
-Persistência em banco relacional externo (PostgreSQL ou MySQL)
-Testes automatizados (JUnit / Mockito)

## Autora

Maria Rita Raposo Rosa  
Estudante de Engenharia da Computação





