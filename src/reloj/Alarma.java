/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jmcor
 */
public class Alarma implements Serializable{
    
    private Date hora;
    private boolean activacion;

    public Alarma(Date hora, boolean activacion) {
        this.hora = hora;
        this.activacion = activacion;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    
    
}
