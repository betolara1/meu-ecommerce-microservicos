# 🔍 Análise Completa — E-commerce Microserviços

Análise de todos os 5 microserviços (User, Product, Order, Payments, Inventory) com recomendações priorizadas por impacto.


## 🟡 Melhorias de Robustez (Infraestrutura)

### 18. Sem testes reais

Todos os 5 serviços têm apenas o teste padrão gerado pelo Spring Initializr:
```java
@Test
void contextLoads() { }
```

**O que falta:** Testes unitários para Services, testes de integração para Controllers (`@WebMvcTest`), testes para os consumers/producers RabbitMQ.

---

### 19. `ddl-auto=update` inadequado para produção

```properties
spring.jpa.hibernate.ddl-auto=update
```

Isso permite que o Hibernate altere o schema do banco em produção. **Use `validate` em produção** e gerencie migrações com **Flyway** ou **Liquibase**.

---


## 🟢 Melhorias Desejáveis (Polish)

| # | Melhoria | Descrição |
|---|----------|-----------|
| 30 | **CORS** | Nenhum serviço configura CORS para permitir acesso de frontends |


APRENDER JUnit