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

## Entidades

### 1. Cliente
- **Atributos:** id, nome, telefone
  - **Regra de Negócio:** Não pode ser cadastrado com nome vazio

### 2. Horário
- **Atributos:** id, horaInicio, horaFim, valor
  - **Regra de Negócio:** Não pode ter valor negativo

### 3. Aluguel
- **Atributos:** id, cliente, horario, data, valorCobrado
  - **Regra de Negócio:** Horário não pode estar ocupado na mesma data

## Funcionalidades

### 1. Cadastrar Cliente
- Valida se o nome não está vazio
  - Atribui ID automático
  - Mensagem de sucesso

### 2. Cadastrar Horário Disponível
- Valida se o valor é não-negativo
  - Armazena horário de início e fim
  - Atribui ID automático

### 3. Registrar Aluguel
- Valida se cliente existe
  - Valida se horário existe
  - Verifica se horário já está ocupado naquela data
  - Calcula automaticamente desconto se houver múltiplos aluguéis no mesmo dia
  - Atribui ID automático

### 4. Consultar Aluguéis por Data
- Retorna lista de todos os aluguéis em uma data específica
  - Facilita análise de ocupação diária

### 5. Listar Clientes
- Exibe todos os clientes cadastrados

### 6. Listar Horários
- Exibe todos os horários disponíveis

### 7. Listar Aluguéis
- Exibe todos os aluguéis registrados

## Regras de Negócio Implementadas

✅ **Não reservar um horário já ocupado**
- Verifica se o horário está ocupado na data solicitada
  - Impede duplicação de reservas

✅ **Ser possível consultar todos os aluguéis realizados em um determinado dia**
- Método de consulta por data implementado
  - Filtro por data de aluguel

✅ **Não pode ser possível cadastrar clientes com nome vazio**
- Validação de string vazia ou null
  - Trim de espaços em branco

✅ **Não ser possível cadastrar horários com valor negativo**
- Validação de valor menor que zero
  - Rejeição de valores negativos

✅ **Calcular automaticamente o valor total se houver mais de um horário no mesmo dia**
- Aplicação de desconto de 10% por aluguel adicional
  - Cálculo automático no momento do registro

## Camadas do Sistema

### Model (Entidades)
- Contém as classes de domínio
  - Sem lógica de negócio

### Service (Lógica de Negócio)
- **TODAS** as regras de negócio estão implementadas aqui
  - Validações, cálculos e operações complexas
  - Uso de streams Java para filtros eficientes

### Controller (Intermediário)
- Delegação de chamadas para a Service
  - Sem lógica de negócio complexa

### Main (Interface)
- Menu interativo com usuário
  - Entrada/saída de dados
  - Tratamento de exceções de entrada

## Como Usar

1. **Compile o projeto**
   ```bash
   javac -d target/classes -sourcepath src/main/java src/main/java/**/*.java
   ```

   2. **Execute o programa**
      ```bash
      java -cp target/classes EstruturacaoDeSistemas.Main
      ```

   3. **Siga o menu interativo**
      - Digite o número da opção desejada
      - Insira os dados nos formatos solicitados

## Formatos de Entrada

- **Hora:** HH:mm (ex: 14:30)
  - **Data:** yyyy-MM-dd (ex: 2026-03-27)
  - **Valor:** Número decimal (ex: 50.00)

## Validações Implementadas

| Validação | Implementada | Local |
|-----------|--------------|-------|
| Nome cliente não vazio | ✅ | Service |
| Valor horário não negativo | ✅ | Service |
| Horário não ocupado | ✅ | Service |
| Cliente existe | ✅ | Service |
| Horário existe | ✅ | Service |
| Formato de data válido | ✅ | Main |
| Formato de hora válido | ✅ | Main |
| Valor válido (número) | ✅ | Main |

## Tratamento de Erros

Todos os erros são tratados com mensagens claras:
- Validações de negócio retornam boolean
  - Exceções de parsing são capturadas
  - Mensagens informativas ao usuário

## Melhorias Implementadas

1. Separação clara entre camadas
   2. Uso de Lambda e Streams Java
   3. Validações em nível de Service
   4. Nomes claros e documentação
   5. Menu interativo user-friendly
   6. Tratamento de exceções
   7. ID automático para entidades

