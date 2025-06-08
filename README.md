# PUC - SISTEMAS DISTRIBUIDOS
## Projeto Cliente REST 
Aplicação Java Desktop (via Maven) que consome a API REST pública GeoDB Cities através do serviço RapidAPI. A aplicação realiza buscas de cidades por nome e imprime os resultados de forma formatada no terminal.


## Tecnologias Utilizadas
- Java 21.0.7
- Maven
- Biblioteca JSON (`org.json`)
- RapidAPI (GeoDB Cities)
- NetBeans (ou outro IDE compatível com Maven)


## Como Executar no NetBeans
### Pré-requisitos

- NetBeans instalado (versão com suporte a Maven)
- Java JDK 21.0.7 ou superior

### Passos
1. Abra o **NetBeans**.
2. Vá em **File > Open Project** e selecione a pasta do projeto que contém o arquivo `pom.xml`.
3. No painel de projetos, clique com o botão direito no projeto `GeoDBClientApp` e selecione **Run** ou **Clean and Build**.

### Adicionar a Chave da API
Abra o arquivo:

```
src/main/java/com/pucpcaldas/geodbclientapp/GeoDBClient.java
```

E substitua o valor da constante `API_KEY`:

```java
private static final String API_KEY = "SUA_CHAVE_RAPIDAPI";
```

## Autenticação
A API requer uma chave da RapidAPI:

- Acesse: https://rapidapi.com/wirefreethought/api/geodb-cities
- Copie sua chave de API (`X-RapidAPI-Key`)
- Insira no código conforme descrito acima.

## Informações da API REST
- Base URL: `https://wft-geo-db.p.rapidapi.com/v1/geo/cities`
- Exemplo de chamada:

```
GET /v1/geo/cities?namePrefix=New York&limit=5
```

- Cabeçalhos obrigatórios:
  - `X-RapidAPI-Key: SUA_CHAVE`
  - `X-RapidAPI-Host: wft-geo-db.p.rapidapi.com`


## Exemplo de Saída
```plaintext
--------------------------------------------
-- --------------- OUTPUT --------------- --
--------------------------------------------
🖈 Cidade: São José do Vale do Rio Preto
🌍 País: Brazil (BR)
🏞 Região: Rio de Janeiro (RJ)
✶ Coordenadas: -22.150833333, -42.923888888
🕇 População: 2208
--------------------------------------------
```

## Estrutura do Projeto
```
GeoDBClientApp/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── pucpcaldas/
                    └── geodbclientapp/
                        ├── Main.java
                        └── GeoDBClient.java
```

## Observações
- O retorno da API pode conter múltiplas cidades com o mesmo nome, inclusive de países diferentes.
