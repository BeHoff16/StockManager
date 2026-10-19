# StockManager67

Sistema de gerenciamento de estoque desenvolvido em Java utilizando Swing e NetBeans.

## Funcionalidades

- Login de usuários
- Cadastro de produtos
- Edição de produtos
- Listagem de produtos
- Cadastro de usuários
- Controle de acesso:
  - Administrador: acesso ao gerenciamento de usuários.
  - Estoquista: acesso apenas ao estoque.

## Tecnologias

- Java
- Java Swing
- NetBeans
- MVC (Model - View - Controller)

## Estrutura do Projeto

```
src/
├── control
├── model
└── view
```

### Model
Responsável pelas classes de dados.

- Produto
- Usuario

### View
Responsável pelas telas do sistema.

- TelaInicial
- TelaLogin
- StockView
- UserData

### Control
Responsável pela lógica do sistema.

- ControladorTela
- ControladorLogin
- ControladorStock
- ControladorUsuario

## Usuário padrão

Administrador:

```
Usuário: admin
Senha: 123
```

Usuário de classe Estoquista:

```
Usuário: joao
Senha: 123
```

## Como executar

1. Execute o "StockManager67.jar" na pasta inicial ou dist.

## Arquivo de dados

Cada lista é salva no seu próprio arquivo, criado na pasta de onde o programa é executado (a raiz do projeto quando executado pelo NetBeans):

- "usuarios.dat": usuários
- "produtos.dat": produtos
- "logs.dat": histórico de alterações
- "vendas.dat": vendas por produto (usado no relatório da Gerência)

Apagar "usuarios.dat" reinicia os usuários com os dados iniciais (admin e joao).

Se algum desses arquivos ainda não existir e houver um "stockmanager67.dat" (formato antigo, com tudo num arquivo só), os dados são lidos dele. O arquivo antigo nunca é alterado.

## Autor

Bernardo N. Hoffmann