# HE01 – Heurística (checklist) para teste exploratório – SauceDemo

## 1. O que é esta heurística?

Esta heurística é uma **lista de pontos importantes para lembrar** enquanto você faz um **teste exploratório** no site SauceDemo.

- Não é um passo a passo rígido.
- É mais como uma folha de lembretes: “Já olhei isso? E isso aqui?”.
- Você pode marcar, escrever observações e voltar se lembrar de algo depois.

## 2. Escopo do teste exploratório

- Fluxo principal de compra:
  - Login
  - Lista de produtos
  - Carrinho
  - Checkout (informações do cliente e confirmação do pedido)

## 3. Heurística – lista de pontos chaves a observar

### 3.1. Login

- [ ] O campo **Username** aceita texto normalmente?
- [ ] O campo **Password** esconde os caracteres digitados?
- [ ] O que acontece se tentar fazer login:
  - [ ] Com usuário e senha válidos?
  - [ ] Com usuário válido e senha errada?
  - [ ] Com usuário vazio?
  - [ ] Com senha vazia?
- [ ] As mensagens de erro são **claras** e **fáceis de entender**?
- [ ] Depois de um login bem-sucedido, o usuário vai para uma tela lógica (lista de produtos)?

### 3.2. Lista de produtos

- [ ] Os produtos aparecem com nome, preço e imagem?
- [ ] O botão de adicionar ao carrinho funciona para cada produto?
- [ ] O número que aparece no ícone do carrinho aumenta ou diminui corretamente quando:
  - [ ] Adiciona produtos?
  - [ ] Remove produtos?
- [ ] O filtro de ordenação (por exemplo, preço ou nome) parece ordenar os produtos de forma correta?

### 3.3. Carrinho de compras

- [ ] O carrinho mostra todos os produtos adicionados?
- [ ] As quantidades podem ser ajustadas (quando aplicável)?
- [ ] O valor exibido no carrinho faz sentido com os preços dos itens?
- [ ] O botão para ir para o checkout funciona?
- [ ] Existem mensagens ou elementos confusos (textos cortados, botões sem legenda etc.)?

### 3.4. Checkout – dados do cliente

- [ ] Os campos de **nome**, **sobrenome** e **CEP** aceitam texto corretamente?
- [ ] O que acontece se:
  - [ ] Deixar algum campo obrigatório em branco?
  - [ ] Digitar números estranhos ou muito longos no CEP?
- [ ] As mensagens de erro indicam claramente **qual campo** está com problema?
- [ ] Quando os dados estão corretos, o sistema permite avançar para o resumo do pedido?

### 3.5. Checkout – resumo e finalização

- [ ] O resumo mostra:
  - [ ] Lista de itens com nome e preço?
  - [ ] Subtotal, impostos (se existirem) e total?
- [ ] O valor total parece ser a soma correta dos itens (mais taxas, se houver)?
- [ ] O botão de finalizar a compra funciona?
- [ ] Após finalizar, aparece alguma mensagem clara de sucesso (por exemplo, agradecimento)?
- [ ] Depois de finalizar, o carrinho fica vazio se o usuário voltar para a lista de produtos?

### 3.6. Usabilidade e aparência geral

- [ ] As telas se ajustam bem quando a janela do navegador é redimensionada?
- [ ] Os textos são legíveis (tamanho, cor, contraste com o fundo)?
- [ ] Os botões parecem clicáveis (cor, formato, efeito ao passar o mouse)?
- [ ] Não há elementos visuais quebrados (imagens não carregadas, textos sobrepostos etc.)?

### 3.7. Comportamentos inesperados ou estranhos

- [ ] O sistema fica muito lento em algum ponto?
- [ ] Alguma ação gera mensagens de erro técnicas (por exemplo, páginas de erro do servidor)?
- [ ] Existem lugares onde é possível “se perder” (sem botão para voltar, sem clareza do que fazer)?

## 4. Como conduzir o teste exploratório usando esta heurística

1. **Definir um tempo de sessão**
   - Exemplo: 30 ou 45 minutos focados apenas na exploração do fluxo de compra.

2. **Começar pelo login e seguir o fluxo**
   - Tentar simular a vida real: um cliente entra, escolhe produtos, põe no carrinho e faz o checkout.

3. **Usar a lista como guia, não como prisão**
   - Se descobrir algo estranho, pare e investigue.
   - Depois volte para a heurística e continue de onde parou.

4. **Registrar o que encontrar**
   - Anotar problemas, telas confusas, mensagens ruins.
   - Se possível, tirar prints para facilitar o registro dos defeitos.

5. **Encerrar a sessão e revisar**
   - Ver o que foi coberto na heurística.
   - Marcar o que ficou de fora, caso precise de uma nova sessão no futuro.

Esta heurística ajuda a manter o teste exploratório organizado, mesmo sendo um tipo de teste mais “livre” e criativo.