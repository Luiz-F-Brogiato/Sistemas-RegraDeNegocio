# Sistema de Controle de Biblioteca Escolar

## Visão Geral
Este sistema é uma aplicação Java para gerenciar empréstimos de livros em uma biblioteca escolar. Ele permite cadastrar livros e alunos, registrar empréstimos e devoluções, além de consultar informações sobre empréstimos em aberto.

## Entidades
- **Livro**: Representa um livro com título, autor e quantidade disponível.
- **Aluno**: Representa um aluno com ID e nome.
- **Empréstimo**: Representa um empréstimo com aluno, livro, data de empréstimo e data de devolução (se aplicável).

## Requisitos Funcionais
- Cadastrar livros (título, autor, quantidade disponível).
- Cadastrar alunos.
- Registrar empréstimo para alunos.
- Registrar quando o livro foi devolvido.
- Consultar livros emprestados.
- Consultar quais alunos estão com livros em aberto.

## Regras de Negócio
- Não emprestar livros se não houver quantidade disponível.
- Não permitir cadastrar livros com título vazio ou quantidade negativa.

## Arquitetura
- **Modelo**: Classes de domínio (Livro, Aluno, Empréstimo).
- **Serviço**: Lógica de negócio (LivroService, AlunoService, EmpréstimoService).
- **Controlador**: Coordenação entre serviços (BibliotecaController).
- **Apresentação**: Interface de console em Main.java.

## Como Executar
1. Compile o projeto com Maven: `mvn compile`
2. Execute a classe Main: `java -cp target/classes EstruturacaoDeSistemas.Main`
3. Use o menu interativo para interagir com o sistema.

## Tecnologias
- Java 21
- Maven para gerenciamento de dependências
- Armazenamento em memória (listas)
