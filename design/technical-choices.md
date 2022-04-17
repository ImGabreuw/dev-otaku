# Escolhas técnicas

**IMPORTANTE**: tópicos anotados com `*` = implementação posterior

> ## **`anime-service`**

- Domain Driven Design

- Clean Architecture

- Java

  - Maven

  - Lombok

  - Spring

    - Spring Bean Validation

    - Spring Web MVC

    - Spring Actuator

    - Spring Data JPA

- H2 Database (testes)

- PostgreSQL (produção)

- GitHub Actions

- Docker

- Kubernetes*

> ## **`authentication-service`**

- Domain Driven Design

- Clean Architecture

- Java

  - Maven

  - Lombok

  - Spring

    - Spring Bean Validation

    - Spring Web MVC

    - Spring Actuator

    - Spring Security

    - Spring Data JPA

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **`comic-service`**

- Domain Driven Design

- Clean Architecture

- Java

  - Maven

  - Lombok

  - Spring

    - Spring Bean Validation

    - Spring Web MVC

    - Spring Actuator

    - Spring Data JPA

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **`mal-service`**

- Domain Driven Design

- Clean Architecture

- TypeScript

  - Express

  - Pino / Pino Pretty

  - Prisma

  - ESLint

  - Prettier

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **`notification-service`**

- Domain Driven Design

- Clean Architecture

- Go

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **`recommendation-service`**

- Domain Driven Design

- Clean Architecture

- (**definir linguagem de programação**)

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **`user-service`**

- Domain Driven Design

- Clean Architecture

- Java

  - Maven

  - Lombok

  - Spring

    - Spring Bean Validation

    - Spring Web MVC

    - Spring Actuator

    - Spring Data JPA

- H2 Database

- PostgreSQL

- GitHub Actions

- Docker

- Kubernetes*

> ## **Detalhamento**

- **Domain Driven Design**: modelagem de software para auxiliar na construção do domínio (regras de domínio e a dinâmica interna)

- **Clean Architecture**: estilo arquitetura para garantir uma aplicação extensível, de fácil manutenção e desacoplada de linguagem e framework

- **Java**: linguagem madura com uma diversidade de bibliotecas e com solução de vários problemas na internet

  - **Lombok**: ganho de produtividade e redução no _boilerplate_ com anotações intuitivas

  - **Maven**: único gerenciador de dependência que mexi

  - **Spring**

    - **Spring Bean Validation**: biblioteca de validação simples de trabalhar e com fácil personalização

    - **Spring Web MVC**: biblioteca para desenvolvimento web com várias anotações que facilitam o desenvolvimento

    - **Spring Actuator**: endpoints de monitoramento já configurados, fácil personalização dos parâmetros de observabilidade, simplicidade na criação de endpoints customizados

    - **Spring Data JPA**: diversidade na criação de queries SQL (**query method**, _JPQL_)

- **TypeScript**: maior eficiência no desenvolvimento com tipagens, maior proximidade com linguagens orientada a objeto

  - **Express**: framework maior utilizado para desenvolvimento web no ecossistema JavaScript

  - **Pino / Prino Pretty**: framework de logging

  - **Prisma**: framework de acesso a dados que fornece simplicidade na criação/execução de migrations e linguagem própria para a criação de tabelas

  - **ESLint / Pretty**: padronização do código e que cumprem com as boas práticas definidas pela comunidade

- **Go**: facilidade ao trabalhar com multithreading, baixa curva de aprendizagem (conheço muito pouco sobre a linguagem)

- **Docker**: simplicidade na configuração do ambiente de desenvolvimento e de produção, facilidade na alternância entre ambiente e perfis, eficiência na distribuição da aplicação com outros desenvolvedores

- **Kubernetes**: tem suporte a monitoramento de cada container em execução, garante a resiliência dos mesmos, configuração declarativa (arquivos `.yaml`)

- **Git**: versionador de código mais utilizado, com isso facilita a busca de soluções para possíveis problemas na internet

- **ArgoCD**: ferramenta declarativa de entrega contínua (GitOps) para facilitar o gerenciamento de implantações de novas versões da aplicação no cluster Kubernetes

- **GitHub**: serviço para armazenar toda a base de código do projeto (único que mexi)

  - **GitHub Actions**: é uma plataforma de CI e CD integrado aos repositórios no GitHub. Ele possui um marketplace com várias _actions_ prontas uso e para diversos casos de uso

- **H2 Database**: banco de dados em memória escolhido para testes devido a simplicidade na configuração e a rapidez

- **PostgreSQL**: banco de dados escolhido para produção

  > **OBS**: a escolha do PostgreSQL foi arbitrária por causa da minha familiaridade com esse tipo de banco de dado