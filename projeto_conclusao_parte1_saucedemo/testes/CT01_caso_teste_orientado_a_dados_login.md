# CT01 – Caso de teste orientado a dados – Login na SauceDemo

## 1. Informações gerais

- **ID:** CT01
- **Nome:** Login na aplicação SauceDemo (orientado a dados)
- **Módulo:** Autenticação
- **Responsável:** (seu nome aqui)
- **Data:** (preencha a data de criação)

## 2. Objetivo

Verificar se a tela de **login** da SauceDemo trata corretamente diferentes combinações de usuário e senha, permitindo o acesso apenas para usuários válidos e exibindo mensagens de erro adequadas para casos inválidos.

## 3. Pré‑condições

- Ter acesso à internet.
- Ter um navegador instalado (por exemplo: Chrome, Firefox ou Edge).
- Estar com o site disponível: `https://www.saucedemo.com/`.
- Não estar logado na aplicação (começar sempre na tela de login).

## 4. Massa de dados (orientada a dados)

> Observação: na SauceDemo os usuários de demonstração utilizam, em geral, a senha `secret_sauce`.

Cada linha da tabela abaixo representa **uma variação de dados** para o **mesmo caso de teste**.

| ID linha | Descrição                           | Usuário              | Senha         | Resultado esperado                                                                                  |
|---------:|-------------------------------------|----------------------|---------------|-----------------------------------------------------------------------------------------------------|
| 1        | Login com usuário padrão válido     | `standard_user`      | `secret_sauce`| Sistema realiza login e redireciona para a página **"Products"**, sem mensagem de erro.            |
| 2        | Usuário bloqueado                   | `locked_out_user`    | `secret_sauce`| Sistema **não** realiza login e exibe mensagem informando que o usuário está bloqueado.            |
| 3        | Usuário inexistente                 | `nao_existe`         | `secret_sauce`| Sistema **não** realiza login e exibe mensagem de erro de credenciais inválidas.                   |
| 4        | Senha incorreta                     | `standard_user`      | `senha_errada`| Sistema **não** realiza login e exibe mensagem de erro de credenciais inválidas.                   |
| 5        | Nome de usuário em branco           | *(em branco)*        | `secret_sauce`| Sistema **não** realiza login e exibe mensagem informando que o **Username é obrigatório**.        |
| 6        | Senha em branco                     | `standard_user`      | *(em branco)* | Sistema **não** realiza login e exibe mensagem informando que a **Password é obrigatória**.        |

Você pode adicionar novas linhas, se desejar, mantendo a mesma estrutura.

## 5. Passos do caso de teste (iguais para todas as linhas)

1. Abrir o navegador.
2. Acessar a URL `https://www.saucedemo.com/`.
3. No campo **Username**, digitar o valor de **Usuário** da linha que está sendo testada.
4. No campo **Password**, digitar o valor de **Senha** da linha que está sendo testada.
5. Clicar no botão **"Login"**.
6. Observar o comportamento do sistema.

## 6. Resultado esperado (por linha de dados)

- Conferir se o que aconteceu na tela é igual ao **Resultado esperado** descrito na tabela da seção 4.
- Registrar para cada linha:
  - **Status:** Aprovado / Reprovado.
  - **Observações:** exemplo: mensagens diferentes das esperadas, travamentos, problemas visuais, etc.

## 7. Critérios de aprovação do caso de teste

- O caso de teste é considerado **aprovado** se:
  - Todas as linhas de dados forem executadas.
  - E o comportamento da aplicação corresponder ao resultado esperado de cada linha, sem erros inesperados.
- Se qualquer linha apresentar um comportamento diferente do esperado, o caso de teste deve ser marcado como **reprovado** e os defeitos encontrados devem ser registrados.