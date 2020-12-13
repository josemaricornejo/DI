/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.beans.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author jmcor
 */
public class RelojDigital extends JLabel implements Serializable, Runnable {

    private boolean formato;
    private boolean estado;
    
    Date horaReloj = new Date();
    private Alarma alarma;
       
    Thread hilo;
    
    private AlarmaListener alarmaListener;

    private SimpleDateFormat f24 = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat f12 = new SimpleDateFormat("hh:mm:ss a");

    public RelojDigital() {
        
        

        hilo = new Thread(this);
        estado = true;
        hilo.start();
        
        
        System.out.println(alarma);
        if(alarma!=null){
            System.out.println("2");
            if(alarma.isActivacion() && comprobarAlarma(horaReloj, alarma.getHora())){
                if(alarmaListener!=null){
                    alarmaListener.sonarAlarma();
                }
            }
        }
        

    }

    @Override
    public void run() {
        
       

        while (estado) {
            
            Date horaReloj = new Date();

            if (formato) {
                setText(f24.format(horaReloj));
            } else {
                setText(f12.format(horaReloj));
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

        }

    }

    public boolean isFormato() {
        return formato;
    }

    public void setFormato(boolean formato) {
        this.formato = formato;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    public void addAlarmaListener(AlarmaListener alarmaListener){
        this.alarmaListener=alarmaListener; 
    }
    
    public void removeAlarmaListener(){
        this.alarmaListener=null;
    }

    private boolean comprobarAlarma(Date obtenerReloj, Date obtenerAlarma) {

        Calendar horario = Calendar.getInstance();
        int horaReloj, minReloj, segReloj, horaAlarma, minAlarma, segAlarma;

        horario.setTime(obtenerReloj);
        horaReloj = horario.get(Calendar.HOUR_OF_DAY);
        minReloj = horario.get(Calendar.MINUTE);
        segReloj = horario.get(Calendar.SECOND);

        horario.setTime(obtenerAlarma);
        horaAlarma = horario.get(Calendar.HOUR_OF_DAY);
        minAlarma = horario.get(Calendar.MINUTE);
        segAlarma = horario.get(Calendar.SECOND);

        if (horaReloj == horaAlarma && minReloj == minAlarma && segReloj == segAlarma) {
            return true;
        } else {
            return false;
        }

    }

}
