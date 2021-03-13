package Repository.jdbc;

import Domain.RendezVous;
import Repository.DataSource;
import Repository.RendezVousRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcBaseRendezVousRepository implements RendezVousRepository {
    RendezVousRepository rendezVousRepository;
    private int ok = 0 ;
    private RendezVous r = null ;
    DataSource jdbcBasedDataSourceRepository;

    public JdbcBaseRendezVousRepository() {
        jdbcBasedDataSourceRepository = new JdbcBasedDataSourceRepository();

    }
    @Override
    public int addRendezVous(RendezVous r) {
        String query="INSERT INTO rendezVous values(null,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, r.getNomPat());
            statement.setString(2, r.getPrenomPat());
            statement.setString(3, r.getDateRV());
            statement.setString(4, r.getCommentaire());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;

    }

    @Override
    public List<RendezVous> listeRendezVous() {
        List<RendezVous> listes= new ArrayList<RendezVous>();
        String query="SELECT* from rendezVous";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                r=new RendezVous();
                r.setNomPat(rs.getString("nomEn"));
                r.setPrenomPat(rs.getString("prenomEn"));
                r.setDateRV(rs.getString("dateRV"));
                r.setCommentaire(rs.getString("commentaire"));
                listes.add(r);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return listes;
    }

}