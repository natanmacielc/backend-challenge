
# Password Validator API

## Descrição

Este projeto implementa uma API REST que valida se uma senha atende a um conjunto específico de critérios, garantindo segurança e complexidade mínimas exigidas em aplicações modernas.

---

## Como executar o projeto

### Pré-requisitos

- Java 24
- Maven

### Passos para executar

1. Compile e execute o projeto usando Maven:

```bash
./mvnw spring-boot:run
```

2. Acesse a API através da seguinte URL:

```
POST http://localhost:8080/password-validator
```

---

## Sobre a Solução

### Decisões Técnicas e Racional

- **Clean Architecture e SOLID**: O projeto foi estruturado seguindo os princípios de Clean Architecture para separar claramente responsabilidades entre domínio, aplicação e infraestrutura, facilitando manutenção, testes e futuras extensões.

- **Uso de DTOs**: Utilizei DTOs (`PasswordValidatorResponseDTO`) para abstrair a resposta da API, permitindo flexibilidade em possíveis alterações futuras de formato sem afetar o modelo de domínio.

- **Abstração e Interface**: Foi criado um contrato (`PasswordValidator`) e uma implementação concreta (`PasswordValidatorImpl`), possibilitando fácil substituição ou adição de novos critérios sem modificar significativamente o código existente.

- **Testes de Unidade**: Foram incluídos testes unitários abrangentes para garantir a robustez da validação da senha (`PasswordValidatorImplTest`, entre outros), cobrindo múltiplos cenários e casos extremos.

- **Testes de Integração**: Foram incluídos testes de integração simulando requisições HTTP (`BackendChallengeApplicationTests`), para garantir o funcionamento da API, e formato de saída JSON.

### Premissas e Decisões Tomadas

- Espaços em branco foram considerados inválidos e removidos explicitamente antes da validação, conforme premissa clara do desafio.
- Método HTTP utilizado pelo endpoint foi o POST
- Content-Type utilizado pela API foi o application/json, recebendo a string e devolvendo o valor booleano dentro de uma estrutura JSON

---

## Estrutura do Projeto

- **`application`**: Contém recursos REST e casos de uso.
- **`domain`**: Engloba lógica de negócio, modelos de domínio e validadores específicos.

---

## Conclusão

Esta implementação foca em código limpo, extensível e fácil de manter, com testes rigorosos para garantir a qualidade da solução. As decisões técnicas tomadas buscam maximizar legibilidade, manutenibilidade e alinhamento com boas práticas de desenvolvimento.
