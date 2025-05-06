#language: pt

#Autor: Henrique Cesar
#Data: 06/05/2025

Funcionalidade: Fluxo de checkout no e-commerce SauceDemo

  Cenario: Usuário realiza compra com sucesso
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "standard_user" e senha "secret_sauce"
    E adiciona um produto ao carrinho
    E prossegue para o checkout
    E preenche os dados de pagamento com nome "João", sobrenome "Silva" e cep "12345"
    E finaliza a compra
    Entao a compra deve ser concluída com sucesso

  Cenario: Usuário realiza login com sucesso
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "standard_user" e senha "secret_sauce"
    Entao a página de produtos deve ser exibida

  Cenario: Adicionar múltiplos produtos ao carrinho e finalizar compra
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "standard_user" e senha "secret_sauce"
    E adiciona um produto ao carrinho
    E retorno a pagina inicial
    E adiciona outro produto ao carrinho
    E prossegue para o checkout
    E preenche os dados de pagamento com nome "Maria", sobrenome "Silva" e cep "54321"
    E finaliza a compra
    Entao a compra deve ser concluída com sucesso

  Cenario: Tentativa de login com usuário inválido
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "usuário_invalido" e senha "secret_sauce"
    Entao uma mensagem de erro deve ser exibida

  Cenario: Tentativa de login com senha inválida
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "standard_user" e senha "senha_errada"
    Entao uma mensagem de erro deve ser exibida

  Cenário: Tentativa de checkout sem preencher os dados obrigatórios
    Dado que o usuário está na página de login do SauceDemo
    Quando ele faz login com usuário "standard_user" e senha "secret_sauce"
    E adiciona um produto ao carrinho
    E prossegue para o checkout
    E preenche os dados de pagamento com nome "", sobrenome "" e cep ""
    Entao uma mensagem de erro de campos obrigatórios deve ser exibida