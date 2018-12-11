/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maury
 */
public class BancoDados extends CaixaEletronico{

    //somente declarar métodos para autenticar usuário, crédito e débito 
    
    @Override
    public Boolean isExistContato(int numConta, String senha) {
        return ContaDAO.getInstance().isExistConta(numConta, senha);
    }
   
    
    
  
    
}
