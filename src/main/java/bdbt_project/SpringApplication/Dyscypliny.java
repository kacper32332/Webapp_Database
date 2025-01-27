package bdbt_project.SpringApplication;

public class Dyscypliny {
    private int nr_dyscypliny;
    private String nazwa_dyscypliny;
    private String opis;

    public Dyscypliny() {
    }

    public Dyscypliny(int nr_adresu, String miejscowosc, String ulica) {
        this.nr_dyscypliny = nr_adresu;
        this.nazwa_dyscypliny = miejscowosc;
        this.opis = ulica;
    }

    public int getNr_dyscypliny() {
        return nr_dyscypliny;
    }

    public void setNr_dyscypliny(int nr_dyscypliny) {
        this.nr_dyscypliny = nr_dyscypliny;
    }

    public String getNazwa_dyscypliny() {
        return nazwa_dyscypliny;
    }

    public void setNazwa_dyscypliny(String nazwa_dyscypliny) {
        this.nazwa_dyscypliny = nazwa_dyscypliny;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Dyscypliny{" +
                "nr_adresu=" + nr_dyscypliny +
                ", miejscowosc='" + nazwa_dyscypliny + '\'' +
                ", ulica='" + opis + '\'' +
                '}';
    }
}
