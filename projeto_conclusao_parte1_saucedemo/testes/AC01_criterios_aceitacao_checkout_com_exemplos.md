# AC01 – Critérios de aceitação com exemplos – Checkout na SauceDemo

## 1. História de usuário

> **Como** cliente da loja SauceDemo  
> **Quero** finalizar a compra de produtos que coloquei no carrinho  
> **Para** receber meus itens corretamente.

## 2. Critério de aceitação principal

> **AC01 – Validação de campos obrigatórios no checkout**  
> O sistema deve exigir o preenchimento dos campos obrigatórios do formulário de checkout (Primeiro Nome, Sobrenome e CEP).  
> - Se todos os campos obrigatórios estiverem preenchidos com dados válidos, o sistema deve permitir avançar para a etapa seguinte do pedido.  
> - Se qualquer campo obrigatório não for preenchido, o sistema deve impedir o avanço e exibir uma mensagem clara indicando qual campo está faltando.

## 3. Cenário de aceitação usando lista de exemplos (Cenário Esquema)

Abaixo, o critério de aceitação está descrito em formato de **Cenário Esquema** (estilo BDD), com uma **tabela de Exemplos**.  
Cada linha da tabela funciona como um **exemplo prático** de como o requisito deve se comportar.

```gherkin
Funcionalidade: Checkout da compra

  Cenário Esquema: Validação de campos obrigatórios no checkout
    Dado que estou logado na SauceDemo como "standard_user"
    E tenho pelo menos 1 produto adicionado ao carrinho
    E acesso a tela de checkout (etapa de informações do cliente)
    Quando preencho o campo "First Name" com <primeiro_nome>
    E preencho o campo "Last Name" com <sobrenome>
    E preencho o campo "Zip/Postal Code" com <cep>
    E clico no botão "Continue"
    Então devo ver o resultado <resultado_esperado>

    Exemplos:
      | primeiro_nome | sobrenome  | cep      | resultado_esperado                                                     |
      | "Ana"         | "Silva"    | "12345"  | "Usuário avança para a próxima etapa (resumo do pedido)."             |
      | ""            | "Silva"    | "12345"  | "Mensagem de erro informando que o First Name (Primeiro Nome) é obrigatório." |
      | "Ana"         | ""         | "12345"  | "Mensagem de erro informando que o Last Name (Sobrenome) é obrigatório."     |
      | "Ana"         | "Silva"    | ""       | "Mensagem de erro informando que o Zip/Postal Code (CEP) é obrigatório."     |
```

## 4. Como usar este critério de aceitação na prática

1. **Preparar o ambiente**
   - Acessar `https://www.saucedemo.com/`.
   - Fazer login com o usuário de demonstração `standard_user` e senha `secret_sauce`.
   - Adicionar qualquer produto ao carrinho.
   - Ir até o começo do fluxo de checkout (tela com campos de nome e CEP).

2. **Executar cada exemplo da tabela**
   - Para cada linha da tabela “Exemplos”:
     - Preencher os campos de acordo com o valor de `primeiro_nome`, `sobrenome` e `cep`.
     - Clicar em **Continue**.
     - Verificar se o comportamento observado é igual ao texto de `resultado_esperado`.

3. **Decidir se o critério está atendido**
   - O critério de aceitação **AC01** é considerado **atendido** se:
     - Todas as linhas da tabela de exemplos se comportarem como descrito.
   - Se qualquer exemplo não corresponder ao resultado esperado, o critério **não** está atendido e deve ser registrado um defeito.

## 5. Benefício de usar lista de exemplos

- Ajuda a deixar o requisito **mais claro** para todas as pessoas (cliente, desenvolvedores, testadores).
- Reduz mal-entendidos, pois mostra casos concretos.
- Facilita a transformação dos exemplos em **casos de teste automatizados** no futuro, se desejado.