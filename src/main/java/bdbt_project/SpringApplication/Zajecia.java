package bdbt_project.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Zajecia {
    private int nr_zajec;
    private String nazwa_zajec;
    private String limit_miejsc;
    private String czas_trwania;

    public void setData_rozpoczecia(LocalDate data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_rozpoczecia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_zakonczenia;
    private String nr_dyscypliny;

    public Zajecia() {
    }

    public Zajecia(int nr_zajec, String nazwa_zajec, String limit_miejsc, String czas_trwania, LocalDate data_rozpoczecia, LocalDate data_zakonczenia, String nr_dyscypliny) {
        this.nr_zajec = nr_zajec;
        this.nazwa_zajec = nazwa_zajec;
        this.limit_miejsc = limit_miejsc;
        this.czas_trwania = czas_trwania;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
        this.nr_dyscypliny = nr_dyscypliny;
    }

    public int getNr_zajec() {
        return nr_zajec;
    }

    public void setNr_zajec(int nr_zajec) {
        this.nr_zajec = nr_zajec;
    }

    public String getNazwa_zajec() {
        return nazwa_zajec;
    }



    public void setNazwa_zajec(String nazwa_zajec) {
        this.nazwa_zajec = nazwa_zajec;
    }

    public String getLimit_miejsc() {
        return limit_miejsc;
    }

    public void setLimit_miejsc(String limit_miejsc) {
        this.limit_miejsc = limit_miejsc;
    }

    public String getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(String czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public LocalDate getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public LocalDate getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(LocalDate data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }

    public String getNr_dyscypliny() {
        return nr_dyscypliny;
    }
    public void setNr_dyscypliny(String nr_dyscypliny) {
        this.nr_dyscypliny = nr_dyscypliny;
    }
}
