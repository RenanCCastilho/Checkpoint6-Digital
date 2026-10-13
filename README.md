# Catálogo de Produtos — Spring MVC + Thymeleaf

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle_DB-F80000?logo=oracle&logoColor=white)

Aplicação web para cadastro e gerenciamento de produtos, com páginas renderizadas no servidor usando **Thymeleaf**. A interface tem **internacionalização (i18n)** em português e inglês.

## Funcionalidades

- Listagem, cadastro, edição e exclusão de produtos (nome, descrição, preço e data de cadastro)
- Páginas server-side com Thymeleaf
- Mensagens traduzidas em `pt` e `en` (`src/main/resources/i18n`)
- Persistência em Oracle com Spring Data JPA
- Testes de serviço com JUnit

## Rotas

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista de produtos |
| `GET` | `/produtos/novo` | Formulário de cadastro |
| `POST` | `/produtos` | Salva novo produto |
| `GET` | `/produtos/editar/{id}` | Formulário de edição |
| `POST` | `/produtos/editar/{id}` | Salva alterações |
| `GET` | `/produtos/deletar/{id}` | Remove produto |

## Como executar

```bash
cd CheckDigital-6
export DB_USERNAME=seu_usuario
export DB_PASSWORD=sua_senha
./mvnw spring-boot:run
```

Depois, acesse `http://localhost:8080/produtos`.

## Equipe

| RM | Nome |
|---|---|
| 94265 | Daniel Ferreira dos Santos |
| 93451 | Felipe Cardenaz de Melo |
| 88383 | Felipe Jardim |
| 94394 | Renan Castilho Costa |
| 92979 | Ricardo dos Santos Altavista |
| 94717 | Tarcisio Ferreira Couto |

---

Projeto acadêmico desenvolvido na **FIAP** (Digital Business Enablement, 2023).
