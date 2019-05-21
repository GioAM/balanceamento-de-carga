/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceamento.de.carga;

import java.util.List;

/**
 *
 * @author giovani.meneguel
 */
public class Processador {
    private String activity;
    private Integer processors;
    private Integer load;
    private boolean enabled;
    
    public Processador(){
        activity = "";
        processors = 0;
        load = 0;
        enabled = true;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
       this.activity = this.activity + " / " + activity;
    }

    public Integer getProcessors() {
        return processors;
    }

    public void setProcessors(Integer processors) {
        this.processors = this.processors + processors;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Integer getLoad() {
        return load;
    }
    public void setLoad(Integer load) {
        this.load = this.load + load;
    }
}
