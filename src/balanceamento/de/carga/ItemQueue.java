/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceamento.de.carga;

import org.json.JSONObject;

/**
 *
 * @author giovani.meneguel
 */
public class ItemQueue {
    private JSONObject task;
    private String process;
    
    
    public JSONObject getTask() {
        return task;
    }

    public void setTask(JSONObject task) {
        this.task = task;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
