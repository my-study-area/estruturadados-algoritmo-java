# estruturadados-algoritmo-java
Curso de Estrutura de Dados e Algoritmos da [Loiane Groner](https://www.youtube.com/channel/UCqQn92noBhY9VKQy4xCHPsg) aplicando os conhecimentos de testes unitários com ***JUnit***.

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
