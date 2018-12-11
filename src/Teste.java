
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maury
 */
public class Teste extends JFrame {

    private JButton buttonLogin;
    private JButton buttonSaque;
    private JButton buttonDeposito;
    private JButton buttonExtrato;

    public Teste() {
        super("Caixa eletronico");
        setLayout(new FlowLayout());

        buttonLogin = new JButton("Login");
        add(buttonLogin);

        buttonSaque = new JButton("Saque");
        add(buttonSaque);

        buttonDeposito = new JButton("Deposito");
        add(buttonDeposito);

        buttonExtrato = new JButton("Extrato");
        add(buttonExtrato);

        // create new ButtonHandler for button event handling 
        ButtonHandler handler = new ButtonHandler();
        buttonLogin.addActionListener(handler);
        buttonSaque.addActionListener(handler);
        buttonDeposito.addActionListener(handler);
        buttonExtrato.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        // handle button event

        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "Login":
                    System.out.println("Login");
                    break;
                case "Saque":
                    break;
                case "Deposito":
                    break;
                case "Extrato":
                    break;
                default:
                    break;
            }
            
        }
    }

    public static void main(String[] args) {
        Teste buttonFrame = new Teste(); // create ButtonFrame
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(400, 400); // set frame size
        buttonFrame.setVisible(true); // display frame

    }

}
