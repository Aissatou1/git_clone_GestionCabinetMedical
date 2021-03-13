package Domain;

public class RendezVous {
    private int idRendezVous;
    private String nomPat;
    private String prenomPat;
    private String dateRV;
    private String commentaire;

    public RendezVous() {
    }

    public int getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(int idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public String getNomPat() {
        return nomPat;
    }

    public void setNomPat(String nomPat) {
        this.nomPat = nomPat;
    }

    public String getPrenomPat() {
        return prenomPat;
    }

    public void setPrenomPat(String prenomPat) {
        this.prenomPat = prenomPat;
    }

    public String getDateRV() {
        return dateRV;
    }

    public void setDateRV(String dateRV) {
        this.dateRV = dateRV;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
