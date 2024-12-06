package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class DocenteRepository {

    //CREATE
    public void createDocente(Docente docente) {
        //da modificare
        String query =
                "INSERT INTO Docente " +
                        "(nome,cognome) "+
                        "VALUES " +
                        "('" + docente.getNome() +"','"+docente.getCognome() +"')";
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
    public ArrayList<Docente> readDocente() {
        ArrayList<Docente> listaDocenti = new ArrayList<>();
        String query =
                "SELECT id,nome,cognome "+
                        "FROM Docente "+
                        "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Docente docente = new Docente();

                //creo le associazioni con la tabella
                docente.setId(rs.getInt("id"));
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));

                listaDocenti.add(docente);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDocenti;
    }


    //DELETE
    public void deleteDocente(Docente docente)
    {
        //Da modificare
        String query =
                "DELETE FROM Docente " +
                        "WHERE id = '" + docente.getId() + "'";

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
    public void updateDocente(Docente docente)
    {
        //Da modificare
        String query =
                "UPDATE Docente " +
                        "SET nome = '" + docente.getNome() + "', " +
                        "cognome = '" + docente.getCognome() + "' "+
                        "WHERE id = " + docente.getId();

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
