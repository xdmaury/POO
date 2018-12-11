
/**
 *
 * @author maury
 */
public class Transacao {

    public int getNumConta(Conta conta) {
        return conta.getNumConta();
    }
    
    public Conta login(int numConta, String senha){
        if(ContaDAO.getInstance().isExistConta(numConta, senha)){
            return ContaDAO.getInstance().findConta(numConta);
        }
        return new Conta(0, "", 0.0, 0.0);
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
