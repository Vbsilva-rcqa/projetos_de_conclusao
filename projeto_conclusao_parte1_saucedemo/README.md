# Projeto de Conclusão – Parte 1  
## Teste Manual e Exploratório com o site SauceDemo

Este repositório contém a **resolução do Projeto de Conclusão – Exercício 1** do curso de testes, usando o site de demonstração [SauceDemo](https://www.saucedemo.com/).

Aqui você vai encontrar:

- Um **caso de teste orientado a dados** para o login.
- Um **critério de aceitação com lista de exemplos** para o checkout.
- Uma **heurística (checklist) para teste exploratório** do fluxo de compra.

Tudo está em arquivos de texto simples (`.md`), fáceis de abrir e editar no VSCode.

---

## 1. Estrutura de pastas

```text
projeto_conclusao_parte1_saucedemo/
├─ README.md
└─ testes/
   ├─ CT01_caso_teste_orientado_a_dados_login.md
   ├─ AC01_criterios_aceitacao_checkout_com_exemplos.md
   └─ HE01_heuristica_teste_exploratorio_saucedemo.md
```

- `CT01_...` → Caso de teste orientado a dados (login).
- `AC01_...` → Critérios de aceitação com exemplos (checkout).
- `HE01_...` → Heurística para teste exploratório (checklist).

---

## 2. Como usar cada arquivo

### 2.1. Caso de teste orientado a dados – Login

- Arquivo: `testes/CT01_caso_teste_orientado_a_dados_login.md`
- Mostra **um único caso de teste**, com **várias linhas de dados** (várias combinações de usuário/senha).
- Você pode:
  - Executar cada linha da tabela no site SauceDemo.
  - Marcar quais passaram/falharam.
  - Adicionar novas linhas se quiser.

### 2.2. Critérios de aceitação com exemplos – Checkout

- Arquivo: `testes/AC01_criterios_aceitacao_checkout_com_exemplos.md`
- Mostra uma **história de usuário** e um **critério de aceitação** escrito como **Cenário Esquema**, com uma tabela de **Exemplos**.
- A ideia é:
  - Cada linha da tabela mostra uma combinação diferente de dados no checkout.
  - Se todos os exemplos funcionarem como descrito, o requisito está aceito.

### 2.3. Heurística (checklist) para teste exploratório

- Arquivo: `testes/HE01_heuristica_teste_exploratorio_saucedemo.md`
- É uma **lista de pontos para lembrar** enquanto você explora o sistema.
- Você pode:
  - Usar a heurística como um “guia” durante o teste exploratório.
  - Marcar o que testou e anotar problemas ao lado.

