package Domain;

public class Dossier {
    private int idDossier;
    private String nomEnf;
    private String prenomEnf;
    private String adresseEnf;
    private int age;
    private String sexe;
    private String telephone;
    private String antecedant;
    private String allergie;
    private String maladie;

    public Dossier() {
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public String getNomEnf() {
        return nomEnf;
    }

    public void setNomEnf(String nomEnf) {
        this.nomEnf = nomEnf;
    }

    public String getPrenomEnf() {
        return prenomEnf;
    }

    public void setPrenomEnf(String prenomEnf) {
        this.prenomEnf = prenomEnf;
    }

    public String getAdresseEnf() {
        return adresseEnf;
    }

    public void setAdresseEnf(String adresseEnf) {
        this.adresseEnf = adresseEnf;
    }



    public String getSexe() {
        return sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAntecedant() {
        return antecedant;
    }

    public void setAntecedant(String antecedant) {
        this.antecedant = antecedant;
    }

    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }
}
