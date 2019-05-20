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
    private List<String> activity[];
    private Integer processors;
    private boolean enabled;

    public List<String>[] getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
       
    }
    
    public String getActivityIndex(int index) {
      return "teste";  
    }
    
    public Integer getProcessors() {
        return processors;
    }

    public void setProcessors(Integer processors) {
        this.processors = processors;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
