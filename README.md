# Rotas

- Criar um Post (método POST)
[https://trademap.herokuapp.com/api/post](https://trademap.herokuapp.com/api/post)
- Editar um Post  (método PUT)
[https://trademap.herokuapp.com/api/post](https://trademap.herokuapp.com/api/post)
- Deletar um Post (método DELETE)
[https://trademap.herokuapp.com/api/post](https://trademap.herokuapp.com/api/post)
- Listar os Posts (método GET)
[https://trademap.herokuapp.com/api/posts](https://trademap.herokuapp.com/api/posts)
- Obter informações de um Post por ID (método GET).
[https://trademap.herokuapp.com/api/post/{id}](https://trademap.herokuapp.com/api/post/1)

Modelo de um objeto post em JSON, para servir de exemplo nas rotas de post, update e delete:
```
{
	"title": "trademap-douglas",
	"description": "descricao",
	"body": "corpo",
	"createdAt": "17/03/2021",
	"updatedAt": "17/03/2021"
}
```

Obs: Confira minha solução do desafio de front-end também :)
[https://github.com/TheeDouglasAM3/desafio-frontend](https://github.com/TheeDouglasAM3/desafio-frontend)