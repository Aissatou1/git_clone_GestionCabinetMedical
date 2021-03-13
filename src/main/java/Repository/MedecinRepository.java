package Repository;

import Domain.Medecin;

import java.util.List;

public interface MedecinRepository {
    public int addMedecin(Medecin m);
    public List<Medecin> listeMedecins();
}
