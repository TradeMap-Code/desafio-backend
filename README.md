# Desafio Back-End

Desafio Realizado dia 09/04/2021

# O Desafio

Criação de uma API com o Banco de Dados H2 database e Spring Boot

Com a utilização do H2 terá que executar a primeira opção conforme segue abaixo:

1- Criar um Post:
  http://localhost:8080/api/posts
   {
        "id": 0,
        "titulo": "Teste",
        "description": "Teste",
        "body": "Teste"
    }


2- Editar um Post:
http://localhost:8080/api/posts - Id no Json
  {
        "id": 1,
        "titulo": "Amanha é dia de alegria",
        "description": "Apenas um post sobre felicidade",
        "body": "Finge que tem uma mesagem"
    }


3- Deletar um Post:
http://localhost:8080/api/posts/1

4- Listar os Posts de maneira paginada, permitindo filtro por data:
http://localhost:8080/api/posts?createdAt={só colocar a data aqui}

5- Obter informações de um Post por ID:
http://localhost:8080/api/posts/1
