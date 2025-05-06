# 🧪 Projeto de Automação E2E - SauceDemo

Automação de testes de ponta a ponta (E2E) com Java, Selenium WebDriver, Cucumber e TestNG, validando o fluxo completo de login, adição de produtos ao carrinho, checkout e finalização de compra no site de demonstração [https://www.saucedemo.com](https://www.saucedemo.com).

---

## 🔧 Tecnologias Utilizadas

- Java 11+
- Selenium WebDriver 4
- Cucumber 7 (Gherkin)
- TestNG
- Maven
- ChromeDriver

---

## 📌 Funcionalidades Automatizadas

- Login com credenciais válidas e inválidas
- Validação de mensagens de erro no login
- Adição de um ou mais produtos ao carrinho
- Navegação entre páginas via botão "Continue Shopping"
- Preenchimento do formulário de checkout
- Validação de mensagens de erro para campos obrigatórios
- Finalização de compra com validação de sucesso

---

## 📁 Estrutura do Projeto

src

├── test

│ ├── java

│ │ ├── pages # Page Objects

│ │ ├── steps # Step Definitions

│ │ ├── support # Classe Base com setup do WebDriver

│ │ └── runner # Classe TestRunner

│ └── resources

│ └── features # Cenários em Gherkin (.feature)

---

## ▶️ Como Executar

### Pré-requisitos

- JDK 11 ou superior
- Maven instalado
- Google Chrome e ChromeDriver compatíveis com a versão do navegador

### Clonar o repositório
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo

### Executar os testes

mvn test

---

## 📄 Relatório de Testes

Após execução, o relatório HTML será gerado em:

target/cucumber-report.html

Abra esse arquivo com seu navegador para visualizar o resultado dos testes.

---

## 🧪 Exemplo de Cenário

Cenário: Adicionar múltiplos produtos ao carrinho e finalizar compra

  Dado que o usuário está na página de login do SauceDemo
  
  Quando ele faz login com usuário "standard_user" e senha "secret_sauce"
  
  E adiciona um produto ao carrinho
  
  E prossegue para o carrinho
  
  E clica em continuar comprando
  
  E adiciona outro produto ao carrinho
  
  E prossegue para o carrinho novamente
  
  E prossegue para o checkout
  
  E preenche os dados de pagamento com nome "Maria", sobrenome "Silva" e cep "54321"
  
  E finaliza a compra
  
  Então a compra deve ser concluída com sucesso

