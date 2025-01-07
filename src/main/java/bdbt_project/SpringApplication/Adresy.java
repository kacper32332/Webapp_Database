package bdbt_project.SpringApplication;

public class Adresy {
    private int nr_adresu;
    private String miejscowosc;
    private String ulica;
    private String kod_pocztowy;
    private String nr_domu;
    private String nr_mieszkania;

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "nr_adresu=" + nr_adresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", nr_domu='" + nr_domu + '\'' +
                ", nr_mieszkania='" + nr_mieszkania + '\'' +
                '}';
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getNr_mieszkania() {
        return nr_mieszkania;
    }

    public void setNr_mieszkania(String nr_mieszkania) {
        this.nr_mieszkania = nr_mieszkania;
    }

    public Adresy(int nr_adresu, String miejscowosc, String ulica, String kod_pocztowy, String nr_domu, String nr_mieszkania) {
        super();
        this.nr_adresu = nr_adresu;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.kod_pocztowy = kod_pocztowy;
        this.nr_domu = nr_domu;
        this.nr_mieszkania = nr_mieszkania;
    }
}
