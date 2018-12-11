/**
 *
 * @author maury
 */
public class Transacao{
    
    
   public int getNumConta(Conta conta){
       return conta.getNumConta();
   }
   
   public void sacar(Conta conta){
       ContaDAO.getInstance().update(conta);
   }
   
   public void depositar(Conta conta){
       ContaDAO.getInstance().update(conta);
   }
    
    
}
