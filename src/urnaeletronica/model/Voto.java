/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica.model;

import java.util.Date;

/**
 *
 * @author TPSI-LUANA
 */
public class Voto {
    private int codigoCandidato;
    private int codigoEleitor;
    private Date data;
    

    public Voto() {
    }

    public int getCodigoCandidato() {
        return codigoCandidato;
    }

    public void setCodigoCandidato(int codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCodigoEleitor() {
        return codigoEleitor;
    }

    public void setCodigoEleitor(int codigoEleitor) {
        this.codigoEleitor = codigoEleitor;
    }
    
    

    @Override
    public String toString() {
        return "Voto{" + "candidato=" +codigoCandidato+ ", eleitor=" + codigoEleitor + ", data=" + data + '}';
    }    


}
