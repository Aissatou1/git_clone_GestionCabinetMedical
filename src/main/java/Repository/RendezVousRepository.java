package Repository;

import Domain.RendezVous;

import java.util.List;

public interface RendezVousRepository {
    public int addRendezVous(RendezVous r);
    public List<RendezVous> listeRendezVous();
}
