# estruturadados-algoritmo-java
<p>
<img alt="GitHub top language" src="https://img.shields.io/github/languages/top/my-study-area/estruturadados-algoritmo-java">
<a href="https://github.com/adrianoavelino">
    <img alt="Made by" src="https://img.shields.io/badge/made%20by-adriano%20avelino-gree">
</a>
<img alt="Repository size" src="https://img.shields.io/github/repo-size/my-study-area/estruturadados-algoritmo-java">
<a href="https://github.com/EliasGcf/readme-template/commits/master">
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/my-study-area/estruturadados-algoritmo-java">
</a>
</p>

Curso de Estrutura de Dados e Algoritmos da [Loiane Groner](https://www.youtube.com/channel/UCqQn92noBhY9VKQy4xCHPsg) aplicando os conhecimentos de testes unitários com ***JUnit***.

## Tecnologias
- Java
- JUnit
- Maven

## Começando
- clone o projeto:
```sh
git clone https://github.com/my-study-area/estruturadados-algoritmo-java.git
```
- entre no diretório:
```sh
cd estruturadados-algoritmo-java
```

## Teste
Verifique os passos abaixo para executar os testes no terminal utilizando maven ou eclipse
### Terminal
- execute todos os testes
```bash
mvn clean test
```
- execute os teste parando ao primeiro erro
```bash
mvn clean test -ff
```
- execute os testes de somente uma classe
```bash
mvn clean -Dtest=VetorTest test
```
- execute um único teste
```bash
mvn clean -Dtest=VetorTest#removeElementoDoVetorPorPosicao test
```
### Elipse
Utilize o atalho `ctrl+F11`.
