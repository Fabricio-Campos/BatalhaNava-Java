import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {

    public static void main(String[] args) throws Exception {
        // Look-and-feel padrão do Java: respeita as cores dos botões em qualquer sistema
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtilities.invokeLater(App::iniciar);
    }

    /** Pergunta a dificuldade e abre o jogo. */
    public static void iniciar() {
        String[] opcoes = {"Fácil (6x6)", "Intermediário (7x7)", "Difícil (8x8)"};

        int escolha = JOptionPane.showOptionDialog(null,
                "Escolha a dificuldade:",
                "Batalha Naval",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                new Jogo(Tabuleiro.facil(), "Fácil");
                break;
            case 1:
                new Jogo(Tabuleiro.intermediario(), "Intermediário");
                break;
            case 2:
                new Jogo(Tabuleiro.dificil(), "Difícil");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
        }
    }
}