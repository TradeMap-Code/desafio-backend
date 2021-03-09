# Valemobi - Desafio Back-End

Esse é o nosso desafio para os candidatos à vaga de back-end na [Valemobi](https://www.linkedin.com/company/valemobi/mycompany).

Mesmo que você não esteja em nosso processo seletivo, você pode iniciá-lo resolvendo esse desafio.

Atualmente, todo o nosso backend está escrito em Java/Kotlin, utilizando Spring como framework.

# O Desafio

Precisamos de uma API que sirva o Back-end de um blog. Essa API precisa ser capaz de:

- Criar um Post
- Editar um Post
- Deletar um Post
- Listar os Posts de maneira paginada, permitindo filtro por data.
- Obter informações de um Post por ID.

A entidade `Post`, deve ter os seguintes campos:

- id -> Identificador do Post.
- title -> Título do Post.
- description -> Descrição do Post.
- body -> Corpo do Post.
- created_at -> Data de criação do Post.
- updated_at -> Data de atualização do Post.

Você pode utilizar qualquer banco, desde que ele seja [SQL](http://www.sqlcourse.com/intro.html).

## Requisitos

- Todas as respostas precisam ser retornadas no formato [JSON](https://www.json.org/json-en.html).
- Crie um `README.md` com as informações de como usar sua aplicação. (como executar, quais são as rotas, etc)
- Publique sua aplicação em algum servidor. (Heroku, AWS, Azure, Digital Ocean)

## Diferenciais

- Utilize migrations para a criação dos Schemas da sua aplicação. (Flyway, Liquibase)
- [Dockerize](https://www.docker.com/) sua aplicação.
- Crie testes unitários para a sua aplicação.
- Utilize os princípios SOLID em sua aplicação.

## Como entregar o teste

1. Faça um fork desse repositório.
2. Resolva o desafio da melhor maneira que você puder.
3. Envie um pull-request para análise do resultado.