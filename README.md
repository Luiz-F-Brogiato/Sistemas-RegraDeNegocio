# Sistema de Controle de Aluguel de Quadra Esportiva

## Descrição Geral
Sistema desenvolvido em Java para gerenciar aluguel de quadras esportivas com suporte a múltiplos clientes, horários e reservas com validações de regras de negócio.

## Estrutura do Projeto

### Arquitetura MVC
```
src/main/java/
├── EstruturacaoDeSistemas/
│   └── Main.java                 # Interface com usuário
├── model/
│   ├── Cliente.java             # Entidade Cliente
│   ├── Horario.java             # Entidade Horário
│   └── Aluguel.java             # Entidade Aluguel
├── controller/
│   └── AluguelController.java    # Controlador
└── service/
    └── AluguelService.java       # Lógica de negócio
```

