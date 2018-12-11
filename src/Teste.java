
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

    private Conta conta;

    public Teste() {
        super("Caixa eletronico");
        setLayout(new FlowLayout());

        buttonLogin = new JButton("Login");
        add(buttonLogin);

        buttonCadastro = new JButton("Cadastro");
        add(buttonCadastro);

        buttonSaque = new JButton("Saque");
        add(buttonSaque);
        buttonSaque.setEnabled(false);

        buttonDeposito = new JButton("Deposito");
        add(buttonDeposito);
        buttonDeposito.setEnabled(false);

        buttonExtrato = new JButton("Extrato");
        add(buttonExtrato);
        buttonExtrato.setEnabled(false);

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
            Transacao t = new Transacao();
            switch (event.getActionCommand()) {

                case "Login":
                    System.out.println("Login");
                    String valLogin = JOptionPane.showInputDialog(
                            "Informe numero da conta");

                    String valSenha = JOptionPane.showInputDialog(
                            "Informe sua senha");
                    conta = t.login(Integer.parseInt(valLogin), valSenha);
                    if(conta.getNumConta() != 0){
                        JOptionPane.showMessageDialog(null, "Bem vindo!");
                        buttonLogin.setEnabled(false);
                        buttonCadastro.setEnabled(false);
                        buttonExtrato.setEnabled(true);
                        buttonDeposito.setEnabled(true);
                        buttonSaque.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Conta não encontrada");
                    }
                    break;
                case "Cadastro":
                    System.out.println("Cadastro");
                    String numConta = JOptionPane.showInputDialog(
                            "Informe numero da conta");

                    String senha = JOptionPane.showInputDialog(
                            "Informe uma senha");

                    String saldoDisponivel = JOptionPane.showInputDialog(
                            "Informe valor do Saldo Inicial");

                    String saldoTotal = JOptionPane.showInputDialog(
                            "Informe valor do Saldo");

                    Conta contaCadastro = new Conta(Integer.parseInt(numConta), senha,
                            Double.parseDouble(saldoDisponivel),
                            Double.parseDouble(saldoTotal));

                    t.cadastrar(contaCadastro);
                    break;
                case "Saque":
                    System.out.println("Saque");

                    String valorSaque = JOptionPane.showInputDialog(
                            "Informe valor do Saque");

                    double saque = Double.parseDouble(valorSaque);

                    conta.debitar(saque);
                    t.sacar(conta);
                    break;
                case "Deposito":
                    System.out.println("Deposito");
                    String valorDeposito = JOptionPane.showInputDialog(
                            "Informe valor do Deposito");
                    
                    double deposito = Double.parseDouble(valorDeposito);
                    conta.creditar(deposito);
                    t.depositar(conta);
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
        buttonFrame.setSize(430, 70); // set frame size
        buttonFrame.setVisible(true); // display frame

    }

}
