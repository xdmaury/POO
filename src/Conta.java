/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maury
 */
public class Conta {

    private int numConta;
    private String senha;
    private double saldo_disponível;
    private double saldo_total;

    public Conta(int numConta, String senha, double saldo_disponível, double saldo_total) {
        setNumConta(numConta);
        setSenha(senha);
        setSaldo_total(saldo_total);
        setSaldo_disponível(saldo_disponível);
        
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        if (numConta > 0) {
            this.numConta = numConta;
        } else {
            this.numConta = 0;
        }
    }
    

    public double getSaldo_total() {
        return saldo_total;
    }

    public void setSaldo_total(double saldo_total) {
        if (saldo_total > 0) {
            this.saldo_total = saldo_total;
        }else{
            this.saldo_total = 0;
        }
    }

    public boolean validarSenha(String senha) {
        if (getSenha().equals(senha)) {
            return true;
        }
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSaldo_disponível(double saldo_disponível) {
        if(saldo_disponível > 0){
            this.saldo_disponível = saldo_disponível;
        }else{
            
        }
    }
    

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo_disponível() {
        return saldo_disponível;
    }

    public void creditar(double valor) {
        if (valor > 0) {
            this.saldo_total += valor;
        } else {
            this.saldo_total += 0;
        }
    }

    public void debitar(double valor) {
        if (getSaldo_disponível() >= valor) {
            this.saldo_disponível -= valor;
        } else {
            this.saldo_disponível -= 0;
        }
    }

}
