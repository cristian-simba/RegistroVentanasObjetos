import java.io.Serializable;

public class Datos implements Serializable {
    String pais;
    String capital;
    int poblacion;
    double dinero;

    public Datos(String pais, String capital, int poblacion, double dinero) {
        this.pais = pais;
        this.capital = capital;
        this.poblacion = poblacion;
        this.dinero = dinero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    public String toString(){
        return
        "Pais: "+ pais + "/Capital: " + capital + " /Poblacion: " + poblacion + "/Dinero: " + dinero ;
    }
}

