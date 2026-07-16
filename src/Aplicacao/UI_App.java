package Aplicacao;

import Aplicacao.WCQuiz.WorldCupQuiz;
import Framework.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UI_App extends JFrame {
    GraphicInterface gi = new GraphicInterface();
    QuizTemplate quiz;
    ScoreStrategy score;
    List<Question> questions;

    private int currentQuestionIndex = 0;
    private char correctLetter = ' ';

    private int timeLeft = 0;
    private Timer gameTimer;
    private JLabel lblTimer; // visual timer;

    private JLabel lblPergunta;
    private JPanel items_panel;
    private ButtonGroup items_group;
    private JButton btnResponder;

    public UI_App(List<Question> questions, ScoreStrategy scoreStrategy) {
        this.quiz = new WorldCupQuiz(questions);
        this.questions = quiz.get_questions_list();
        this.score = scoreStrategy;
        setTitle("Quiz sobre Copa do Mundo");
        setSize(520, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centralizar janela

        setLayout(new BorderLayout(15, 15));

        lblTimer = new JLabel("Tempo: 30s ", SwingConstants.RIGHT);
        lblTimer.setFont(new Font("Arial", Font.BOLD, 14));
        lblTimer.setForeground(Color.RED);
        lblTimer.setBorder(BorderFactory.createEmptyBorder(10,10,0,15));
        add(lblTimer, BorderLayout.NORTH);

        JPanel center_panel = new JPanel(new BorderLayout(10,15));
        center_panel.setBorder(BorderFactory.createEmptyBorder(0,20,10,20));

        Question qt = questions.get(currentQuestionIndex);
        lblPergunta = new JLabel(gi.getTextQuestion(qt), SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 16));
        atualizarTextoPergunta(gi.getTextQuestion(qt)); // quebra de linha para pergunta grande;

        items_panel = new JPanel();
        items_panel.setLayout(new GridLayout(4, 1, 8, 8));

        center_panel.add(lblPergunta, BorderLayout.NORTH);
        center_panel.add(items_panel, BorderLayout.CENTER);

        add(center_panel, BorderLayout.CENTER);

        items_group = new ButtonGroup();
        btnResponder = new JButton("Confirmar Resposta");

        JPanel bottomPanel = addBottomPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));
        add(bottomPanel, BorderLayout.SOUTH);

        initTimer();

        btnResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarResposta();
            }
        });
        // carrega a primeira pergunta assim que a janela abre
        loadQuestion(currentQuestionIndex);
        setVisible(true);
    }

    private JPanel addBottomPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(btnResponder, BorderLayout.CENTER);
        return p;
    }

    private void initTimer() {
        // timer do swing executa a action a cada n milissegundos (1000ms = 1s)
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                lblTimer.setText("Tempo: " + timeLeft + "s ");
                if (timeLeft <= 0) {
                    gameTimer.stop();
                    JOptionPane.showMessageDialog(null, "O tempo acabou para esta pergunta!");
                    // se o tempo acabar conta como erro;
                    score.calculateScore(' ', correctLetter, 0);

                    currentQuestionIndex++;
                    loadQuestion(currentQuestionIndex);
                }
            }
        });
    }

    private void resetTimer() {
        if (gameTimer != null) {
            gameTimer.stop(); // para o timer anterior;
        }
        timeLeft = 30; // reseta;
        lblTimer.setText("Tempo: " + timeLeft + "s ");
        gameTimer.start();
    }

    private void processarResposta() {
        if (items_group.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma alternativa.");
            return;
        }
        // Para o tempo enquanto o jogador decide/confirma
        gameTimer.stop();
        char letraUsuario = ' ';
        for (java.util.Enumeration<AbstractButton> buttons = items_group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                letraUsuario = button.getText().charAt(0);
                break;
            }
        }
        // passa a resposta do usuario, a correta e o tempo restante para a estratégia
        boolean isCorrect = score.calculateScore(letraUsuario, correctLetter, timeLeft);
        if (isCorrect) {
            JOptionPane.showMessageDialog(null, "Acertou! Restavam " + timeLeft + " segundos.");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta incorreta! A alternativa certa era: " + correctLetter);
        }
        currentQuestionIndex++;
        loadQuestion(currentQuestionIndex);
    }

    // metodo pra atualizar a tela;
    private void loadQuestion(int index) {
        // se o indice chegou ao fim da lista, o quiz acabou;
        if (index >= questions.size()) {
            if (gameTimer != null) gameTimer.stop();

            List<String> resultados = score.returnResults();
            StringBuilder mensagemFinal = new StringBuilder("Fim do Quiz! Obrigado por jogar.\n\n");
            for (String linha : resultados) {
                mensagemFinal.append(linha).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagemFinal.toString(), "Resultados: ", JOptionPane.INFORMATION_MESSAGE);

            btnResponder.setEnabled(false); // desativa o botao;
            return;
        }
        // limpa o painel de alternativas anterior e o grupo de botoes;
        items_panel.removeAll();
        items_group = new ButtonGroup();
        // pega a pergunta atual da lista;
        Question qt = questions.get(index);
        // atualiza o texto do topo;
        atualizarTextoPergunta((index + 1) + ") " + gi.getTextQuestion(qt));
        // cria os novos RadioButtons para a pergunta atual;
        char letter = 'a';
        correctLetter = ' ';
        for (Item i : qt.getItems()) {
            JRadioButton opt = new JRadioButton(letter + ") " + i.getText());
            if (i.getCorrect()) {
                correctLetter = letter; // guarda qual a letra certa globalmente;
            }
            items_group.add(opt);
            items_panel.add(opt);
            letter++;
        }
        // força o Swing a redesenhar a tela com os novos botoes;
        items_panel.revalidate();
        items_panel.repaint();

        resetTimer();
    }

    private void atualizarTextoPergunta(String texto) {
        lblPergunta.setText("<html><body style='text-align: center; width: 350px;'>" + texto + "</body></html>");
    }
}
