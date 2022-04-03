package id.codes.pcms.Model;

public class DataSuhu {
    String waktu;
    float value;

    public DataSuhu(String waktu, float value) {
        this.waktu = waktu;
        this.value = value;
    }
    public DataSuhu(){}

    public String getwaktu() {
        return waktu;
    }

    public float getvalue() {
        return value;
    }
}
