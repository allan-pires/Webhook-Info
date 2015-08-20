# Developer-Task
##Requisitos

O programa deve ler um arquivo de log que contém informações de envio de webhooks no formato:

level=info response_body="" request_to"```<url>```" response_headers= response_status="```<code>```"

Onde:
* url: é a url para onde foi enviado o webhook
* code: é o status code retornado pelo servidor do cliente

As seguintes informações devem ser retornadas pelo programa:
* 3 urls mais chamadas com a quantidade
* Uma tabela mostrando a quantidade de webhooks por status

Ex:
```
https://woodenoyster.com.br - 100
https://grotesquemoon.de - 99
https://notoriouslonesome.com - 90

200 - 100
201 - 99
```

##Estrutura
O programa está dividido em Controllers e Models:
* Controller: Realiza operações
* Model: Modela objetos

##Fluxo do programa
1. Lê um arquivo de texto com dados de webhooks.
2. Cria um objeto Webhook para cada webhook do log.
3. Cria uma TreeMap<Key, Value>, onde são armazenadas as URL(key) e as quantidades de chamadas(value).
4. Cria uma TreeMap<Key, Value>, onde são armazenados os Status(key) e a frequência de cada estado(value).
5. Ordena ambas os Maps por Value, em ordem decrescente.
6. Imprime ambos os Maps, com a quantidade de itens a serem impressos desejada.

##Classes
* [DeveloperTask](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/DeveloperTask.java): Classe Main do projeto, instancia as outras classes

* [Webhook](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/model/Webhook.java): Modelo de um Webhook

* [WebhookController](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/controller/WebhookController.java): Cria, ordena e imprime dados dos Webhooks

* [IWebhook](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/interfaces/IWebhook.java): Interface
* [IWebhookController](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/interfaces/IWebhookController.java): Interface

* [WebhookTest](https://github.com/doisLan/Developer-Task/blob/master/test/developertask/model/WebhookTest.java): Testes da classe Webhook

* [WebhookControllerTest](https://github.com/doisLan/Developer-Task/blob/master/test/developertask/controller/WebhookControllerTest.java): Testes da classe WebhookController

## Como utilizar
É necessário ter o Java instalado no Windows, bem como a [variável JAVA_HOME configurada](http://www.robertsindall.co.uk/blog/setting-java-home-variable-in-windows/).

Para rodar o programa deve-se abrir o prompt de comando e digitar a seguinte linha:
```
java -jar "[...]\Developer-Task\dist\DeveloperTask.jar"
```
Onde "[...]" é o caminho absoluto de onde o projeto está localizado.
O programa irá pedir para você indicar o caminho para um arquivo de log, deve-se digitar:
```
[...]\log.txt
```
Onde "[...]", mais uma vez, indica o caminho absoluto de onde o projeto está localizado.
Obs:Existe um arquivo de log disponível na pasta raiz do programa.
