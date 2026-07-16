package Aplicacao.ProgQuiz;

import Framework.Item;
import Framework.Question;
import Framework.QuestionsGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingQuestions implements QuestionsGenerator {
    List<Question> questions = new ArrayList<>();
    @Override
    public List<Question> generateQuestions() {
    Question q1 = new Question("Qual padrão de projeto é usado para garantir que uma classe tenha apenas uma instância em todo o ciclo de vida da aplicação e forneça um ponto de acesso global a ela?", new ArrayList<>(Arrays.asList(
        new Item("Factory", false),
        new Item("Strategy", false),
        new Item("Singleton", true),
        new Item("Observer", false)
    )));
    questions.add(q1);

        Question q2 = new Question("Qual padrão de projeto é usado para permitir que um objeto notifique outros objetos sobre mudanças em seu estado, sem que eles precisem ficar consultando-o constantemente?", new ArrayList<>(Arrays.asList(
        new Item("Strategy", false),
        new Item("Observer", true),
        new Item("Singleton", false),
        new Item("Wrapper", false)
    )));
        questions.add(q2);

        Question q3 = new Question("Qual padrão de projeto é usado para fornecer uma interface unificada e simplificada para um conjunto complexo de interfaces em um subsistema?", new ArrayList<>(Arrays.asList(
        new Item("Wrapper", false),
        new Item("Proxy", false),
        new Item("Facade", true),
        new Item("Singleton", false)
    )));
        questions.add(q3);

        Question q4 = new Question("Qual padrão de projeto é usado para definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis em tempo de execução?", new ArrayList<>(Arrays.asList(
        new Item("Decorator", false),
        new Item("Strategy", true),
        new Item("Proxy", false),
        new Item("Template", false)
        )));
        questions.add(q4);

        Question q5 = new Question("Qual padrão de projeto é usado para converter a interface de uma classe existente em outra interface que o cliente espera, permitindo que classes incompatíveis trabalhem juntas?", new ArrayList<>(Arrays.asList(
        new Item("Factory", false),
        new Item("Wrapper", true),
        new Item("Decorator", false),
        new Item("Singleton", false)
        )));
        questions.add(q5);

        Question q6 = new Question("Você está desenvolvendo um sistema de e-commerce. Quando um produto tem seu preço reduzido, o sistema precisa avisar automaticamente o setor de marketing, o aplicativo do usuário e a equipe de análise de dados. Você quer fazer isso sem que a classe Produto precise conhecer os detalhes de como cada um desses setores processa a informação.?", new ArrayList<>(Arrays.asList(
                new Item(" Strategy.", false),
                new Item("Observer", true),
                new Item("Factory", false),
                new Item("Singleton", false)
        )));
        questions.add(q6);

        Question q7 = new Question("Em um sistema de entregas, o cálculo do valor do frete muda completamente dependendo do tipo de serviço escolhido pelo usuário: Sedex, PAC, Retirada no Local ou Entrega Expressa. Em vez de criar um método gigante cheio de switch/case dentro da classe Pedido, você decide isolar cada algoritmo de cálculo em sua própria classe dedicada, permitindo que o pedido mude de comportamento dinamicamente em tempo de execução.Qual padrão de projeto foi aplicado?", new ArrayList<>(Arrays.asList(
                new Item("Factory", false),
                new Item("Wrapper", false),
                new Item("Strategy", true),
                new Item("Singleton", false)
        )));
        questions.add(q7);

        Question q8 = new Question("Sua aplicação interage com um subsistema complexo composto por mais de 10 bibliotecas diferentes. Você deseja criar uma interface única e simplificada para facilitar o uso desse subsistema pelos desenvolvedores.", new ArrayList<>(Arrays.asList(
                new Item("Observer", false),
                new Item("Proxy", false),
                new Item("Decorator", false),
                new Item("Facade", true)
        )));
        questions.add(q8);

        Question q9 = new Question("Seu sistema precisa gerar faturas de diferentes tipos (FaturaSimples, FaturaEletronica, FaturaInternacional). Em vez de o cliente instanciar as classes diretamente com new, você delega essa responsabilidade de criação para uma interface ou método, centralizando as decisões de instanciação.", new ArrayList<>(Arrays.asList(
                new Item("Factory", true),
                new Item("Wrapper", false),
                new Item("Decorator", false),
                new Item("Singleton", false)
        )));
        questions.add(q9);

        Question q10 = new Question("Você tem uma classe ReprodutorAudio que toca arquivos MP3. O cliente quer que o sistema passe a aceitar arquivos VLC e MP4, que usam métodos e interfaces completamente incompatíveis com o reprodutor atual. Você cria uma classe intermediária que converte a interface do formato novo para o formato que o reprodutor já entende.", new ArrayList<>(Arrays.asList(
                new Item("Facade", false),
                new Item("Proxy", false),
                new Item("Decorator", false),
                new Item("Adapter", true)
        )));
        questions.add(q10);

        Question q11 = new Question("Um objeto PlacarEsportivo gerencia os pontos de um jogo. Diversos painéis digitais espalhados pelo estádio precisam se atualizar em tempo real toda vez que o placar mudar, sem que o objeto do placar fique acoplado à tecnologia de cada painel.", new ArrayList<>(Arrays.asList(
                new Item("Strategy", false),
                new Item("Observer", true),
                new Item("Facade", false),
                new Item("Template", false)
        )));
        questions.add(q11);

        Question q12 = new Question("Você tem uma aplicação de criptografia. Dependendo da preferência do usuário ou do nível de segurança exigido, o algoritmo de criptografia precisa mudar em tempo de execução (ex: alternar entre AES, DES ou Blowfish). Você isola cada algoritmo em sua própria classe sob uma interface comum.", new ArrayList<>(Arrays.asList(
                new Item("Template", false),
                new Item("Decorator", true),
                new Item("Strategy", false),
                new Item("Proxy", false)
        )));
        questions.add(q12);

        Question q13 = new Question("Para iniciar a sua aplicação de jogos, o sistema precisa inicializar a engine de física, carregar texturas da memória, abrir portas de rede, configurar o áudio e ler arquivos de save. Para que a classe principal não gerencie toda essa complexidade, você cria uma classe simplificada chamada InicializadorJogo com o método iniciar().", new ArrayList<>(Arrays.asList(
                new Item("Proxy", false),
                new Item("Wrapper", false),
                new Item("Facade", true),
                new Item("Singleton", false)
        )));
        questions.add(q13);

        Question q14 = new Question("O seu sistema possui um objeto Texto. Você precisa dar ao usuário a opção de aplicar várias melhorias visuais cumulativas no texto em tempo de execução, como: adicionar borda, adicionar sombra, tornar negrito ou colocar fundo colorido. O usuário pode combinar quantas melhorias quiser e na ordem que desejar.", new ArrayList<>(Arrays.asList(
                new Item("Factory", false),
                new Item("Wrapper", false),
                new Item("Decorator", true),
                new Item("Singleton", false)
        )));
        questions.add(q14);

        Question q15 = new Question("Em um aplicativo de mapas, a rota pode ser calculada de formas diferentes dependendo do meio de transporte escolhido: A pé, De Carro ou Transporte Público. Você quer isolar a lógica de cálculo de cada rota em classes separadas e permitir que o aplicativo alterne entre elas instantaneamente quando o usuário clica no ícone do transporte.", new ArrayList<>(Arrays.asList(
                new Item("Template", false),
                new Item("Wrapper", false),
                new Item("Decorator", false),
                new Item("Stategy", true)
        )));
        questions.add(q15);

        return questions;
    }

    public void printAllQuestions() {
        int numQuestion = 1;
        for (Question q : questions) {
            System.out.println(numQuestion + ") " + q.getStatement());

            char letterItem = 'a';
            for(Item item : q.getItems()) {
                System.out.println(letterItem + ") " + item.getText());
                letterItem++;
            }

            numQuestion++;
        }
    }
}
