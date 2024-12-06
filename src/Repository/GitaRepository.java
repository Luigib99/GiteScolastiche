package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class GitaRepository {

    //CREATE
    public void createGita(Gita gita) {
        //da modificare
        String query =
                "INSERT INTO Gita " +
                        "(idDocente,luogo,dataInizio,dataFine) "+
                        "VALUES " +
                        "('" + gita.getIdDocente() +"','"+gita.getLuogo() +"','" + gita.getDataInizio() +"','" + gita.getDataFine() +"')";
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
    public ArrayList<Gita> readGita() {
        ArrayList<Gita> listaGite = new ArrayList<>();
        String query =
                "SELECT id,idDocente,luogo,dataInizio,dataFine "+
                        "FROM Gita "+
                        "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Gita gita = new Gita();

                //creo le associazioni con la tabella
                gita.setId(rs.getInt("id"));
                gita.setIdDocente(rs.getInt("idDocente"));
                gita.setLuogo(rs.getString("luogo"));

                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null)
                {
                    gita.setDataInizio(dataInizio.toLocalDate());
                }

                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {gita.setDataFine(dataFine.toLocalDate());}

                listaGite.add(gita);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGite;
    }


    //DELETE
    public void deleteGita(Gita gita)
    {
        //Da modificare
        String query =
                "DELETE FROM Gita " +
                        "WHERE id = '" + gita.getId() + "'";

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
    public void updateOggetto(Gita gita)
    {
        //Da modificare
        String query =
                "UPDATE Gita " +
                        "SET idDocente = '" + gita.getIdDocente() + "', " +
                        "luogo = '" + gita.getLuogo() + "', "+
                        "dataInizio = '" + gita.getDataInizio() + "', "+
                        "dataFine = '" + gita.getDataFine() + "' " +
                        "WHERE id = " + gita.getId();

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
