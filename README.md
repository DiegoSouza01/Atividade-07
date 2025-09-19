# Exercícios de Java Orientado a Objetos

Este repositório contém as soluções para uma série de exercícios práticos focados em **Programação Orientada a Objetos (POO)** e design de software em Java. Os exercícios abordam conceitos fundamentais com o objetivo de reforçar a compreensão e a aplicação prática de cada um.

### Linguagens e Tecnologias Utilizadas

* **Linguagem:** Java
* **Conceitos Principais:** Programação Orientada a Objetos (POO)
* **Estruturas de Dados:** `List`, `Map`, `Optional`, `Enum`
* **Padrões de Projeto:** Strategy

---

### Visão Geral dos Exercícios

#### **Exercício 1: Encapsulamento (Classe Produto)**

**Descrição**: Implementação de uma classe `Produto` com atributos privados (`nome`, `preco`, `quantidadeEmEstoque`). O exercício foca no **encapsulamento**, utilizando *getters* e *setters* com validações para garantir que o preço e a quantidade não sejam negativos e o nome não seja nulo ou vazio. Casos inválidos lançam uma `IllegalArgumentException`.

#### **Exercício 2: Encapsulamento com Validação de Regra (Desconto)**

**Descrição**: Extensão do exercício anterior, adicionando o método `aplicarDesconto(double porcentagem)` à classe `Produto`. O exercício valida uma regra de negócio específica: o desconto deve ser entre 0% e 50% (inclusive). Uma exceção (`IllegalArgumentException` ou `DescontoInvalidoException`) é lançada se a regra for violada, reforçando o uso de validações de regra com **encapsulamento**.

#### **Exercício 3: Herança (Hierarquia de Funcionários)**

**Descrição**: Criação de uma hierarquia de classes com uma classe base `Funcionario` e subclasses `Gerente` e `Desenvolvedor`. O exercício explora a **herança** ao garantir que as subclasses herdem atributos e **polimorfismo** ao permitir que o método `calcularBonus()` seja sobrescrito. Gerentes recebem 20% do salário como bônus e desenvolvedores, 10%.

#### **Exercício 4: Polimorfismo com Interface (IMeioTransporte)**

**Descrição**: Utilização de uma **interface** (`IMeioTransporte`) para definir um contrato comum com os métodos `acelerar()` e `frear()`. As classes `Carro`, `Bicicleta` e `Trem` implementam essa interface com lógicas próprias para variação de velocidade e limites. O exercício demonstra o **polimorfismo** ao permitir que uma lista de `IMeioTransporte` execute o mesmo método para diferentes tipos de objetos.

#### **Exercício 5: Abstração (Sistema de Pagamentos)**

**Descrição**: Implementação de um sistema de pagamentos utilizando **abstração**. A classe abstrata `FormaPagamento` define os métodos `validarPagamento()` e `processarPagamento(BigDecimal valor)`. As classes `CartaoCredito`, `Boleto` e `Pix` estendem a classe base, fornecendo implementações específicas para suas validações.

#### **Exercício 6: Imutabilidade e Objetos de Valor (Carrinho de Compras)**

**Descrição**: Foco em **imutabilidade** e **objetos de valor**. A classe `Dinheiro` é um objeto de valor imutável, e as operações sobre ela retornam novas instâncias. O `Carrinho` também é imutável: as operações de adicionar, remover ou aplicar cupons retornam um novo carrinho. Validações garantem que quantidades sejam positivas e que cupons não excedam 30%.

#### **Exercício 7: Generics (Repositório Genérico em Memória)**

**Descrição**: Uso de **generics** para criar um repositório genérico em memória (`InMemoryRepository`). O repositório lida com diferentes tipos de entidades que implementam a interface `Identificavel`. Ele gerencia entidades como `Produto` (ID do tipo `Integer`) e `Funcionario` (ID do tipo `String`). O método `remover()` lança uma `EntidadeNaoEncontradaException` caso o ID não exista.

#### **Exercício 8: Padrão Strategy (Cálculo de Frete com Lambdas)**

**Descrição**: Implementação do **padrão de projeto Strategy** para calcular o frete de um `Pedido`. O exercício demonstra a injeção e a troca de estratégias de frete (`Sedex`, `Pac`, `RetiradaNaLoja`) em tempo de execução. Uma **expressão lambda** é usada para uma estratégia promocional, como frete grátis acima de um valor determinado.
