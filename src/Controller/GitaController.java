package Controller;
import Service.GitaService;
import Entity.Gita;
import java.util.List;

import java.time.LocalDate;
import java.util.Scanner;

public class GitaController {
    Scanner scanner = new Scanner(System.in);
    DocenteController docenteController = new DocenteController();
    GitaService gitaService = new GitaService();

    public void createGita()
    {
        System.out.println("SELEZIONA L'ID DEL DOCENTE DALLA LISTA");
        docenteController.readDocente();
        int idDocente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DIGITA IL LUOGO");
        String luogo = scanner.nextLine();
        System.out.println("DIGITA LA DATA DI INIZIO (yyyy-mm-dd");
        LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
        System.out.println("DIGITA LA DATA DI FINE (yyyy-mm-dd");
        LocalDate dataFine = LocalDate.parse(scanner.nextLine());

        gitaService.createGita(idDocente, luogo, dataInizio, dataFine);
    }

    public void updateGita()
    {
        System.out.println("SELEZIONA L'ID DELLA GITA DA MODIFICARE DALLA LISTA");
        readGita();
        int id = scanner.nextInt();
        System.out.println("SELEZIONA L'ID DEL NUOVO DOCENTE DALLA LISTA");
        docenteController.readDocente();
        int idDocente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DIGITA IL NUOVO LUOGO");
        String luogo = scanner.nextLine();
        System.out.println("DIGITA LA NUOVA DATA DI INIZIO (yyyy-mm-dd");
        LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
        System.out.println("DIGITA LA NUOVA DATA DI FINE (yyyy-mm-dd");
        LocalDate dataFine = LocalDate.parse(scanner.nextLine());

        gitaService.updateGita(id,idDocente, luogo, dataInizio, dataFine);
    }

    public void readGita()
    {
        List<Gita> listaGite = gitaService.readGita();
        for(Gita gita : listaGite)
        {
            System.out.println(gita.getId() + " " + gita.getLuogo() + " " + gita.getDataInizio() + " " + gita.getDataFine());
        }
    }

    public void deleteGita()
    {
        System.out.println("SELEZIONA L'ID DELLA GITA DA ELIMINARE DALLA LISTA");
        readGita();
        int id = scanner.nextInt();

        gitaService.deleteGita(id);
    }

}
