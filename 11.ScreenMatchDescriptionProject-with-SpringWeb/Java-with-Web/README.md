# O desafio visa implementar uma aplicação para gerar frases aleatórias de filmes e séries, que serão consumidas por uma aplicação front-end. Pontos abordados:

- Criação de uma API REST, que disponibilize dados através do endpoint **http://localhost:8080/series/frases**;
- Criação de Classe - Controller, Service, Repository para implementação das requisições e busca ao banco;
- Criação da classe Model com os atributos id, titulo, frase, personagem e poster;
- Criação da classe SerieDTO para representar os dados que serão devolvidos para a aplicação front-end;
- Criação do projeto através do site do [Spring Initializr](https://start.spring.io/), utilizando as dependências do Sping Web, Spring Data JPA, PostgreSQL e DevTools;
- Criação do banco de dados diretamente pelo pgAdmin;
- Utilização da consulta JPQL para retornar a frase dessa forma:  **@Query("SELECT f FROM Frase f order by function('RANDOM') LIMIT 1")**

## 🔨 Objetivos do projeto

- O objetivo do projeto foi consolidar os conhecimentos adquiridos ao longo da formação, no que tange a Spring, Streams, JPA, aplicação Web;
- Foi importante iniciar o projeto do zero para ir modelando as classes, testando o acesso ao banco e verificando erros ao tentar obter dados pela aplicação front;
- Realizar a criação do controlador, mapeando a rota que a aplicação front-end irá consumir;
- Entender e corrigir os erros referente a CORS;
- Adquirir experiência fullstack entendendo o fluxo da aplicação ponta a ponta.