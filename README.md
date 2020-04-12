# Cadastro de patrimonios

Manual de integração da Api de cadastro de patrimonios

Para facilitar a compreensão dos endpoints, este projeto conta com uma pasta para o software Postman, localizado na raiz deste projeto:

```
postman.json
```



Para facilitar a utilização do mesmo, defini algumas variáveis do projeto, para altera-las, basta editar a pasta e alterar as variáveis.



![image-20200412165757599](media/image-20200412165757599.png)



### Autenticação

##### Cadastro de novo usuário

Para ter acesso a api é necessário efetuar um login prévio para obter o token de autenticação.

Mas antes de efetuar o login, é necessário fazer o cadastro de usuários.

Usuários podem ser cadastrados na seguinte URL:

```
[HTTP.POST] {base-url}/usuario
```

Corpo da requisição:

```
{
	"nome":"Nome do usuário",
	"email":"exemplo@gmail.com",
	"ativo": true,
	"senha":"12345678"
}
```



* A senha deve ter no mínimo 6 dígitos

  

##### Login

Para efetuar login na aplicação, deve enviar uma requisição conforme o exemplo a seguir:

```
[HTTP.POST] {base-url}/usuario
```

```
{
	"nome":"exemplo@gmail.com",
	"senha":"12345678"
}
```

O token estará no cabeçalho de retorno da solicitação no atributo "Autorization"

![image-20200412171254362](media/image-20200412171254362.png)

Uma vez com o token de autorização for obtido, o mesmo deverá ser enviado em todas as requisições que serão apresentadas a seguir, conforme a imagem abaixo:

![image-20200412171655894](media/image-20200412171655894.png)

### Marcas

Endpoints para administração de marcas.

##### Criar

Endpoint para criação de um novo registro de marca:

```
[HTTP.POST] {base-url}/marca
```

Corpo da Requisição:

```
{
	"nome":"Chamex"
}
```

##### Editar

Endpoint para edição de um registro de marca:

```
[HTTP.PUT] {base-url}/marca/{marca.id}
```

Corpo da Requisição:

```
{
	"nome":"Chamex - novo nome"
}
```

##### Excluir

Endpoint para edição de um registro de marca:

```
[HTTP.DELETE] {base-url}/marca/{marca.id}
```

##### Listar todas as Marcas

Endpoint para consulta do registro de todas as marcas:

```
[HTTP.GET] {base-url}/marca
```



### Patrimonios

Endpoints para administração de itens de patrimônio.

##### Criar

Endpoint para criação de um novo registro de patrimônio:

```
[HTTP.POST] {base-url}/patrimonio
```

Corpo da Requisição:

```
{
	"marca": 1,
	"nome":"Caneta",
	"descricao":"Caneta Azul"
}
```

##### Editar

Endpoint para edição de um registro de patrimônio:

```
[HTTP.PUT] {base-url}/patrimonio/{patrimonio.id}
```

Corpo da Requisição:

```
{
	"marca": 1,
	"nome":"Caneta",
	"descricao":"Caneta Azul"
}
```

##### Excluir

Endpoint para edição de um registro de patrimônio:

```
[HTTP.DELETE] {base-url}/patrimonio/{patrimonio.id}
```

##### Listar todos os patrimonios

Endpoint para consulta do registro de todos os patrimônios:

```
[HTTP.GET] {base-url}/patrimonio
```

##### Busca de patrimônios por marca

Endpoint para consulta do registro de todos os patrimônios baseado em suas marcas:

```
[HTTP.GET] {base-url}/patrimonio/{patrimonio.id}
```

