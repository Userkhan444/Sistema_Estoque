# Sistema de Gerenciamento de Estoque (CLI)

Este repositório contém um **Sistema de Informação** para gerenciamento de estoque via console, desenvolvido como projeto prático para a disciplina de Computação.

O projeto foi construído seguindo estritamente o paradigma de **Orientação a Objetos** e arquitetura **MVC**, focando na aplicação de Padrões de Projeto e boas práticas de engenharia de software.

## 📋 Sobre o Projeto

O sistema permite o cadastro, listagem e remoção de produtos (polimórficos) em um banco de dados em memória. O foco principal é a demonstração de competências em:
* Encapsulamento e Abstração.
* Herança e Polimorfismo.
* Design Patterns (Padrões de Projeto).
* Manipulação de Estruturas de Dados.

## 🚀 Tecnologias e Padrões Utilizados

### Arquitetura
* **MVC (Model-View-Controller):** Separação estrita entre a lógica de negócios (`model`), interação com usuário (`view`) e orquestração (`controller`).

### Padrões de Projeto (Design Patterns)
O projeto supera os requisitos mínimos, implementando três padrões:

1.  **Singleton:** Utilizado na classe `BancoDeDadosMemoria` para garantir que o repositório de dados seja único em toda a aplicação.
2.  **Factory Method:** Utilizado na classe `ProdutoFactory` para encapsular a criação dos objetos (`Livro` e `Eletronico`), removendo a complexidade de instanciação do Controller.
3.  **DAO (Data Access Object):** Implementado através da interface `Dao`. Isso isola a camada de dados, permitindo que o sistema mude de "Memória" para "SQL" futuramente sem quebrar o restante do código.

## ⚙️ Funcionalidades

* **Cadastro de Produtos:** Permite adicionar Livros (com autor) e Eletrônicos (com marca).
* **Validação de Dados:** O sistema trata entradas inválidas (ex: letras em campos numéricos, IDs duplicados).
* **Listagem Polimórfica:** Exibe detalhes específicos de cada tipo de produto.
* **Remoção Segura:** Remove produtos baseados no ID único.

## 🔧 Como Executar

### Pré-requisitos
* Java JDK 8 ou superior instalado.

### Passo a passo
1.  Clone este repositório:
    ```bash
    git clone [https://github.com/Userkhan444/Sistema_Estoque.git](https://github.com/Userkhan444/Sistema_Estoque.git)
    ```

2.  Navegue até a pasta do código fonte:
    ```bash
    cd Sistema_Estoque/src
    ```

3.  Compile o projeto:
    ```bash
    javac Main.java controller/*.java dao/*.java factory/*.java model/*.java view/*.java
    ```
    *(Ou simplesmente `javac Main.java */*.java` se seu terminal suportar)*

4.  Execute o sistema:
    ```bash
    java Main
    ```

* 👥 Autores

* **Davison Gabriel Monteiro de Farias** - (202424448)

*Projeto desenvolvido para fins acadêmicos - 2025.*
