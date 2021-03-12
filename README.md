# Desafio Back-End

Esse é o nosso desafio para os candidatos à vaga de back-end na [TradeMap](https://www.linkedin.com/company/trademaphub).

Mesmo que você não esteja em nosso processo seletivo, você pode iniciá-lo resolvendo esse desafio.

Atualmente, todo o nosso backend está escrito em Java/Kotlin, utilizando Spring como framework.

# Instruções Inicialização - Projeto

1. Clone o repositório git@github.com:fogeid/desafio-backend.git
2. Ou faça o download do arquivo ZIP do projeto em https://github.com/fogeid/desafio-backend
3. Importar o projeto em sua IDE de preferência (lembre-se, projeto baseado em Spring & Maven)
4. Buildar o projeto e executá-lo.

# Rotas

- GET UNITY - /posts/id
- GET PAGE - /posts?page=0
- GET ALL - /posts
- POST - /posts
{
"title": "Primeiro título",
"description": "Primeiro post do blog",
"body": "Hellow world!",
"created_at": "2019-06-20T19:53:07Z"
}
- UPDATE - /posts/id
{
"title": "Update título",
"description": "Update post do blog",
"body": "Hellow world com update!"
}
- DELETE - /posts/id
