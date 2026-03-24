# E-commerce Produto Management

Este é um sistema de gerenciamento de produtos e categorias para um e-commerce, desenvolvido em Java. O projeto foca em uma arquitetura limpa utilizando o padrão DAO (Data Access Object) com interfaces, garantindo desacoplamento e facilitando a manutenção e testes.

## 🛠️ Tecnologias Utilizadas

* **Java** (Linguagem principal)
* **JDBC** (Java Database Connectivity)
* **Oracle Database** (Banco de dados relacional)
* **Driver OJDBC8** (Comunicação com o banco Oracle)

## 🏗️ Arquitetura do Projeto

O projeto está estruturado em camadas para separar responsabilidades:

* **`entity`**: Classes de modelo (`Produto`, `Categoria`, `UnidadeMedidaPeso`, `UnidadeMedidaTamanho`).
* **`dao`**: Interfaces (`IProdutoDAO`, `ICategoriaDAO`) e implementações de persistência de dados utilizando o padrão **Singleton**.
* **`service`**: Regras de negócio (`ProdutoService`), lidando com validações, comparações e chamadas aos DAOs.
* **`db`**: Gerenciamento da conexão com o banco de dados (`DatabaseConnection`).
* **`exception`**: Tratamento de erros customizados (`ProdutoException`).

## ⚙️ Pré-requisitos

Antes de executar o projeto, você precisará ter instalado:

* [Java JDK](https://www.oracle.com/java/technologies/downloads/) (Versão 8 ou superior).
* Um banco de dados **Oracle** acessível.
* O driver JDBC do Oracle (`ojdbc8.jar`) adicionado ao *classpath* do projeto (via Maven, Gradle ou arquivo `.jar` manual).

## 🚀 Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```

2.  **Configuração do Banco de Dados:**
    * Abra a classe `DatabaseConnection.java` no pacote `br.com.ecommerce.produto.db`.
    * Altere as credenciais (`user` e `password`) para o seu usuário e senha do banco Oracle.
    * Certifique-se de que a URL de conexão está apontando para o servidor correto.

3.  **Criação das Tabelas:**
    * Execute os scripts DDL de criação de tabelas (Categorias, Unidades de Medida e Produtos) no seu banco de dados Oracle antes de rodar a aplicação.

4.  **Execução:**
    * O projeto pode ser instanciado e testado através de uma classe `Main` contendo o método genérico `public static void main(String[] args)`.
