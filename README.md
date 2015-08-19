# Developer-Task

##Classes

* DeveloperTask: Classe Main do projeto, instancia as outras classes
* WebhookController: Cria, ordena e imprime dados dos Webhooks
* Webhook: Modelo de um Webhook
* Container: Modelo de uma container com 2 valores
* IWebhook: Interface
* IWebhook: Interface
* WebhookControllerTest: Testes da classe WebhookController
* WebhookTest: Testes da classe Webhook
* ContainerTest: Testes da classe Container

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
