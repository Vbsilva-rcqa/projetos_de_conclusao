# language: pt

Funcionalidade: Consulta de produto até o carrinho
  Usando o site SauceDemo, validar que o nome e o preço
  de um produto permanecem os mesmos da lista até o carrinho.

  Esquema do Cenario: Validar nome e preço do produto em todas as telas
    Dado que estou logado na SauceDemo
    Quando eu consulto o produto "<nomeProduto>" com preco "<precoProduto>" ate o carrinho
    Entao o nome e o preco devem permanecer os mesmos em todas as telas

    Exemplos:
      | nomeProduto             | precoProduto |
      | Sauce Labs Backpack     | $29.99       |
      | Sauce Labs Bolt T-Shirt | $15.99       |
