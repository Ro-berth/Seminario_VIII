# CobSA API

## Visão Geral
CobSA (Cobrança Simples API) é uma API RESTful desenvolvida para facilitar a gestão de clientes e cobranças. Ela permite que usuários criem, atualizem, recuperem e excluam informações de clientes e cobranças de um sistema de gerenciamento.

Para mais Informações Leia [Codedoc](https://github.com/jcr04/CobSA.Java/blob/main/Codedoc.md).

## Funcionalidades

### Clientes
- **Listar todos os clientes**: Retorna uma lista de todos os clientes registrados.
- **Obter cliente por ID**: Retorna os detalhes de um cliente específico.
- **Criar um novo cliente**: Permite a inserção de um novo cliente no sistema.
- **Atualizar um cliente existente**: Atualiza os detalhes de um cliente existente.
- **Excluir um cliente**: Remove um cliente do sistema.

### Cobranças
- **Listar todas as cobranças**: Retorna uma lista de todas as cobranças criadas.
- **Obter cobrança por ID**: Retorna os detalhes de uma cobrança específica.
- **Criar uma nova cobrança**: Permite a criação de uma nova cobrança para um cliente.
- **Atualizar uma cobrança existente**: Atualiza os detalhes de uma cobrança existente.
- **Excluir uma cobrança**: Remove uma cobrança do sistema.

## Tecnologias Utilizadas
- Spring Boot
- Maven
- PostgresSQL
- ModelMapper
- Swagger/OpenAPI para documentação

## Como Iniciar

### Pré-requisitos
- Java 17
- Maven
- PostgreSQL

### Instruções de Instalação e Execução
1. Clone o repositório para sua máquina local.
2. Configure o banco de dados PostgreSQL.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

## Contribuição
Instruções para contribuir com o projeto CobSA.

1. Faça um fork do repositório.
2. Crie uma branch para sua funcionalidade ou correção (`git checkout -b feature/nome-da-feature`).
3. Faça commit das suas mudanças (`git commit -am 'Adiciona alguma feature'`).
4. Push para a branch (`git push origin feature/nome-da-feature`).
5. Crie um novo Pull Request.
