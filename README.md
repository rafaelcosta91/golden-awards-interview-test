<div align="center" id="top"> 
  <img src="./.github/app.gif" alt="Golden Awards Interview Test" />

  &#xa0;

  <!-- <a href="https://goldenawardsinterviewtest.netlify.app">Demo</a> -->
</div>

<h1 align="center">Golden Awards Interview Test</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/rafaelcosta91/golden-awards-interview-test?color=56BEB8">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/rafaelcosta91/golden-awards-interview-test?color=56BEB8">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/rafaelcosta91/golden-awards-interview-test?color=56BEB8">

  <img alt="License" src="https://img.shields.io/github/license/rafaelcosta91/golden-awards-interview-test?color=56BEB8">

  <!-- <img alt="Github issues" src="https://img.shields.io/github/issues/rafaelcosta91/golden-awards-interview-test?color=56BEB8" /> -->

  <!-- <img alt="Github forks" src="https://img.shields.io/github/forks/rafaelcosta91/golden-awards-interview-test?color=56BEB8" /> -->

  <!-- <img alt="Github stars" src="https://img.shields.io/github/stars/rafaelcosta91/golden-awards-interview-test?color=56BEB8" /> -->
</p>

<!-- Status -->

<!-- <h4 align="center"> 
	🚧  Golden Awards Interview Test 🚀 Under construction...  🚧
</h4> 

<hr> -->

<p align="center">
  <a href="#dart-sobre">Sobre</a> &#xa0; | &#xa0; 
  <a href="#sparkles-endpoints">Endpoints</a> &#xa0; | &#xa0;
  <a href="#rocket-tecnologias">Tecnologias</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requisitos">Requisitos</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-executando">Executando</a> &#xa0; | &#xa0;
  <a href="#memo-license">Licença</a> &#xa0; | &#xa0;
  <a href="https://github.com/rafaelcosta91" target="_blank">Autor</a>
</p>

<br>

## :dart: Sobre ##

A API RESTful possibilita a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards

## :sparkles: Endpoints ##

GET http://localhost:8080/api/intervals

GET  POST | PUT | DELETE http://localhost:8080/api/movies

GET | POST | PUT | DELETE http://localhost:8080/api/studios

GET | POST | PUT | DELETE http://localhost:8080/api/producers

### As urls disponibilizadas pela API do Spring para visualização de como executar integrar os serviços. A mesma já utiliza o conceito de HATEOAS.

GET http://localhost:8080/api/profile 

GET http://localhost:8080/api/profile/studios

GET http://localhost:8080/api/profile/movies

GET http://localhost:8080/api/profile/producers


## :rocket: Tecnologias ##

As seguintes tecnologias foram utilizadas nesse projeto

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Initializr](https://start.spring.io)
- [H2 Database](www.h2database.com)
- [Spring Data | Spring Boot | Spring Boot DevTools](https://spring.io)
- [Mockito](https://site.mockito.org)
- [Lombok](https://projectlombok.org)
- [OpenCSV](https://opencsv.sourceforge.net)

## :white_check_mark: Requisitos ##

Antes de começar você precisar ter o [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalado

## :checkered_flag: Executando ##

```bash
# Clone esse projeto
$ git clone https://github.com/rafaelcosta91/golden-awards-interview-test

# Acesse
$ cd golden-awards-interview-test

# Rode o teste do maven
$ mvnw clean test

# Caso deseje subir o webservice pra testar seus endpoints
$ mvnw spring-boot:run

# Isso vai disponibilizar o webservice na url http://localhost:8080/api

# Caso deseje utilizar um arquivo .csv customizado, basta ao executar alterar a variavel movies.filename, como nos exemplos abaixo e colocar o arquivo na pasta raiz do projeto:

$ mvnw clean test -Dmovies.filename=seuarquivo.csv

$ mvnw spring-boot:run -Dspring-boot.run.argumentos=--movies.filename=seuarquivo.csv
```

## :memo: Licença ##

Feito com carinho por <a href="https://github.com/rafaelcosta91" target="_blank">Rafael Almeida Costa</a>

&#xa0;

<a href="#top">Voltar ao Inicio</a>