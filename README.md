# 🛒 E-commerce Microserviços

Um projeto de e-commerce desenvolvido com **Spring Boot 4.0.1** e **Java 21**, utilizando arquitetura de **microserviços** para aprender e praticar várias funcionalidades avançadas do Spring Boot.

> ⚠️ **Status:** Projeto em desenvolvimento

## 📋 Sobre o Projeto

Este projeto implementa um sistema de e-commerce com múltiplos microserviços independentes que se comunicam através de **mensageria (RabbitMQ/AMQP)**. O objetivo é explorar e consolidar conhecimentos em:

- ✅ Spring Boot (Web, Data JPA, AMQP)
- ✅ Arquitetura de Microserviços
- ✅ Docker & Docker Compose
- ✅ Mensageria (RabbitMQ)
- ✅ Bancos de Dados Relacionais
- ✅ API REST

## 🏗️ Arquitetura

O projeto está organizado em três microserviços principais:

```
meu-ecommerce-microservicos/
├── inventory/        → Serviço de Inventário
├── order/           → Serviço de Pedidos
├── product/         → Serviço de Produtos (em desenvolvimento)
└── docker-compose.yml
```

### 📦 Microserviços

#### **Inventory (Inventário)**
- **Porta:** 8081
- **Descrição:** Verifica disponibilidade e realiza reserva de produtos
- **Java Version:** 21
- **Dependências principais:** Spring Data JPA, Spring AMQP

#### **Order (Pedidos)**
- **Porta:** 8082
- **Descrição:** Recebe pedidos, gerencia status da compra e histórico
- **Java Version:** 21
- **Dependências principais:** Spring Data JPA, Spring AMQP, Spring MVC

#### **Product (Produtos)**
- **Status:** Em desenvolvimento
- **Descrição:** Gerenciamento do catálogo de produtos

## 🔧 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4.0.1**
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter AMQP
  - Spring Boot DevTools
- **Docker & Docker Compose**
- **RabbitMQ** (Mensageria)
- **Maven** (Build & Dependency Management)
- **Banco de Dados:** PostgreSQL/MySQL (configurável)

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Docker & Docker Compose
- Maven 3.6+ (ou usar `mvnw`)

### 1. Clonar o Repositório

```bash
git clone https://github.com/betolara1/meu-ecommerce-microservicos.git
cd meu-ecommerce-microservicos
```

### 2. Iniciar os Serviços com Docker Compose

```bash
docker-compose up -d
```

Isso iniciará:
- RabbitMQ (message broker)
- Bancos de dados necessários
- Microserviços

### 3. Executar Localmente (Desenvolvimento)

Para cada microserviço:

```bash
cd <microservico>
./mvnw spring-boot:run
```

Ou com Maven instalado:

```bash
mvn spring-boot:run
```

## 📡 Comunicação Entre Serviços

Os microserviços se comunicam através de **filas RabbitMQ (AMQP)**:

```
Order Service → [Fila] → Inventory Service
                ↓
           [Confirmação]
```

## 🗂️ Estrutura de Projeto

Cada microserviço segue a seguinte estrutura:

```
microservico/
├── src/
│   ├── main/
│   │   ├── java/com/betolara1/<service>/
│   │   │   ├── <Service>Application.java
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── dto/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/betolara1/<service>/
├── pom.xml
├── mvnw
└── compose.yaml
```

## 🔗 Endpoints Disponíveis

### Order Service (8082)

- `GET /api/orders` - Listar pedidos
- `POST /api/orders` - Criar novo pedido
- `GET /api/orders/{id}` - Buscar pedido específico

### Inventory Service (8081)

- `GET /api/inventory` - Verificar estoque
- `POST /api/inventory/reserve` - Reservar produto

## 📝 Configuração

Cada microserviço possui seu arquivo `application.properties`:

```properties
spring.application.name=order
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/order_db
spring.datasource.username=root
spring.datasource.password=password
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
```

## 🧪 Testes

Para executar os testes de um microserviço:

```bash
cd <microservico>
./mvnw test
```

Ou com Maven:

```bash
mvn test
```

## 📚 Aprendizados

Este projeto foi criado para consolidar conhecimentos em:

- [ ] Spring Boot Web (REST APIs)
- [ ] Spring Data JPA (Persistência de dados)
- [ ] Spring AMQP (Mensageria)
- [ ] Docker & Containerização
- [ ] Arquitetura de Microserviços
- [ ] Padrões de Design (DTO, Repository, Service)
- [ ] Testes Unitários e de Integração

## 🔄 Próximos Passos

- [ ] Completar microserviço Product
- [ ] Implementar logging centralizado (ELK Stack)
- [ ] Adicionar autenticação/autorização (OAuth2/JWT)
- [ ] Implementar circuit breaker (Resilience4j)
- [ ] Service discovery (Eureka/Consul)
- [ ] API Gateway
- [ ] Melhorar testes (Unit, Integration, E2E)
- [ ] Documentação Swagger/OpenAPI

## 📖 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring AMQP](https://spring.io/projects/spring-amqp)
- [Docker Documentation](https://docs.docker.com/)
- [RabbitMQ Tutorial](https://www.rabbitmq.com/getstarted.html)

## 👨‍💻 Autor

**Ralf Betolara**

## 📄 Licença

Projeto de aprendizado pessoal.

---

**Última atualização:** Janeiro de 2026  
**Status:** Em desenvolvimento 🚧
