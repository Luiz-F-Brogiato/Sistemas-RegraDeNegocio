# Sistema de Controle de Aluguel de Quadra Esportiva

## Entidades Identificadas (Tabelas)

- **Cliente**: nome, telefone
- **Horário**: horaInicio, horaFim, valor
- **Aluguel**: cliente, horário, data, valorCobrado

## Regras de Negócio Identificadas

- Não reservar um horário já ocupado
- Ser possível consultar todos os aluguéis realizados em um determinado dia
- Não pode ser possível cadastrar clientes com nome vazio
- Não ser possível cadastrar horários com valor negativo
- Calcular automaticamente o valor total se houver mais de um horário no mesmo dia
