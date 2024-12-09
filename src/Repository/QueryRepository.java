package Repository;

import Config.DbConnection;
import Entity.*;

import java.sql.*;
import java.util.ArrayList;

public class QueryRepository {

    public ArrayList<Viaggio> query1(int idGita) {
        ArrayList<Viaggio> listaGite = new ArrayList<>();
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
                Viaggio viaggio = new Viaggio();
                Gita gita = new Gita();
                Classe classe = new Classe();
                gita.setLuogo(rs.getString("luogo"));
                classe.setSezione(rs.getString("sezione"));

                viaggio.addGita(gita);
                viaggio.addClasse(classe);
                listaGite.add(viaggio);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGite;
    }

    public ArrayList<Viaggio> query2(int idDocente) {
        ArrayList<Viaggio> listaGite = new ArrayList<>();
        String query =
                "SELECT d.nome,d.cognome,g.luogo, g.dataInizio, g.dataFine " +
                        "FROM Docente d " +
                        "JOIN Gita g ON d.id = g.idDocente " +
                        "WHERE d.id= '"+ idDocente +"';";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Viaggio viaggio = new Viaggio();
                Docente docente = new Docente();
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));

                Gita gita = new Gita();
                gita.setLuogo(rs.getString("luogo"));
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {gita.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {gita.setDataFine(dataFine.toLocalDate());}

                viaggio.addGita(gita);
                viaggio.addDocente(docente);
                listaGite.add(viaggio);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGite;
    }

    public ArrayList<Classe> query3() {
        ArrayList<Classe> listaClassi = new ArrayList<>();
        String query =
                "SELECT c.sezione, d.nome, d.cognome " +
                        "FROM Classe c " +
                        "JOIN Docente d ON d.id=c.idDocente";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Classe classe = new Classe();
                classe.setSezione(rs.getString("sezione"));

                Docente docente = new Docente();
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                classe.setDocente(docente);
                listaClassi.add(classe);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaClassi;
    }

    public ArrayList<Viaggio> query4() {
        ArrayList<Viaggio> listaGite = new ArrayList<>();
        String query =
                "SELECT c.sezione, g.luogo, g.dataInizio, g.dataFine, d.cognome " +
                        "FROM Classe c " +
                        "JOIN Viaggio v ON v.idClasse=c.id " +
                        "JOIN Gita g ON g.id = v.idGita " +
                        "JOIN Docente d ON d.id=g.idDocente";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Viaggio viaggio = new Viaggio();
                //predniamo la classe
                Classe classe = new Classe();
                classe.setSezione(rs.getString("sezione"));
                //prendiamo la gita
                Gita gita = new Gita();
                gita.setLuogo(rs.getString("luogo"));
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {gita.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {gita.setDataFine(dataFine.toLocalDate());}
                //prendiamo il dcoente
                Docente docente = new Docente();
                docente.setCognome(rs.getString("cognome"));
                //aggiungiamo tutto
                viaggio.addGita(gita);
                viaggio.addClasse(classe);
                viaggio.addDocente(docente);
                //aggiungiamo il viaggio
                listaGite.add(viaggio);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGite;
    }


}
