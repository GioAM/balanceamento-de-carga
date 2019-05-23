/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceamento.de.carga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class BalanceamentoDeCarga {
    static String testJSON = "[\n" +
        "	{\n" +
        "		\"id\": 0,\n" +
        "		\"mpsoc_x\": 5,\n" +
        "		\"mpsoc_y\": 5,\n" +
        "		\"cluster_x\": 5,\n" +
        "		\"cluster_y\": 5,\n" +
        "		\"tasks_per_pe\": 1,\n" +
        "		\"apps\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"app_name\": \"App0\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App1\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App2\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "		]\n" +
        "	},\n" +
        "	{\n" +
        "		\"id\": 1,\n" +
        "		\"mpsoc_x\": 3,\n" +
        "		\"mpsoc_y\": 3,\n" +
        "		\"cluster_x\": 3,\n" +
        "		\"cluster_y\": 3,\n" +
        "		\"tasks_per_pe\": 2,\n" +
        "		\"apps\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"app_name\": \"App0\",\n" +
        "				\"qtd_apps\": 3,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App1\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App2\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "		]\n" +
        "	},\n" +
        "	{\n" +
        "		\"id\": 2,\n" +
        "		\"mpsoc_x\": 6,\n" +
        "		\"mpsoc_y\": 6,\n" +
        "		\"cluster_x\": 3,\n" +
        "		\"cluster_y\": 3,\n" +
        "		\"tasks_per_pe\": 1,\n" +
        "		\"apps\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"app_name\": \"App0\",\n" +
        "				\"qtd_apps\": 1,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App1\",\n" +
        "				\"qtd_apps\": 3,\n" +
        "			},\n" +
        "		]\n" +
        "	},\n" +
        "	{\n" +
        "		\"id\": 3,\n" +
        "		\"mpsoc_x\": 6,\n" +
        "		\"mpsoc_y\": 6,\n" +
        "		\"cluster_x\": 3,\n" +
        "		\"cluster_y\": 3,\n" +
        "		\"tasks_per_pe\": 2,\n" +
        "		\"apps\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"app_name\": \"App0\",\n" +
        "				\"qtd_apps\": 10,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App1\",\n" +
        "				\"qtd_apps\": 2,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App2\",\n" +
        "				\"qtd_apps\": 8,\n" +
        "			},\n" +
        "		]\n" +
        "	},\n" +
        "	{\n" +
        "		\"id\": 4,\n" +
        "		\"mpsoc_x\": 6,\n" +
        "		\"mpsoc_y\": 6,\n" +
        "		\"cluster_x\": 3,\n" +
        "		\"cluster_y\": 3,\n" +
        "		\"tasks_per_pe\": 3,\n" +
        "		\"apps\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"app_name\": \"App0\",\n" +
        "				\"qtd_apps\": 10,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App1\",\n" +
        "				\"qtd_apps\": 5,\n" +
        "			},\n" +
        "			{\n" +
        "				\"app_name\": \"App2\",\n" +
        "				\"qtd_apps\": 10,\n" +
        "			},\n" +
        "		]\n" +
        "	},\n" +
        "]";
    static String appsJSON = "[\n" +
        "	{\n" +
        "		\"name\": \"App0\",\n" +
        "		\"number_tasks\": 2,\n" +
        "		\"tasks\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"id\": 0,\n" +
        "				\"load\": 2000,\n" +
        "				\"execution_time\": 30,\n" +
        "				\"priority\": 1,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 1,\n" +
        "						\"load_communication\": 300,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 1,\n" +
        "				\"load\": 6000,\n" +
        "				\"execution_time\": 80,\n" +
        "				\"priority\": 0,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 0,\n" +
        "						\"communication\": 100,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "		],\n" +
        "	},\n" +
        "	{\n" +
        "		\"name\": \"App1\",\n" +
        "		\"number_tasks\": 6,\n" +
        "		\"tasks\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"id\": 0,\n" +
        "				\"load\": 2900,\n" +
        "				\"execution_time\": 120,\n" +
        "				\"priority\": 3,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 1,\n" +
        "						\"communication\": 200,\n" +
        "					},\n" +
        "					{\n" +
        "						\"id\": 3,\n" +
        "						\"communication\": 700,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 1,\n" +
        "				\"load\": 600,\n" +
        "				\"execution_time\": 380,\n" +
        "				\"priority\": 1,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 0,\n" +
        "						\"communication\": 500,\n" +
        "					},\n" +
        "					{\n" +
        "				},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 2,\n" +
        "				\"load\": 1600,\n" +
        "				\"execution_time\": 300,\n" +
        "				\"priority\": 2,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 1,\n" +
        "						\"communication\": 40,\n" +
        "					},\n" +
        "					{\n" +
        "						\"id\": 3,\n" +
        "						\"communication\": 110,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 3,\n" +
        "				\"load\": 1000,\n" +
        "				\"execution_time\": 80,\n" +
        "				\"priority\": 0,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 0,\n" +
        "						\"communication\": 50,\n" +
        "					},\n" +
        "					{\n" +
        "						\"id\": 2,\n" +
        "						\"communication\": 150,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "		],\n" +
        "	},\n" +
        "	{\n" +
        "		\"name\": \"App2\",\n" +
        "		\"number_tasks\": 3,\n" +
        "		\"tasks\":\n" +
        "		[\n" +
        "			{\n" +
        "				\"id\": 0,\n" +
        "				\"load\": 4321,\n" +
        "				\"execution_time\": 230,\n" +
        "				\"priority\": 0,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 2,\n" +
        "						\"communication\": 150,\n" +
        "					},\n" +
        "					{\n" +
        "						\"id\": 1,\n" +
        "						\"communication\": 150,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 1,\n" +
        "				\"load\": 1234,\n" +
        "				\"execution_time\": 280,\n" +
        "				\"priority\": 1,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 0,\n" +
        "						\"communication\": 130,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "			{\n" +
        "				\"id\": 2,\n" +
        "				\"load\": 5436,\n" +
        "				\"execution_time\": 380,\n" +
        "				\"priority\": 2,\n" +
        "				\"task_communications\":\n" +
        "				[\n" +
        "					{\n" +
        "						\"id\": 0,\n" +
        "						\"communication\": 450,\n" +
        "					},\n" +
        "				]\n" +
        "			},\n" +
        "		],\n" +
        "	},\n" +
        "]";
    
    public static void main(String[] args) {
        Queue<ItemQueue> taskQueue = new LinkedList<>(); 
        JSONArray tests =  new JSONArray(testJSON);
        JSONArray apps =  new JSONArray(appsJSON);
        for(int i = 0; i < tests.length(); i++){
            JSONObject test =  tests.getJSONObject(i);
            Integer id = test.getInt("id");
            System.out.println("Teste #" + id);
            JSONArray testApps = test.getJSONArray("apps");
            Integer tasks_per_pe = test.getInt("tasks_per_pe");
            Integer mpsoc_y = test.getInt("mpsoc_y");
            Integer mpsoc_x = test.getInt("mpsoc_x");
            Integer cluster_y = test.getInt("cluster_y");
            Integer cluster_x = test.getInt("cluster_x");
            Processador processors[][] = new Processador[mpsoc_x][mpsoc_y];
            
            for(int p = 0; p <  mpsoc_x; p++){
                for(int q = 0; q < mpsoc_y; q++){
                    processors[p][q] = new Processador();
                }
            }
            Integer cluster = (mpsoc_y * mpsoc_x) /(cluster_y * cluster_x);
            for(int a = 0; a < cluster; a++){
                processors[0][a].setActivity("GMP");
                processors[0][a].setEnabled(false);
            }
            for(int j = 0; j < testApps.length(); j++){
                JSONObject testApp = testApps.getJSONObject(j);
                String testAppName = testApp.getString("app_name");
                Integer qtd_apps = testApp.getInt("qtd_apps");
                for(int k = 0;  k < apps.length(); k++){
                    JSONObject app = apps.getJSONObject(k);
                    String appName =  app.getString("name");
                    if(appName.equals(testAppName)){
                        for(int m = 0; m < qtd_apps ; m++){
                            JSONArray tasksApp = app.getJSONArray("tasks");
                            for(int l = 0; l < tasksApp.length(); l++){
                                JSONObject taskApp = tasksApp.getJSONObject(l);
                                Integer idTaskApp =  taskApp.getInt("id");
                                ItemQueue taskToQueue = new ItemQueue();
                                taskToQueue.setTask(taskApp);
                                taskToQueue.setProcess(appName + " : " + idTaskApp);
                                taskQueue.add(taskToQueue);
                            }
                        }
                    }
                }
            }
            ArrayList<ItemArray> arrayProcessador = new ArrayList<>();
             for(int n = 0; n <  mpsoc_x; n++){
                for(int o = 0; o < mpsoc_y; o++){
                    if(processors[n][o].isEnabled()){
                        String atividade = taskQueue.element().getProcess();
                        processors[n][o].setActivity(atividade);
                        Integer load = taskQueue.remove().getTask().getInt("load");
                        processors[n][o].setLoad(load);
                        processors[n][o].setProcessors(1);
                        ItemArray item = new ItemArray();
                        item.setX(n);
                        item.setY(o);
                        item.setLoad(processors[n][o].getLoad());
                        arrayProcessador.add(item);
                        if(processors[n][o].getProcessors() >= tasks_per_pe){
                            processors[n][o].setEnabled(false);
                        }
                        if(taskQueue.isEmpty()){
                            System.out.println("Todas as tarefas foram alocadas");
                            break;
                        }
                    }
                }
                if(taskQueue.isEmpty()){
                    break;
                }
            }
            System.out.println("TASK_PER_PE : " + tasks_per_pe);
            Collections.sort(arrayProcessador, (ItemArray item1, ItemArray item2) -> item1.getLoad().compareTo(item2.getLoad()));
            taskQueue.forEach((item) -> {
                boolean alocatted = false;
                Integer index = 0;
                while(!alocatted){
                    Integer x = arrayProcessador.get(index).getX();
                    Integer y = arrayProcessador.get(index).getY();
                    Integer load = item.getTask().getInt("load");
                    if(processors[x][y].getProcessors() >= tasks_per_pe){
                        processors[x][y].setEnabled(false);
                    }
                    if(processors[x][y].isEnabled()){
                        processors[x][y].setLoad(load);
                        processors[x][y].setActivity(item.getProcess());
                        processors[x][y].setProcessors(1);
                        arrayProcessador.get(index).setLoad(processors[x][y].getLoad());
                        Collections.sort(arrayProcessador, (ItemArray item1, ItemArray item2) -> item1.getLoad().compareTo(item2.getLoad()));
                        alocatted = true;
                    }else{
                        index++;
                    }
                }
            });
            for(int n = 0; n <  mpsoc_x; n++){
                for(int o = 0; o < mpsoc_y; o++){
                    System.out.println("Processors " + "[" + n +"]"+ "[" + o +"] = " + processors[n][o].getActivity() + " >> Load : "+ processors[n][o].getLoad() + " >> enabled : "+ processors[n][o].isEnabled() + " processos : " + processors[n][o].getProcessors());
                }
            }
        }
    } 
}
