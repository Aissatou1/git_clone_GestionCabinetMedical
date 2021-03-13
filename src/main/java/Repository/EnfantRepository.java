package Repository;

import Domain.Enfant;

import java.util.List;

public interface EnfantRepository {
    public int addEnfant(Enfant e);
    public List<Enfant> listeEnfants();

}
