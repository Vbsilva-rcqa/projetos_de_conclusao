# Projeto de Conclusão – Parte 3  
## Teste de API – BookStore API (Tools QA)

Este repositório contém a **resolução do Projeto de Conclusão – Exercício 3**, usando a **BookStore API da Tools QA** como API de treinamento.

Endereço da API (documentação):  
https://bookstore.toolsqa.com/swagger/index.html

O fluxo implementado é:

1. **Cadastrar um usuário** na API.
2. **Autenticar o usuário** gerando um token.
3. **Cadastrar um livro** para esse usuário.
4. **Consultar o livro** cadastrado usando o ISBN.

Tudo isso é feito com **testes automatizados de API** usando:

- Java 17  
- Maven  
- JUnit 5  
- RestAssured  

---

## 1. Estrutura do projeto

```text
projeto_conclusao_parte3_teste_api/
├─ pom.xml
├─ README.md
└─ src/
   └─ test/
      └─ java/
         └─ br/com/projetoconclusao/bookstore/
            └─ BookStoreApiTest.java
```

> Não há código em `src/main` porque aqui o foco é 100% em **testes de API**.

---

## 2. Como rodar os testes

No VSCode:

1. Abra o terminal integrado (`Ctrl + '`).
2. Confirme que o terminal está na pasta do projeto (onde fica o `pom.xml`).
3. Execute o comando:

```bash
mvn test
```

O Maven vai:

- Baixar as dependências (JUnit e RestAssured).
- Compilar o projeto.
- Executar a classe de teste `BookStoreApiTest`.

Se tudo estiver correto, você verá **BUILD SUCCESS** no final.

---

## 3. O que o teste faz (fluxo completo)

Arquivo: `src/test/java/br/com/projetoconclusao/bookstore/BookStoreApiTest.java`

Este teste faz **tudo em sequência**, usando a BookStore API.

### 3.1. Base URL

- Base da API: `https://bookstore.toolsqa.com`
- Isso é configurado em um método `@BeforeAll`, que roda **antes de todos os testes**.

### 3.2. Cadastro de usuário

- Endpoint: `POST /Account/v1/User`
- Envia um JSON com:
  - `userName`
  - `password`
- O nome do usuário é gerado com `UUID`, para evitar conflito com usuários que já existem.
- O teste verifica se o status da resposta é **201** (Created) e guarda o `userID` retornado.

### 3.3. Autenticação (gera token)

- Endpoint: `POST /Account/v1/GenerateToken`
- Envia o mesmo `userName` e `password` cadastrados.
- O teste verifica se:
  - o status HTTP é **200**,
  - o campo `status` do JSON é `"Success"`,
  - existe um `token` na resposta.
- O token é guardado para ser usado nas chamadas que exigem autenticação.

### 3.4. Cadastro de livro para o usuário

- Endpoint: `POST /BookStore/v1/Books`
- Envia um JSON com:
  - `userId` (do usuário criado)
  - `collectionOfIsbns` (lista com pelo menos um ISBN)
- O teste usa um ISBN real de exemplo (um dos que aparecem na documentação).
- É enviado o cabeçalho `Authorization: Bearer {token}`.
- O teste verifica se a resposta tem código **201** (Created).

### 3.5. Consulta de livro

- Endpoint: `GET /BookStore/v1/Book?ISBN={isbn}`
- O teste verifica:
  - código de status **200**,
  - o campo `isbn` do JSON retornado é igual ao ISBN cadastrado.

---
