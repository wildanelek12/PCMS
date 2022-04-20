package id.codes.pcms.Model;

public class DataHistory {
    float sensor_node1,sensor_node2,sensor_node3;
    String waktu;

    public DataHistory(){}
    public DataHistory(float sensor_node1, float sensor_node2, float sensor_node3, String waktu) {
        this.sensor_node1 = sensor_node1;
        this.sensor_node2 = sensor_node2;
        this.sensor_node3 = sensor_node3;
        this.waktu = waktu;
    }

    public float getSensor_node1() {
        return sensor_node1;
    }

    public float getSensor_node2() {
        return sensor_node2;
    }

    public float getSensor_node3() {
        return sensor_node3;
    }

    public String getWaktu() {
        return waktu;
    }
}
