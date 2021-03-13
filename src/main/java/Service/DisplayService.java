package Service;

import Domain.Dossier;
import Domain.Enfant;
import Domain.Medecin;
import Domain.RendezVous;

public interface DisplayService {
    void afficherBienvenu();

    void afficherMenuPrincipal();
    void afficherChoix(String choix);
    public String choixMenu();
    public Enfant saisiEnfant();
    public void ajoutConsultation ();
    public RendezVous saisiRendezVous();
    public void ajoutRendezVous ();
    public Dossier saisieDossier();
    public void ajoutDossier();
    public Medecin saisiMedecin();


}
