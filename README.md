# Developer-Task

##Classes
* [DeveloperTask](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/DeveloperTask.java): Classe Main do projeto, instancia as outras classes
* [WebhookController](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/controller/WebhookController.java): Cria, ordena e imprime dados dos Webhooks
* [Webhook](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/model/Webhook.java): Modelo de um Webhook
* [Container](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/model/Container.java): Modelo de uma container com 2 valores
* [IWebhook](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/interfaces/IWebhook.java): Interface
* [IWebhookController](https://github.com/doisLan/Developer-Task/blob/master/src/developertask/interfaces/IWebhookController.java): Interface
* [WebhookControllerTest](https://github.com/doisLan/Developer-Task/blob/master/test/developertask/controller/WebhookControllerTest.java): Testes da classe WebhookController
* [WebhookTest](https://github.com/doisLan/Developer-Task/blob/master/test/developertask/model/WebhookTest.java): Testes da classe Webhook
* [ContainerTest](https://github.com/doisLan/Developer-Task/blob/master/test/developertask/model/ContainerTest.java): Testes da classe Container

##Informações

O programa lê um arquivo de log que contém informações de envio de webhooks no formato:

level=info response_body="" request_to"```<url>```" response_headers= response_status="```<code>```"

Onde:
* url: é a url para onde foi enviado o webhook
* code: é o status code retornado pelo servidor do cliente

As seguintes informações são retornadas pelo programa:
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

## Como utilizar
Para rodar o programa deve-se abrir o prompt de comando e digitar a seguinte linha:
```
java -jar "[...]\Developer-Task\dist\DeveloperTask.jar"
```
Onde [...] é o caminho absoluto de onde o projeto está localizado.
O programa irá pedir para você indicar o caminho para um arquivo de log, visto que o arquivo de log encontra-se na pasta raiz ndo projeto, basta digitar:
```
[...]\Developer-Task\log.txt
```
Onde [...], mais uma vez, indica o caminho absoluto de onde o projeto está localizado.
