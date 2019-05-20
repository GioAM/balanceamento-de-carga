/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceamento.de.carga;

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
    String apps = "[\n" +
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
        "						\"id\": 2,\n" +
        "						\"communication\": 100,\n" +
        "					},\n" +
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
        JSONArray tests = new JSONArray(testJSON);
        for(int i = 0; i < tests.length(); i++){
            JSONObject test = tests.getJSONObject(i);
            Integer id = test.getInt("id");
            System.out.println("Test #" + id);
        }
    }
    
}
