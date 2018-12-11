
/**
 *
 * @author maury
 */
public class Transacao {

    public int getNumConta(Conta conta) {
        return conta.getNumConta();
    }

    public void cadastrar(Conta conta) {
        ContaDAO.getInstance().create(conta);
    }

    public void sacar(Conta conta) {
        ContaDAO.getInstance().update(conta);
    }

    public void depositar(Conta conta) {
        ContaDAO.getInstance().update(conta);
    }

}
