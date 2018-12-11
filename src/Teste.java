
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author maury
 */
public class Teste extends JFrame {

    private final JButton buttonLogin;
    private final JButton buttonCadastro;
    private final JButton buttonSaque;
    private final JButton buttonDeposito;
    private final JButton buttonExtrato;

    public Teste() {
        super("Caixa eletronico");
        setLayout(new FlowLayout());

        buttonLogin = new JButton("Login");
        add(buttonLogin);

        buttonCadastro = new JButton("Cadastro");
        add(buttonCadastro);

        buttonSaque = new JButton("Saque");
        add(buttonSaque);

        buttonDeposito = new JButton("Deposito");
        add(buttonDeposito);

        buttonExtrato = new JButton("Extrato");
        add(buttonExtrato);

        // create new ButtonHandler for button event handling 
        ButtonHandler handler = new ButtonHandler();
        buttonLogin.addActionListener(handler);
        buttonCadastro.addActionListener(handler);
        buttonSaque.addActionListener(handler);
        buttonDeposito.addActionListener(handler);
        buttonExtrato.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        // handle button event

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "Login":
                    System.out.println("Login");
                    break;
                case "Cadastro":
                    System.out.println("Cadastro");
                    break;
                case "Saque":
                    System.out.println("Saque");

                    String valorSaque = JOptionPane.showInputDialog(
                            "Informe valor do Saque");
                    
                    double valor = Double.parseDouble(valorSaque);

                    break;
                case "Deposito":
                    System.out.println("Deposito");
                    break;
                case "Extrato":
                    System.out.println("Extrato");

                    break;
                default:
                    break;
            }

        }
    }

    public static void main(String[] args) {
        Teste buttonFrame = new Teste(); // create ButtonFrame
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setResizable(false);
        buttonFrame.setSize(430, 350); // set frame size
        buttonFrame.setVisible(true); // display frame

    }

}
