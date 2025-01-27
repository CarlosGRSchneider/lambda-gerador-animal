# lambda-gerador-animal

Esta função Lambda faz parte de um **circuit breaker serverless** implementado na AWS. Ela é responsável por gerar combinações de animais e adjetivos de maneira aleatória. Em caso de falhas ou erros excessivos, o circuito redireciona as requisições para uma função fallback. O fallback desta função está disponível no repositório: [lambda-fallback-gerador-animal](https://github.com/CarlosGRSchneider/lambda-fallback-gerador-animal).

## Descrição

A função gera uma combinação aleatória de:
- **Animal**: exemplos incluem "Elefante", "Tigre", "Golfinho".
- **Adjetivo**: exemplos incluem "rápido", "brincalhão", "elegante".

Ela também pode simular falhas controladas, com base na variável de ambiente `TAXA_DE_ERRO`.

## Configuração

- **Variáveis de ambiente**:
  - `TAXA_DE_ERRO`: (opcional) Define a probabilidade de falhas simuladas. Valor padrão: `0.0` (sem falhas).

## Endpoint

A função é acessada via API Gateway como um **endpoint GET**. Não há payload necessário para teste ou execução.

## Exemplo de Retorno

Em uma execução bem-sucedida, a função retorna uma string no formato:

```
"Tigre brincalhão"
```

Se a `TAXA_DE_ERRO` permitir uma falha, a função poderá lançar um erro simulado:

```
RuntimeException: "Erro simulado."
```

## Estrutura do Projeto

### Classes Principais

1. **`GeradorAnimal`**
   - Contém as listas de animais e adjetivos.
   - Gera combinações aleatórias.

2. **`GeradorAnimalLambda`**
   - Classe principal da função Lambda.
   - Configura a taxa de erro com base na variável de ambiente.
   - Implementa a lógica de geração de combinações e simulação de falhas.

## Relação com o Fallback

O fallback desta função executa uma versão simplificada, retornando combinações pré-determinadas de animais e adjetivos. Consulte o repositório do fallback para mais informações: [lambda-fallback-gerador-animal](https://github.com/CarlosGRSchneider/lambda-fallback-gerador-animal).
