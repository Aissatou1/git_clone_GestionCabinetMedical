package Repository.jdbc;

import Domain.Enfant;
import Domain.Medecin;
import Repository.DataSource;
import Repository.MedecinRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcBaseMedecinRepository implements MedecinRepository {
    MedecinRepository medecinRepository;
    private int ok = 0 ;
    private Medecin m = null ;
    DataSource jdbcBasedDataSourceRepository;

    public JdbcBaseMedecinRepository() {
        jdbcBasedDataSourceRepository = new JdbcBasedDataSourceRepository();
}

    @Override
    public int addMedecin(Medecin m) {
    String query="INSET INTO medecin values(null,?,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, m.getNomMed());
            statement.setString(2, m.getPrenomMed());
            statement.setString(3, m.getSpecialite());
            statement.setString(4, m.getAdresseMed());
            statement.setString(5, m.getTelephoneMed());

            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Medecin> listeMedecins() {
        List<Medecin> listes= new ArrayList<Medecin>();
        String query="SELECT* from medecin";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                m=new Medecin();
                m.setNomMed(rs.getString("nomMed"));
                m.setPrenomMed(rs.getString("prenomMed"));
                m.setSpecialite(rs.getString("specialite"));
                m.setAdresseMed(rs.getString("adresseMed"));
                m.setTelephoneMed(rs.getString("telMed"));
                listes.add(m);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return listes;
    }
}