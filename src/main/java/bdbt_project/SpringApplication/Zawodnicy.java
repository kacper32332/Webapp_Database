package bdbt_project.SpringApplication;

public class Zawodnicy {
    private int nr_zawodnika;
    private String imie;
    private String nazwisko;
    private String plec;
    private String email;
    private String nr_telefonu;
    private String data_urodzenia;
    private int nr_adresu;

    public Zawodnicy() {
    }

    public Zawodnicy(int nr_zawodnika, String imie, String nazwisko, String plec, String email, String nr_telefonu) {
        this.nr_zawodnika = nr_zawodnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.data_urodzenia = data_urodzenia;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_zawodnika() {
        return nr_zawodnika;
    }

    public void setNr_zawodnika(int nr_zawodnika) {
        this.nr_zawodnika = nr_zawodnika;
    }

    public String getImie() {
        return imie;
    }

    @Override
    public String toString() {
        return "Zawodnicy{" +
                "nr_zawodnika=" + nr_zawodnika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                '}';
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }
    public int getNr_adresu() {
        return nr_adresu;
    }
    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
