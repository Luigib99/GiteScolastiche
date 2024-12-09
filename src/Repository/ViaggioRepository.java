package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class ViaggioRepository {

    //CREATE
    public void createViaggio(Viaggio viaggio) {
        //da modificare
        String query =
                "INSERT INTO Viaggio " +
                        "(idGita,idClasse) "+
                        "VALUES " +
                        "('" + viaggio.getIdGita() +"','"+ viaggio.getIdClasse() +"')";

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
    public ArrayList<Viaggio> readViaggio() {
        ArrayList<Viaggio> listaViaggi = new ArrayList<>();
        String query =
                "SELECT id,idGita,idClasse "+
                        "FROM Viaggio "+
                        "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Viaggio viaggio = new Viaggio();

                //creo le associazioni con la tabella
                viaggio.setId(rs.getInt("id"));
                viaggio.setIdGita(rs.getInt("idGita"));
                viaggio.setIdClasse(rs.getInt("idClasse"));

                //aggiungo l'viaggio alla lista
                listaViaggi.add(viaggio);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaViaggi;
    }


    //DELETE
    public void deleteViaggio(Viaggio viaggio)
    {
        //Da modificare
        String query =
                "DELETE FROM Viaggio " +
                        "WHERE id = '" + viaggio.getId() + "'";

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
    public void updateViaggio(Viaggio viaggio)
    {
        //Da modificare
        String query =
                "UPDATE Viaggio " +
                        "SET idGita = '" + viaggio.getIdGita() + "', " +
                        "idClasse = '" + viaggio.getIdClasse() + "' "+
                        "WHERE id = " + viaggio.getId();

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
