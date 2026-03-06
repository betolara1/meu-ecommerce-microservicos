# 🌐 Guia Central de Acesso e Monitoramento

Este documento centraliza todas as informações de acesso, rotas e monitoramento para os microserviços do E-commerce.

## 🚪 API Gateway (Ponto de Entrada Único)
O Gateway é a porta de entrada para todas as requisições externas. No ambiente Docker, ele expõe a porta `8080`.

| Microserviço | Prefixo da Rota | URL Exemplo |
| :--- | :--- | :--- |
| **User (Auth)** | `/auth/**` | [http://localhost:8080/auth/login](http://localhost:8080/auth/login) |
| **User (Perfil)** | `/users/**` | [http://localhost:8080/users/listAll](http://localhost:8080/users/listAll) |
| **Product** | `/products/**` | [http://localhost:8080/products/listAll](http://localhost:8080/products/listAll) |
| **Order** | `/orders/**` | [http://localhost:8080/orders/listAll](http://localhost:8080/orders/listAll) |
| **Inventory** | `/inventory/**` | [http://localhost:8080/inventory/listAll](http://localhost:8080/inventory/listAll) |
| **Payments** | `/payments/**` | [http://localhost:8080/payments/listAll](http://localhost:8080/payments/listAll) |

---

## 🐇 RabbitMQ (Mensageria)
Interface de gerenciamento de filas e exchanges do RabbitMQ.

- **Link**: [http://localhost:15672](http://localhost:15672)
- **Login**: `guest`
- **Senha**: `guest`
- **Uso**: Visualize mensagens trafegando entre microserviços (ex: `payment.created`, `inventory.reserved`).

---

## 🔍 Eureka (Service Discovery)
Painel de controle que mostra quais microserviços estão online e registrados.

- **Link**: [http://localhost:8761](http://localhost:8761)
- **Uso**: Verifique se todas as instâncias (Order, User, etc.) estão com status `UP`.

---

## 📊 Spring Boot Actuator (Saúde e Métricas)
Todos os microserviços possuem o Actuator configurado para monitoramento. Você pode acessar via Gateway ou diretamente na porta do serviço.

| Funcionalidade | Endpoint | Descrição |
| :--- | :--- | :--- |
| **Lista Geral** | `/actuator` | Lista todos os links de monitoramento disponíveis. |
| **Saúde (Health)** | `/actuator/health` | Verifica se o serviço e o Banco de Dados estão OK. |
| **Métricas** | `/actuator/metrics` | Exibe estatísticas de CPU, Memória e Threads. |
| **Prometheus** | `/actuator/prometheus` | Métricas formatadas para o painel Grafana/Prometheus. |

### Configuração de Exposição
Para liberar novos endpoints (como `beans` ou `env`), altere no `application.properties`:
```properties
management.endpoints.web.exposure.include=health,info,prometheus,metrics
```

---

## 🔐 Autenticação e Login
Para acessar rotas protegidas (ex: `/orders`), você deve seguir este fluxo:

1. **Login**: Faça um POST para [http://localhost:8080/auth/login](http://localhost:8080/auth/login) com:
   ```json
   { "username": "seu_email@v.com", "password": "sua_password" }
   ```
2. **Token**: Copie o `token` JWT retornado.
3. **Uso**: Adicione o header `Authorization: Bearer <seu_token>` nas suas próximas requisições.

> [!TIP]
> Use o **Postman** ou **Insomnia** para automatizar o envio do token Bearer.

---
*Atualizado por Antigravity em Março de 2026*
