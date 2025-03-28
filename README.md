# Documentação da API Checkpoint1

Este é um projeto de API Spring Boot para o Checkpoint1.

## Instalação

* Limpe e crie a pasta */target*:

```bash
mvn clean package
```

* Configuração do Swagger

Para configurar o Swagger UI, adicione as seguintes propriedades ao seu arquivo `application.properties`:

```properties:c:\Users\carol\OneDrive\Desktop\www\checkpoint1\src\main\resources\application.properties
springdoc.swagger-ui.path=/
springdoc.swagger-ui.disable-swagger-default-url=true
```

## Navegação
### Executando a API
* Execute usando **Maven**:
```bash
mvn spring-boot:run
```

### Documentação da API (Swagger)
- Acesse o Swagger UI em: *http://localhost:8080/*

## Estrutura do Projeto
O projeto está organizado como uma aplicação Spring Boot padrão:
- `src/main/java/br/com/fiap/checkpoint1`: Código principal da aplicação
- `src/test/java/br/com/fiap/checkpoint1`: Classes de teste

## Dependências
Este projeto utiliza as seguintes dependências principais:
- Spring Boot 3.4.3
- Spring Boot DevTools
- Spring Boot Test
- SpringDoc OpenAPI UI 2.5.0

## Referências
- [Documentação SpringDoc OpenAPI](https://springdoc.org/)
- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
