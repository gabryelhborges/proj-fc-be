# AtivoOperante_BE

Sistema backend para registro e acompanhamento de denúncias públicas, desenvolvido em **Spring Boot** com integração ao banco de dados **PostgreSQL**. O projeto permite que cidadãos registrem denúncias, acompanhem o andamento e recebam feedback dos órgãos responsáveis. Administradores podem gerenciar tipos de problemas, órgãos, denúncias e fornecer feedback.

---

## Sumário

- Funcionalidades
- Estrutura do Projeto
- Tecnologias Utilizadas
- Configuração do Ambiente
- Como Executar
- Endpoints Principais
- Autenticação
- Scripts do Banco de Dados
- Testes
- Licença

---

## Funcionalidades

- **Cidadão**
  - Registrar denúncias
  - Listar órgãos competentes
  - Listar tipos de problemas
  - Consultar denúncias próprias
  - Visualizar feedbacks

- **Administrador**
  - CRUD de tipos de problemas
  - CRUD de órgãos
  - Listar e excluir denúncias
  - Registrar feedback em denúncias

---

## Estrutura do Projeto

```
src/
  main/
    java/
      unoeste/fipp/ativooperante_be/
        controllers/      # Controllers REST
        db/
          entities/       # Entidades JPA
          repositories/   # Repositórios JPA
        security/         # JWT e filtros de acesso
        services/         # Regras de negócio
    resources/
      application.properties # Configuração do banco
  test/
    java/
      unoeste/fipp/ativooperante_be/
        AtivooperanteBeApplicationTests.java # Testes de contexto
ativooperante.sql         # Script de criação do banco
pom.xml                   # Dependências Maven
```

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **PostgreSQL**
- **JWT (JSON Web Token)**
- **Maven**

---

## Configuração do Ambiente

1. **Banco de Dados**
   - Instale o PostgreSQL.
   - Execute o script [`ativooperante.sql`](ativooperante.sql) para criar as tabelas e dados iniciais.

2. **Configuração de acesso**
   - Edite [`src/main/resources/application.properties`](src/main/resources/application.properties) conforme seu ambiente:
     ```
     spring.datasource.url=jdbc:postgresql://localhost/ativooperante
     spring.datasource.username=postgres
     spring.datasource.password=postgres123
     ```

3. **Dependências**
   - Use Maven para instalar as dependências:
     ```sh
     ./mvnw clean install
     ```

---

## Como Executar

```sh
./mvnw spring-boot:run
```
O backend estará disponível em `http://localhost:8080`.

---

## Endpoints Principais

### Autenticação

- `POST /apis/logar`  
  Autentica usuário e retorna JWT.

- `POST /apis/cadastro-cidadao`  
  Cadastro de novo cidadão.

### Cidadão

- `POST /apis/cidadao/add-denuncia`  
  Registrar denúncia.

- `GET /apis/cidadao/get-all-orgaos`  
  Listar órgãos.

- `GET /apis/cidadao/get-all-tipos`  
  Listar tipos de problemas.

- `GET /apis/cidadao/get-denuncias-cidadao?userId={id}`  
  Listar denúncias do usuário.

### Administrador

- `POST /apis/adm/add-tipo`  
  Adicionar tipo de problema.

- `PUT /apis/adm/alterar-tipo`  
  Alterar tipo de problema.

- `DELETE /apis/adm/del-tipo-id/{id}`  
  Excluir tipo de problema.

- `POST /apis/adm/add-orgao`  
  Adicionar órgão.

- `PUT /apis/adm/alterar-orgao`  
  Alterar órgão.

- `DELETE /apis/adm/del-orgao-id/{id}`  
  Excluir órgão.

- `GET /apis/adm/get-all-denuncias`  
  Listar todas as denúncias.

- `DELETE /apis/adm/del-denuncia-id/{id}`  
  Excluir denúncia.

---

## Autenticação

A autenticação é feita via JWT.  
Inclua o token no header `Authorization` para acessar rotas protegidas.

Exemplo:
```
Authorization: <seu-token-jwt>
```

---

## Scripts do Banco de Dados

O script [`ativooperante.sql`](ativooperante.sql) contém toda a estrutura e dados iniciais do banco.

---
