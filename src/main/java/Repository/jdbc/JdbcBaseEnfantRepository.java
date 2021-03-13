package Repository.jdbc;


import Domain.Enfant;
import Repository.DataSource;
import Repository.EnfantRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcBaseEnfantRepository implements EnfantRepository {
    EnfantRepository enfantRepository;
    private int ok = 0 ;
    private Enfant e = null ;
    DataSource jdbcBasedDataSourceRepository;

    public JdbcBaseEnfantRepository() {
        jdbcBasedDataSourceRepository = new JdbcBasedDataSourceRepository();

    }

    @Override
    public int addEnfant(Enfant e) {
        String query="INSERT INTO enfant values(null,?,?,?,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, e.getNomE());
            statement.setString(2, e.getPrenomE());
            statement.setInt(3, e.getAge());
            statement.setString(4, e.getAdresse());
            statement.setString(5, e.getTelephone());
            statement.setString(6, e.getNomP());
            statement.setString(7, e.getVacccin());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;

    }

    @Override
    public List<Enfant> listeEnfants() {
        List<Enfant> listes= new ArrayList<Enfant>();
        String query="SELECT* from enfant";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                e=new Enfant();
                e.setNomE(rs.getString("nomEnf"));
                e.setPrenomE(rs.getString("prenomEnf"));
                e.setAge(rs.getInt("age"));
                e.setAdresse(rs.getString("adresse"));
                e.setTelephone(rs.getString("tel"));
                e.setNomP(rs.getString("nomParent"));
                e.setVacccin(rs.getString("vaccin"));
               listes.add(e);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return listes;
    }

}
