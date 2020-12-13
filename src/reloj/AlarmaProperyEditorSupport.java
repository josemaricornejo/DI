/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 *
 * @author jmcor
 */
public class AlarmaProperyEditorSupport extends PropertyEditorSupport {
    
    private AlarmaPanel alarmaPanel = new AlarmaPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return alarmaPanel;
    }

    @Override
    public String getJavaInitializationString() {
        
        Date horaAlarma = alarmaPanel.getSelectedValue().getHora();
        boolean activacion = alarmaPanel.getSelectedValue().isActivacion();
        return "new reloj.Alarma(new java.util.Date(" + horaAlarma.getTime() + "l)," + activacion + ")";
    }

    @Override
    public Object getValue() {
        return alarmaPanel.getSelectedValue();
    }
    
}
