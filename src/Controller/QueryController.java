package Controller;
import Service.QueryService;
import Entity.*;
import java.util.List;
import java.util.Scanner;

public class QueryController {
    QueryService queryService = new QueryService();
    GitaController gitaController = new GitaController();
    DocenteController docenteController = new DocenteController();
    ClasseController classeController = new ClasseController();
    Scanner scanner = new Scanner(System.in);

    public void query1()
    {
        System.out.println("SCEGLI LA GITA DI CUI VEDERE LE CLASSI CHE VI PARTECIPANO");
        gitaController.readGita();
        int idGita = scanner.nextInt();
        //prendiamo il viaggio specifico
        List<Viaggio> listaViaggi = queryService.query1(idGita);
        for (int i=0; i<listaViaggi.size(); i++)
        {
            //prendiamo il viaggio
            Viaggio viaggio = listaViaggi.get(i);
            //prendiamo la gita
            List<Gita> listaGite = viaggio.getGite();
            Gita gita = listaGite.get(i);
            //prendiamo la classe
            List<Classe> listaClassi = viaggio.getClassi();
            Classe classe = listaClassi.get(i);
            //stampiamo
            System.out.println(classe.getSezione() + " " + gita.getLuogo());
        }
    }

    public void query2()
    {
        System.out.println("SCEGLI IL DOCENTE DI CUI VISIONARE LE GITE");
        docenteController.readDocente();
        int idDocente = scanner.nextInt();
        List<Viaggio> listaViaggi = queryService.query2(idDocente);
        for (int i=0; i<listaViaggi.size(); i++)
        {
            Viaggio viaggio = listaViaggi.get(i);
            List<Docente>listaDocenti=viaggio.getDocenti();
            Docente docente = listaDocenti.get(i);
            List<Gita>listaGite=viaggio.getGite();
            Gita gita = listaGite.get(i);
            System.out.println(docente.getNome() + " " + docente.getCognome() + " " + gita.getLuogo() + " " + gita.getDataInizio() + " " + gita.getDataFine());
        }
    }

    public void query3()
    {
        System.out.println("LE CLASSI E I SUO I COORDINATORI SONO:");
        List <Classe> listaClassi = queryService.query3();
        for (int i=0; i<listaClassi.size(); i++)
        {
            Classe classe = listaClassi.get(i);
            Docente docente = classe.getDocente();
            System.out.println(classe.getSezione() + " " + docente.getNome() + " " + docente.getCognome());
        }
    }

    public void query4()
    {
        System.out.println("LISTA DI TUTTI I VIAGGI");
        List <Viaggio> listaViaggi = queryService.query4();
        for (int i=0; i<listaViaggi.size(); i++)
        {
            Viaggio viaggio = listaViaggi.get(i);
            //prendiamo la gita
            List<Gita>listaGite=viaggio.getGite();
            Gita gita = listaGite.get(i);
            //prendiamo la classe
            List<Classe> listaClassi = viaggio.getClassi();
            Classe classe = listaClassi.get(i);
            //prendiamo il docente
            List<Docente> listaDocenti=viaggio.getDocenti();
            Docente docente = listaDocenti.get(i);
            //stampiamo tutto
            System.out.println(gita.getLuogo() + " " + classe.getSezione() + " " + gita.getDataInizio() + " " + gita.getDataFine() + " " + docente.getCognome());
        }
    }


}
