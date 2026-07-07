package Aplicacao;

import Framework.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UI_App extends JFrame {
    GraphicInterface gi = new GraphicInterface();
    Quiz quiz = new Quiz();
    Score s =  new Score();
    List<Question> questions = quiz.get_questions_list();

    private int currentQuestionIndex = 0;
    private char correctLetter = ' ';

    private JLabel lblPergunta;
    private JPanel items_panel;
    private ButtonGroup items_group;
    private JButton btnResponder;

    public UI_App() {
        setTitle("Quiz de Conhecimentos Gerais");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centralizar janela
        setLayout(new BorderLayout(10, 10));

        Question qt = questions.get(currentQuestionIndex);

        lblPergunta = new JLabel(gi.getTextQuestion(qt), SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 16));

        items_panel = new JPanel();
        items_panel.setLayout(new GridLayout(4, 1, 1, 1)); // 4 linhas e 1 coluna

        items_group = new ButtonGroup();
        btnResponder = new JButton("Confirmar Resposta");

        add(lblPergunta, BorderLayout.NORTH);
        add(items_panel, BorderLayout.CENTER);
        add(btnResponder, BorderLayout.SOUTH);

        btnResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (items_group.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma alternativa.");
                    return;
                }

                // descobre qual JRadioButton foi clicado para pegar a letra do usuario;
                char letraUsuario = ' ';
                for (java.util.Enumeration<AbstractButton> buttons = items_group.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        letraUsuario = button.getText().charAt(0);
                        break;
                    }
                }

                boolean isCorrect = s.calculateScore(letraUsuario, correctLetter);

                if (isCorrect) {
                    JOptionPane.showMessageDialog(null, "Acertou!");
                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta! A alternativa certa era: " + correctLetter);
                }

                currentQuestionIndex++;
                loadQuestion(currentQuestionIndex);
            }
        });

        // carrega a primeira pergunta assim que a janela abre
        loadQuestion(currentQuestionIndex);
        setVisible(true);
    }

    // metodo pra atualizar a tela;
    private void loadQuestion(int index) {
        // se o indice chegou ao fim da lista, o quiz acabou;
        if (index >= questions.size()) {
            List<String> resultados = s.returnResults();
            StringBuilder mensagemFinal = new StringBuilder("Fim do Quiz! Obrigado por jogar.\n\n");
            for (String linha : resultados) {
                mensagemFinal.append(linha).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagemFinal.toString(), "Resultados do Quiz", JOptionPane.INFORMATION_MESSAGE);

            btnResponder.setEnabled(false); // desativa o botao;
            return;
        }
        // limpa o painel de alternativas anterior e o grupo de botoes;
        items_panel.removeAll();
        items_group = new ButtonGroup();
        // pega a pergunta atual da lista;
        Question qt = questions.get(index);
        // atualiza o texto do topo;
        lblPergunta.setText((index + 1) + ") " + gi.getTextQuestion(qt));
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
    }
}
