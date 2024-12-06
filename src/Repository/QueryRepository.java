package Repository;

import Config.DbConnection;
import Entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryRepository {
    public ArrayList<Gita> query1(int idGita) {
        ArrayList<Gita> listaGite = new ArrayList<>();
        String query =
                "SELECT g.luogo, c.sezione " +
                        "FROM Gita g " +
                        "JOIN Viaggio v ON g.id = v.idGita " +
                        "JOIN Classe c ON c.id = v.idClasse " +
                        "WHERE g.id = " +  idGita ;
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Gita gita = new Gita();
                Classe classe = new Classe();
                gita.setLuogo(rs.getString("luogo"));
                classe.setSezione(rs.getString("sezione"));

                listaGite.add(gita);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGite;
    }
}
