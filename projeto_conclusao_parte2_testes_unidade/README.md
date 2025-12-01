# Projeto de Conclusão – Parte 2  
## Testes de Unidade (Java + JUnit 5)

Este repositório contém a **resolução do Projeto de Conclusão – Exercício 2**, usando **Java**, **JUnit 5** e **Maven**.

O projeto atende aos itens:

- **2.1** – 3 funções para calcular:
  - volume de um cubo
  - volume de um paralelepípedo
  - volume de uma esfera
- **2.2** – Testes de unidade:
  - 1 teste simples para o volume do cubo
  - 1 teste usando uma **lista de valores** para o paralelepípedo (teste parametrizado)
- **2.3** – Teste de unidade usando um **arquivo CSV** com pelo menos 3 valores para testar o volume da esfera

---

## 1. Estrutura de pastas (Maven)

```text
projeto_conclusao_parte2_testes_unidade/
├─ pom.xml
├─ README.md
├─ src/
   ├─ main/
   │  └─ java/
   │     └─ br/com/projetoconclusao/volumes/
   │        └─ CalculadoraVolumes.java
   └─ test/
      ├─ java/
      │  └─ br/com/projetoconclusao/volumes/
      │     └─ CalculadoraVolumesTest.java
      └─ resources/
         └─ esfera_dados.csv
```

- `CalculadoraVolumes.java` → contém as 3 funções (cubo, paralelepípedo, esfera).
- `CalculadoraVolumesTest.java` → contém todos os testes de unidade.
- `esfera_dados.csv` → contém os dados usados como massa de teste para o volume da esfera.

---

## 2. Como rodar os testes

No VSCode (ou no terminal da pasta do projeto):

1. Abra um terminal integrado (por exemplo, `Ctrl + '`).  
2. Execute o comando:

```bash
mvn test
```

O Maven vai:

- Baixar o JUnit (se ainda não estiver em cache).
- Compilar o código em `src/main/java` e `src/test/java`.
- Executar os testes de unidade.

Se tudo estiver certo, você apresentará uma mensagem de **BUILD SUCCESS**.

---

## 3. Explicando as funções (item 2.1)

Arquivo: `src/main/java/br/com/projetoconclusao/volumes/CalculadoraVolumes.java`

### 3.1. Volume de um cubo

Fórmula:  

> volume = lado³

Ou seja: lado × lado × lado.

### 3.2. Volume de um paralelepípedo

Fórmula:  

> volume = comprimento × largura × altura

### 3.3. Volume de uma esfera

Fórmula:  

> volume = (4/3) × π × raio³

---

## 4. Explicando os testes (itens 2.2 e 2.3)

Arquivo: `src/test/java/br/com/projetoconclusao/volumes/CalculadoraVolumesTest.java`

### 4.1. Teste simples para o cubo (2.2 – parte 1)

- Cria um teste que chama a função `volumeCubo(2.0)`.
- Compara o resultado com o valor esperado **8.0** (2 × 2 × 2).

### 4.2. Teste com lista de valores para paralelepípedo (2.2 – parte 2)

- Usa um **teste parametrizado** com uma lista de combinações de:
  - comprimento, largura, altura e volume esperado.
- Para cada linha da lista, o teste chama `volumeParalelepipedo` e verifica se o resultado é o esperado.

### 4.3. Teste usando arquivo CSV para esfera (2.3)

- O arquivo `src/test/resources/esfera_dados.csv` guarda pelo menos **3 valores** de teste.
- Cada linha do CSV tem:
  - `raio;volumeEsperado`
- O teste lê o CSV via `@CsvFileSource` (JUnit 5) e, para cada linha:
  - chama `volumeEsfera(raio)`
  - compara o resultado com `volumeEsperado` usando uma margem de erro pequena.

---