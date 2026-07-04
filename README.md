# 🎬 Catálogo de Filmes API

API REST desenvolvida com **Java 21** e **Spring Boot** para gerenciamento de um catálogo pessoal de filmes, integrada à API do **TMDB (The Movie Database)** para busca de informações em tempo real.

O projeto demonstra conceitos como arquitetura em camadas, integração com APIs externas, persistência de dados com PostgreSQL, validação de dados e documentação automática utilizando OpenAPI/Swagger.

---

## 🚀 Tecnologias

* Java 21
* Spring Boot 3.5
* Spring Web
* Spring Data JPA
* Bean Validation
* PostgreSQL
* Docker & Docker Compose
* OpenAPI / Swagger
* Railway

---

## ✨ Funcionalidades

* 🔍 Buscar filmes diretamente na API do TMDB
* 💾 Salvar filmes em um catálogo pessoal
* 📄 Listar todos os filmes salvos
* 🗑️ Remover filmes do catálogo
* ✅ Validação de dados nas requisições
* 📚 Documentação automática com Swagger

---

## 🌐 Deploy

A API está publicada no Railway.

**Documentação interativa (Swagger):**

https://catalogo-filmes-api-production.up.railway.app/swagger-ui/index.html

> **Dica:** utilize o Swagger para visualizar e testar todos os endpoints diretamente pelo navegador.

---

## 📋 Endpoints

| Método | Endpoint                         | Descrição                         |
| ------ | -------------------------------- | --------------------------------- |
| GET    | `/filmes`                        | Lista todos os filmes cadastrados |
| GET    | `/filmes/buscar?titulo={titulo}` | Busca filmes na API do TMDB       |
| POST   | `/filmes/salvar-do-tmdb`         | Salva um filme no catálogo        |
| DELETE | `/filmes/{id}`                   | Remove um filme pelo ID           |

---

## 💻 Exemplo de uso

### Buscar um filme

```http
GET /filmes/buscar?titulo=Interestelar
```

Resposta:

```json
[
  {
    "titulo": "Interestelar",
    "sinopse": "As reservas naturais da Terra ...",
    "notaMedia": 8.48,
    "posterUrl": "https://image.tmdb.org/t/p/w500/...",
    "anoLancamento": 2014
  }
]
```

---

## ⚙️ Configuração

Antes de executar a aplicação, configure as seguintes variáveis de ambiente:

```env
TMDB_API_KEY=SUA_CHAVE_TMDB

SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/catalogo
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

> É necessário possuir uma chave de API do **TMDB** para realizar buscas de filmes.

---

## ▶️ Executando o projeto

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd catalogo-filmes-api
```

### 2. Execute os containers

```bash
docker-compose up --build
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🏗️ Arquitetura

O projeto utiliza arquitetura em camadas para separar responsabilidades.

```text
Cliente
   │
   ▼
Controller
   │
   ▼
Service
   │
   ├── Repository ───► PostgreSQL
   │
   └────────────────► TMDB API
```

### Principais componentes

* **Controller** – Exposição dos endpoints REST.
* **Service** – Regras de negócio da aplicação.
* **Repository** – Persistência dos dados utilizando Spring Data JPA.
* **PostgreSQL** – Armazenamento dos filmes cadastrados.
* **TMDB API** – Consulta de informações de filmes em tempo real.

---

## 📌 Próximas melhorias

* Implementar autenticação com Spring Security e JWT
* Atualizar informações de filmes cadastrados
* Adicionar paginação e ordenação nas consultas
* Implementar testes unitários e de integração

---

## 👨‍💻 Autor

Projeto desenvolvido para estudo e prática de desenvolvimento de APIs REST utilizando Java, Spring Boot e PostgreSQL.
