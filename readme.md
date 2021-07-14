# Projeto Microservices Spring boot

Este projeto é um teste feito em Live Code para seleção na empresa Zup Innovation

## Endpoint principal

Está sendo feita uma consulta à API VIACEP com implementação de testes e documentação via swagger.

```sh
http://localhost:8080/cep/busca/01001000
```

Retorno:
```sh
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```
