package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class ClasseRepository {

    //CREATE
    public void createClasse(Classe classe) {
        //da modificare
        String query =
                "INSERT INTO Classe " +
                        "(sezione,idDocente) "+
                        "VALUES " +
                        "('" + classe.getSezione() +"','"+classe.getIdDocente()+"')";
        //resta invariato
        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //READ
    public ArrayList<Classe> readClasse() {
        ArrayList<Classe> listaClassi = new ArrayList<>();
        String query =
                "SELECT id,sezione,idDocente "+
                        "FROM Classe "+
                        "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Classe classe = new Classe();

                //creo le associazioni con la tabella
                classe.setId(rs.getInt("id"));
                classe.setSezione(rs.getString("sezione"));
                classe.setIdDocente(rs.getInt("idDocente"));

                listaClassi.add(classe);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaClassi;
    }


    //DELETE
    public void deleteClasse(Classe classe)
    {
        //Da modificare
        String query =
                "DELETE FROM Classe " +
                        "WHERE id = '" + classe.getId() + "'";

        //resta invariato
        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //UPDATE
    public void updateClasse(Classe classe)
    {
        //Da modificare
        String query =
                "UPDATE Classe " +
                        "SET sezione = '" + classe.getSezione() + "', " +
                        "idDocente = '" + classe.getIdDocente() + "' "+
                        "WHERE id = " + classe.getId();

        //Resta invariato
        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
