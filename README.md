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
