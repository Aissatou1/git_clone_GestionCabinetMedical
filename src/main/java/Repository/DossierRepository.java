package Repository;

import Domain.Dossier;

import java.util.List;

public interface DossierRepository {
    public int addDossier(Dossier d);
    public List<Dossier> listeDossiers();
}
