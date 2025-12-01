# Projeto de Conclusão – Parte 4  
## Teste Web – SauceDemo (Selenium + Cucumber + Page Objects)

Este repositório contém a **resolução do Projeto de Conclusão – Exercício 4**, usando o site  
https://www.saucedemo.com/

Tecnologias usadas:

- Java 17  
- Maven  
- JUnit 5  
- Selenium WebDriver  
- Cucumber (BDD)  
- Page Objects  
- WebDriverManager (para baixar/configurar o driver do navegador automaticamente)

O que foi implementado:

- **4.1** – Um **script simples** (teste JUnit + Selenium) que:
  - faz login no SauceDemo;
  - escolhe 1 produto;
  - navega até o carrinho;
  - valida que **nome e preço** do produto são os mesmos na lista, na tela de detalhes e no carrinho.
- **4.2** – O mesmo fluxo, agora em **Cucumber**, com:
  - 1 arquivo de **feature** (`.feature`);
  - 1 arquivo de **passos** (step definitions);
  - uso de **Scenario Outline + Examples** com **2 produtos** (nome e preço na tabela).
- **4.3** – O mesmo script, agora organizado em **Page Objects**, utilizados pelos passos do Cucumber.

---

## 1. Estrutura de pastas

```text
projeto_conclusao_parte4_teste_web/
├─ pom.xml
├─ README.md
└─ src/
   └─ test/
      ├─ java/
      │  └─ br/com/projetoconclusao/saucedemo/
      │     ├─ simple/
      │     │  └─ ConsultaProdutoCarrinhoSimplesTest.java
      │     ├─ pages/
      │     │  ├─ BasePage.java
      │     │  ├─ LoginPage.java
      │     │  ├─ ProductsPage.java
      │     │  ├─ ProductDetailsPage.java
      │     │  └─ CartPage.java
      │     ├─ steps/
      │     │  ├─ Hooks.java
      │     │  └─ ConsultaProdutoCarrinhoSteps.java
      │     └─ runner/
      │        └─ RunCucumberTest.java
      └─ resources/
         └─ features/
            └─ consulta_produto_carrinho.feature
```

- Pasta `simple` → script simples do item **4.1** (JUnit + Selenium direto).
- Pasta `pages` → Page Objects usados no item **4.3**.
- Pasta `steps` → passos do Cucumber (ligam a linguagem Gherkin aos Page Objects).
- Pasta `runner` → classe que inicia o Cucumber com JUnit 5.
- Pasta `resources/features` → arquivo `.feature` do item **4.2**.

---

## 2. Como executar o script simples (4.1)

1. No VSCode, abra o arquivo:  
   `src/test/java/br/com/projetoconclusao/saucedemo/simple/ConsultaProdutoCarrinhoSimplesTest.java`
2. Para rodar pelo Maven, abra o terminal na pasta do projeto e execute:

```bash
mvn -Dtest=ConsultaProdutoCarrinhoSimplesTest test
```

O que o teste faz:

- Abre o navegador.
- Acessa `https://www.saucedemo.com/`.
- Faz login com usuário de demonstração `standard_user` / `secret_sauce`.
- Escolhe o produto **"Sauce Labs Backpack"**.
- Garante que o nome e o preço desse produto sejam os mesmos:
  - na **lista de produtos**,
  - na **tela de detalhes do produto**,
  - na **tela do carrinho**.

---

## 3. Como executar o teste com Cucumber + Page Objects (4.2 e 4.3)

1. O arquivo de feature está em:  
   `src/test/resources/features/consulta_produto_carrinho.feature`
2. Os passos estão em:  
   `src/test/java/br/com/projetoconclusao/saucedemo/steps/ConsultaProdutoCarrinhoSteps.java`
3. O runner (classe que inicia o Cucumber) está em:  
   `src/test/java/br/com/projetoconclusao/saucedemo/runner/RunCucumberTest.java`

Para rodar os testes Cucumber com Maven:

```bash
mvn -Dtest=RunCucumberTest test
```

O Scenario Outline na feature usa **2 produtos**:

- `"Sauce Labs Backpack"` – preço `$29.99`
- `"Sauce Labs Bolt T-Shirt"` – preço `$15.99`

Para cada linha da tabela **Examples**, o Cucumber:

1. Faz login na SauceDemo.
2. Localiza o produto pelo nome na lista de produtos.
3. Confere se o **preço na lista** é o mesmo da tabela.
4. Abre a tela de detalhes do produto e confere **nome e preço**.
5. Adiciona o produto ao carrinho e navega ao carrinho.
6. Confere **nome e preço** do produto no carrinho.

Se o nome ou o preço mudarem em qualquer uma das telas, o teste falha.

---

## 4. Resumo técnico de como cada item do enunciado foi atendido

### 4.1. Item 4.1 – Script simples

- Implementado em `ConsultaProdutoCarrinhoSimplesTest.java`.
- Usa diretamente Selenium WebDriver (sem Cucumber, sem Page Objects).
- Foca em mostrar o fluxo básico de validação de nome e preço em todas as telas.

### 4.2. Item 4.2 – Feature + Steps com Examples

- Feature: `consulta_produto_carrinho.feature` (Gherkin).
- Steps: `ConsultaProdutoCarrinhoSteps.java`.
- Usa `Scenario Outline` + tabela **Examples** com 2 produtos (nome e preço).

### 4.3. Item 4.3 – Page Objects

- Page Objects:
  - `LoginPage` → login no site.
  - `ProductsPage` → lista de produtos (nome, preço, abrir detalhes, ir para o carrinho).
  - `ProductDetailsPage` → tela de detalhes (nome, preço, botão de adicionar ao carrinho).
  - `CartPage` → tela do carrinho (nome e preço do produto).
- Os passos do Cucumber **não** usam localizadores diretamente, apenas chamam métodos dos Page Objects.

---