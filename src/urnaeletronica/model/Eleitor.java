/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica.model;

/**
 *
 * @author TPSI-LUANA
 */
public class Eleitor  extends Pessoa{
    private int codigo;
    private String titulo_eleitor;
    private String nome;
    private String cpf;

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo_eleitor() {
        return titulo_eleitor;
    }

    public void setTitulo_eleitor(String titulo_eleitor) {
        this.titulo_eleitor = titulo_eleitor;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

 

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n"+"Eleitor{" + "codigo=" + codigo + ", titulo_eleitor=" + titulo_eleitor + ", descricao=" + nome + ", cpf=" + cpf + '}';
    }
    
    
    
    
}
