package id.codes.pcms.Model;

public class DataRealtime {
    double airTemp,airHum,lux,soilHum,soilTemp,pH;

    public DataRealtime(double airTemp, double airHum, double lux, double soilHum, double soilTemp, double pH) {
        this.airTemp = airTemp;
        this.airHum = airHum;
        this.lux = lux;
        this.soilHum = soilHum;
        this.soilTemp = soilTemp;
        this.pH = pH;
    }

    public double getAirTemp() {
        return airTemp;
    }

    public double getAirHum() {
        return airHum;
    }

    public double getLux() {
        return lux;
    }

    public double getSoilHum() {
        return soilHum;
    }

    public double getSoilTemp() {
        return soilTemp;
    }

    public double getpH() {
        return pH;
    }
}
