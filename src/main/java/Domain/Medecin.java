package Domain;

public class Medecin {
    private int idMedecin;
    private String nomMed;
    private String prenomMed;
    private String specialite;
    private String telephoneMed;
    private String adresseMed;



    public Medecin() {
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getPrenomMed() {
        return prenomMed;
    }

    public void setPrenomMed(String prenomMed) {
        this.prenomMed = prenomMed;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getTelephoneMed() {
        return telephoneMed;
    }

    public void setTelephoneMed(String telephoneMed) {
        this.telephoneMed = telephoneMed;
    }

    public String getAdresseMed() {
        return adresseMed;
    }

    public void setAdresseMed(String adresseMed) {
        this.adresseMed = adresseMed;
    }
}
