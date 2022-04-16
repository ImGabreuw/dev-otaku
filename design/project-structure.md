# Estrutura do projeto

> ## **Estrutura de diretórios**

```
dev-otaku
  ├── anime-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   └── infrastructure
  ├── authentication-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   ├── cli
  │   └── infrastructure
  ├── comic-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   └── infrastructure
  ├── design
  ├── docs
  │   └── assets
  ├── mal-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   └── infrastructure
  ├── notification-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   └── infrastructure
  ├── recommendation-service
  │   ├── domain
  │   ├── usecases
  │   ├── web
  │   └── infrastructure
  └── user-service
      ├── domain
      ├── usecases
      ├── web
      ├── cli
      └── infrastructure
```

- `anime-service`: serviço de gerenciamento de animes

- `authentication-service`: serviço de autenticação e autorização

- `comic-service`: serviço de gerenciamento de mangas, manhwas e webtoon

- `design`: planejamento e _timeline_ na decisão do design da aplicação

- `docs`: documentação de APIs e de regras de domínio/aplicação

- `mal-service`: serviço de coleta de dados oriundos da API do [_My Anime List_](https://myanimelist.net/)

- `notification-service`: serviço de notificação de novos lançamentos do dia (de acordo com cada usuário)

- `recommendation-service`: serviço de recomendação de animes e mangas (utilização do endpoint de sugestão de anime da [_API do My Anime List_](https://myanimelist.net/apiconfig/references/api/v2#operation/anime_suggestions_get))

- `user-service`: serviço de gerenciamento de usuários