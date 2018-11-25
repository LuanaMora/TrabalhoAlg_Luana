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
public class Urna {
    private int codigo;
    private Candidato codigo_candidato;
    private Eleitor codigo_eleitor;
    private Date data;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Candidato getCodigo_candidato() {
        return codigo_candidato;
    }

    public void setCodigo_candidato(Candidato codigo_candidato) {
        this.codigo_candidato = codigo_candidato;
    }

    public Eleitor getCodigo_eleitor() {
        return codigo_eleitor;
    }

    public void setCodigo_eleitor(Eleitor codigo_eleitor) {
        this.codigo_eleitor = codigo_eleitor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
