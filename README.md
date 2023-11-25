# Concessionaria-Spring
Codigo prático de aula do curso Recode
# Projeto de CRUD com Spring MVC em Java
# Link do Projeto
(https://www.loom.com/share/62c2eb0904f247c8a542e0b4feb0b3f0?sid=72476222-f9d1-4470-88ca-9cf562d1e8ca)

## Visão Geral

Este projeto é um exemplo prático de um aplicativo CRUD (Create, Read, Update, Delete) desenvolvido em Java utilizando o framework Spring no padrão MVC (Model-View-Controller). O objetivo principal é demonstrar a construção de um sistema simples para gerenciar informações de carros, abrangendo as operações básicas de um CRUD.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework Java utilizado para simplificar o desenvolvimento de aplicativos Java.
  - **Spring Web**: Módulo para desenvolvimento de aplicativos web com o Spring.
  - **Spring Data JPA**: Implementação da JPA (Java Persistence API) para interagir com bancos de dados relacionais.
  - **Thymeleaf**: Motor de template para criar páginas HTML usando Java.
  - **Spring Boot DevTools**: Facilita o desenvolvimento proporcionando reinicialização automática e outras ferramentas.
- **MySQL**: Banco de dados relacional utilizado para armazenar os dados do aplicativo.

## Dependências e Versões

- **Spring Boot**: 2.5.5
- **Spring Web**: 5.3.10
- **Spring Data JPA**: 2.5.5
- **Thymeleaf**: 3.0.12
- **MySQL Connector**: 8.0.26
- **Spring Boot DevTools**: 2.5.5

## Funcionalidades
O aplicativo oferece as seguintes funcionalidades:

Listagem de carros cadastrados.
Detalhes de um carro específico.
Adição de um novo carro.
Edição das informações de um carro.
Exclusão de um carro.

## Configuração do Banco de Dados

O projeto utiliza o MySQL como banco de dados. Certifique-se de configurar as informações de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha


