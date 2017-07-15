Desafio QA
=======

Este repositório contém uma solução para os casos de teste no site da americanas.com.br, utilizando Selenium Java


## Configurando ##

Antes de rodar os testes, é necessário configurar o geckodriver, que o Selenium utiliza para rodar os testes no navegador Firefox. Ele se encontra na pasta *src/test/resources*

Copie para um diretorio no S.O (Sugerido C:/geckodriver/geckodriver.exe) e altere a linha 28 do arquivo DesafioTest.java.

    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");

## Executando os testes ##
Depois de configurado, rodar o comando:

    mvn test

