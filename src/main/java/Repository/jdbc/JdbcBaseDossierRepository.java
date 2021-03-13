package Repository.jdbc;

import Domain.Dossier;
import Domain.Enfant;
import Repository.DataSource;
import Repository.DossierRepository;
import Repository.EnfantRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcBaseDossierRepository implements DossierRepository {
    DossierRepository dossierRepository;
    private int ok = 0 ;
    private Dossier d = null ;
    DataSource jdbcBasedDataSourceRepository;

    public JdbcBaseDossierRepository() {
        jdbcBasedDataSourceRepository = new JdbcBasedDataSourceRepository();

    }
    @Override
    public int addDossier(Dossier d) {
        String query="INSERT INTO dossier values(null,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, d.getNomEnf());
            statement.setString(2, d.getPrenomEnf());
            statement.setInt(3, d.getAge());
            statement.setString(4, d.getAllergie());
            statement.setString(5, d.getAntecedant());
            statement.setString(6, d.getSexe());
            statement.setString(7, d.getTelephone());
            statement.setString(8, d.getMaladie());
            statement.setString(8, d.getAdresseEnf());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;

    }

    @Override
    public List<Dossier> listeDossiers() {
        List<Dossier> listes= new ArrayList<Dossier>();
        String query="SELECT* from dossier";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                d=new Dossier();
                d.setNomEnf(rs.getString("nomEnf"));
                d.setPrenomEnf(rs.getString("prenomEnf"));
                d.setAge(rs.getInt("age"));
                d.setAdresseEnf(rs.getString("adresse"));
                d.setTelephone(rs.getString("tel"));
                d.setAllergie(rs.getString("nomParent"));
                d.setAntecedant(rs.getString("vaccin"));
                d.setMaladie(rs.getString("vaccin"));
                d.setSexe(rs.getString("vaccin"));;
                listes.add(d);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return listes;
    }

}
