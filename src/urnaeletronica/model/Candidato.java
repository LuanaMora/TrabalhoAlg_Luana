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
public class Candidato  extends Pessoa{
    private int codigo;
    private String numero;
    private String nome;
    private Partido partido;  
    private int voto;



    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }


    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    


    
    @Override
    public String toString() {
        return  "\n"+ codigo + " | " + numero + " | " + nome + " | " + partido.getSigla();
    }
}
