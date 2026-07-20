# Quiz Framework — PPP

Framework em Java para criação de quizzes de múltipla escolha, desenvolvido como trabalho da disciplina de Padrões de Projeto (PPP). A ideia central é oferecer uma estrutura genérica e reutilizável para questionários, na qual novos temas de quiz e novas formas de pontuação podem ser adicionados sem alterar o núcleo do framework — apenas implementando interfaces e classes abstratas já definidas.

Para isso, o projeto combina três padrões de projeto clássicos (GoF):

- **Factory Method** — para a criação dos quizzes
- **Template Method** — para o fluxo de execução de um quiz
- **Strategy** — para as diferentes formas de calcular a pontuação

## Sumário

- [Visão geral da arquitetura](#visão-geral-da-arquitetura)
- [Padrões de projeto utilizados](#padrões-de-projeto-utilizados)
  - [Factory Method](#1-factory-method)
  - [Template Method](#2-template-method)
  - [Strategy](#3-strategy)
- [Estrutura de pacotes](#estrutura-de-pacotes)
- [Modelo de dados das perguntas](#modelo-de-dados-das-perguntas)
- [Fluxo de execução](#fluxo-de-execução)
- [Interfaces gráfica e textual](#interfaces-gráfica-e-textual)
- [Como executar](#como-executar)
- [Como adicionar um novo quiz](#como-adicionar-um-novo-quiz)
- [Como adicionar uma nova estratégia de pontuação](#como-adicionar-uma-nova-estratégia-de-pontuação)

## Visão geral da arquitetura

O projeto é dividido em duas camadas:

- **`Framework`** — contém as classes e interfaces genéricas do quiz (o "motor" reutilizável): `Question`, `Item`, `QuestionsGenerator`, `QuizFactory`, `QuizTemplate`, `ScoreStrategy` e `GraphicInterface`. Nada nessa camada sabe qual é o tema do quiz.
- **`Aplicacao`** — contém as implementações concretas que usam o framework para montar quizzes específicos. Hoje existem dois exemplos: um quiz de **Padrões de Projeto** (`ProgQuiz`) e um quiz de **Copa do Mundo** (`WCQuiz`), além das estratégias de pontuação (`Score`).

Essa separação é o que permite ao framework crescer: qualquer novo quiz é criado implementando as interfaces do `Framework`, sem precisar tocar nas classes já existentes.

## Padrões de projeto utilizados

### 1. Factory Method

**Problema que resolve:** o código cliente (`Main`) não deve precisar saber como instanciar um `QuizTemplate` concreto nem como montar sua lista de perguntas.

**Como é aplicado:**
- `QuizFactory` (interface) declara o método `criarQuiz()`, que retorna um `QuizTemplate`.
- `QuizFactoryCod` e `QuizFactoryWC` são as fábricas concretas, cada uma responsável por instanciar seu respectivo quiz (`CodingQuiz` ou `WorldCupQuiz`) já populado com as perguntas geradas por um `QuestionsGenerator` (`CodingQuestions` ou `WorldCupQuestions`).

```java
QuizFactory factory = new QuizFactoryCod();
QuizTemplate quiz = factory.criarQuiz(); // não sabemos (nem precisamos saber) que é um CodingQuiz
```

Isso permite trocar o tema do quiz executado apenas trocando a fábrica usada em `Main`.

### 2. Template Method

**Problema que resolve:** todo quiz segue a mesma sequência de passos (mostrar menu → jogar → mostrar pontuação → encerrar), mas o **conteúdo** de cada passo muda de quiz para quiz.

**Como é aplicado:**
- `QuizTemplate` é uma classe abstrata que define o método `quiz()`, o "esqueleto" do algoritmo:

```java
public void quiz(){
    menu();
    gameplay();
    ending_score();
    end_program();
}
```

- Os passos `menu()`, `gameplay()`, `ending_score()`, `setScoreStrategy()` e `get_questions_list()` são abstratos e implementados por cada subclasse concreta (`CodingQuiz`, `WorldCupQuiz`), que decide como exibir o menu, como conduzir a rodada de perguntas e como mostrar o resultado.
- `end_program()` já vem implementado no template, pois é comum a todos os quizzes.

Assim, o cliente sempre chama `quiz.quiz()` e o algoritmo é executado na ordem correta, independentemente do tema.

### 3. Strategy

**Problema que resolve:** a forma de calcular a pontuação pode variar (pontuação simples de acerto/erro, pontuação com bônus/penalidade por tempo, etc.), e essa lógica deve poder ser trocada em tempo de execução sem alterar a classe do quiz.

**Como é aplicado:**
- `ScoreStrategy` (interface) declara `calculateScore(...)`, `showScore()` e `returnResults()`.
- Implementações concretas:
  - `SimpleScore` — soma acertos e erros de forma simples (acerto/total).
  - `Score` — soma e subtrai pontos fixos por acerto/erro.
  - `TimeBasedScore` — calcula pontuação considerando o tempo restante para responder, dando bônus por respostas rápidas e penalidade proporcional ao tempo perdido.
- Cada `QuizTemplate` mantém uma referência a um `ScoreStrategy` e expõe `setScoreStrategy(...)`, permitindo injetar a estratégia desejada antes de iniciar o quiz:

```java
QuizTemplate quiz = factory.criarQuiz();
quiz.setScoreStrategy(new TimeBasedScore()); // troca a estratégia de pontuação
quiz.quiz();
```

## Estrutura de pacotes

```
Framework/
├── Item.java                 # Alternativa de uma pergunta (texto + se é correta)
├── Question.java             # Pergunta (enunciado + lista de Item)
├── QuestionsGenerator.java   # Interface: gera a lista de perguntas de um quiz
├── QuizFactory.java          # Interface: Factory Method (cria QuizTemplate)
├── QuizTemplate.java         # Classe abstrata: Template Method (fluxo do quiz)
├── ScoreStrategy.java        # Interface: Strategy (cálculo de pontuação)
└── GraphicInterface.java     # Utilitário para extrair texto de perguntas/itens

Aplicacao/
├── ProgQuiz/
│   ├── CodingQuestions.java  # QuestionsGenerator: perguntas sobre padrões de projeto
│   ├── CodingQuiz.java       # QuizTemplate concreto (versão texto/console)
│   ├── QuizFactoryCod.java   # Factory concreta do quiz de programação
│   ├── UI_App.java           # Interface gráfica (Swing) do quiz
│   └── Main.java             # Ponto de entrada do quiz de programação
│
├── WCQuiz/
│   ├── WorldCupQuestions.java# QuestionsGenerator: perguntas sobre Copa do Mundo
│   ├── WorldCupQuiz.java     # QuizTemplate concreto (versão texto/console)
│   ├── QuizFactoryWC.java    # Factory concreta do quiz de Copa do Mundo
│   └── Main.java             # Ponto de entrada do quiz de Copa do Mundo
│
└── Score/
    ├── SimpleScore.java      # Strategy: acerto/total
    ├── Score.java            # Strategy: pontos fixos por acerto/erro
    └── TimeBasedScore.java   # Strategy: pontuação baseada em tempo de resposta
```

## Modelo de dados das perguntas

- **`Item`** representa uma alternativa: um texto (`text`) e um booleano indicando se é a resposta correta (`correct`).
- **`Question`** representa uma pergunta: um enunciado (`question`) e uma lista de `Item`.
- **`QuestionsGenerator`** é a interface que qualquer novo tema de quiz deve implementar para produzir sua `List<Question>` (ex.: `CodingQuestions`, `WorldCupQuestions`).

## Fluxo de execução

1. `Main` instancia a fábrica concreta desejada (ex.: `QuizFactoryCod`).
2. A fábrica cria o `QuestionsGenerator` correspondente, gera as perguntas e instancia o `QuizTemplate` concreto (ex.: `CodingQuiz`) já com essas perguntas.
3. `Main` define a estratégia de pontuação com `setScoreStrategy(...)`.
4. `Main` chama `quiz.quiz()`, que executa o Template Method:
   - `menu()` exibe a introdução do quiz;
   - `gameplay()` percorre as perguntas, captura a resposta do usuário e delega o cálculo do resultado de cada rodada para o `ScoreStrategy`;
   - `ending_score()` exibe o resultado final, obtido via `ScoreStrategy`;
   - `end_program()` encerra a aplicação.

## Interfaces gráfica e textual

O framework foi pensado para suportar tanto uma versão **texto/console** (usando `Scanner`, como em `CodingQuiz.gameplay()` e `WorldCupQuiz.gameplay()`) quanto uma versão **gráfica** (`UI_App`, feita com Swing), que exibe as perguntas, alternativas e um cronômetro visual, integrando-se ao mesmo modelo (`Question`, `Item`, `ScoreStrategy`) e à classe utilitária `GraphicInterface`, responsável por extrair o texto do enunciado e das alternativas para exibição.

## Como executar

O projeto não usa build tool (Maven/Gradle); a compilação é feita diretamente com `javac`/`java`, respeitando a estrutura de pacotes.

```bash
# a partir da raiz do código-fonte (onde estão as pastas Framework/ e Aplicacao/)
javac -d out $(find . -name "*.java")

# quiz de padrões de projeto (versão console)
java -cp out Aplicacao.ProgQuiz.Main

# quiz de Copa do Mundo (versão console)
java -cp out Aplicacao.WCQuiz.Main
```

## Como adicionar um novo quiz

Graças ao Factory Method e ao Template Method, adicionar um novo tema de quiz não exige alterar nenhuma classe existente:

1. Crie uma classe que implemente `QuestionsGenerator`, retornando a `List<Question>` do novo tema.
2. Crie uma classe que **estenda `QuizTemplate`**, implementando `menu()`, `gameplay()`, `ending_score()`, `setScoreStrategy()` e `get_questions_list()`.
3. Crie uma classe que implemente `QuizFactory`, cujo `criarQuiz()` instancia o novo `QuestionsGenerator` e o novo `QuizTemplate`.
4. No `Main`, use a nova fábrica em vez de `QuizFactoryCod`/`QuizFactoryWC`.

## Como adicionar uma nova estratégia de pontuação

Graças ao Strategy, basta:

1. Criar uma classe que implemente `ScoreStrategy`, definindo sua própria lógica em `calculateScore(...)`, `showScore()` e `returnResults()`.
2. Passá-la para o quiz desejado via `quiz.setScoreStrategy(new MinhaEstrategia())`, antes de chamar `quiz.quiz()`.

Nenhuma classe de quiz precisa ser alterada para suportar a nova forma de pontuação.
