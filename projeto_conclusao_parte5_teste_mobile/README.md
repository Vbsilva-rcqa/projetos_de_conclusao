# Projeto de Conclusão – Parte 5  
## Teste Mobile – Calculadora do Google (Appium)

Este repositório contém a **resolução do Projeto de Conclusão – Exercício 5**, usando o app da **Calculadora do Google** como alvo de testes mobile com **Appium**.

Enunciado resumido:

- **5.1** – Criar um **script simples** que faça a operação de soma de dois números.
- **5.2** – Organizar e executar esse mesmo script em **Page Objects**, lendo os dados de um **arquivo CSV** com pelo menos **3 cálculos diferentes**.

Tecnologias usadas:

- Java 17  
- Maven  
- JUnit 4  
- Appium Java Client  
- Page Objects  
- CSV como massa de teste

> ⚠️ **Importante:** Para rodar os testes, você precisa ter o ambiente de automação mobile pronto:
> - Android SDK + emulador ou dispositivo físico com modo desenvolvedor + depuração USB;
> - Appium Server rodando em `http://127.0.0.1:4723/`;
> - App da **Calculadora do Google** instalado no dispositivo/emulador (`com.google.android.calculator`).

---

## 1. Estrutura do projeto

```text
projeto_conclusao_parte5_teste_mobile/
├─ pom.xml
├─ README.md
└─ src/
   └─ test/
      ├─ java/
      │  └─ br/com/projetoconclusao/mobile/calculadora/
      │     ├─ BaseTest.java
      │     ├─ SomaSimplesTest.java
      │     ├─ pages/
      │     │  └─ CalculadoraPage.java
      │     └─ SomaCsvComPageObjectTest.java
      └─ resources/
         └─ dados_soma.csv
```

- `BaseTest.java` → classe base que inicializa o **AndroidDriver** do Appium (setup/teardown).
- `SomaSimplesTest.java` → script simples da soma de 2 números (item **5.1**).
- `CalculadoraPage.java` → Page Object da tela da calculadora.
- `SomaCsvComPageObjectTest.java` → teste que usa **Page Object + CSV** com 3 cálculos (item **5.2**).
- `dados_soma.csv` → arquivo com os cálculos de teste.

---

## 2. Pré-requisitos de ambiente (Appium)

Antes de rodar o teste, verifique:

1. **Dispositivo/Emulador**:
   - Um emulador Android rodando (por exemplo, Pixel 4 API 30),  
     ou um dispositivo físico conectado com **depuração USB** ativa.
   - O comando `adb devices` deve listar o dispositivo como **device**.

2. **Calculadora instalada**:
   - O app **Calculadora do Google** deve estar instalado.
   - Pacote usado no código: `com.google.android.calculator`.

3. **Appium Server**:
   - Appium Server rodando em: `http://127.0.0.1:4723/status`.
   - Pode ser o Appium Desktop ou Appium Server via Node.js.

Se qualquer uma dessas partes não estiver ok, o teste vai falhar tentando criar o driver.

---

## 3. Item 5.1 – Script simples de soma de dois números

Arquivo: `src/test/java/.../SomaSimplesTest.java`

O teste faz:

1. Abre a calculadora via Appium.
2. Pressiona os botões dos dígitos (por exemplo, 2 `+` 3 `=`).
3. Lê o resultado exibido pela calculadora.
4. Compara com o valor esperado usando `assertEquals`.

Para executar **somente** esse teste:

```bash
mvn -Dtest=SomaSimplesTest test
```

---

## 4. Item 5.2 – Page Objects + CSV

### 4.1. Page Object – Calculadora

Arquivo: `pages/CalculadoraPage.java`

Principais responsabilidades:

- Saber **como clicar nos botões** da calculadora:

  - Dígitos: `digit_0`, `digit_1`, ..., `digit_9`
  - Botão de soma: `op_add`
  - Botão `=`: `eq`
  - Campo de resultado: `result_final`
  - Botão `CLR`: `clr` (limpar calculadora antes de cada cálculo)

- Fornecer um método de alto nível, por exemplo:

  ```java
  public int somar(int a, int b) {
      limpar();
      digitarNumero(a);
      clicarSoma();
      digitarNumero(b);
      clicarIgual();
      return lerResultadoComoInteiro();
  }
  ```

### 4.2. Arquivo CSV – massa de teste

Arquivo: `src/test/resources/dados_soma.csv`

Conteúdo:

```text
a;b;resultado
1;2;3
5;7;12
10;15;25
```

### 4.3. Teste com CSV + Page Object

Arquivo: `SomaCsvComPageObjectTest.java`

- Usa **JUnit 4 com `@RunWith(Parameterized.class)`**.
- Lê o arquivo `dados_soma.csv` da pasta `resources`.
- Para cada linha do CSV, roda o mesmo teste:

  1. Cria um objeto `CalculadoraPage`.
  2. Chama `somar(a, b)`.
  3. Compara o resultado retornado com o `resultado` esperado da linha do CSV.

Para executar esse teste:

```bash
mvn -Dtest=SomaCsvComPageObjectTest test
```
