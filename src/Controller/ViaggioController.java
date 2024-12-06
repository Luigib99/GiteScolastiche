package Controller;
import Service.ClasseService;
import Service.ViaggioService;
import Entity.Viaggio;

import java.util.List;
import java.util.Scanner;

public class ViaggioController {
    Scanner scanner = new Scanner(System.in);
    GitaController gitaController = new GitaController();
    ViaggioService viaggioService = new ViaggioService();
    ClasseController classeController = new ClasseController();
    public void createViaggio()
    {
        System.out.println("INSERISCI L'ID DELLA GITA DALLA LISTA");
        gitaController.readGita();
        int idGita = scanner.nextInt();
        System.out.println("INSERISCI L'ID DELLA CLASSE DALLA LISTA");
        classeController.readClasse();
        int idClasse = scanner.nextInt();

        viaggioService.createViaggio(idGita,idClasse);
    }

    public void updateViaggio()
    {
        System.out.println("INSERISCI L'ID DELVIAGGIO DA MODIFICARE DALLA LISTA");
        readViaggio();
        int id = scanner.nextInt();
        System.out.println("INSERISCI IL NUOVO ID DELLA GITA DALLA LISTA");
        gitaController.readGita();
        int idGita = scanner.nextInt();
        System.out.println("INSERISCI IL NUOVO ID DELLA CLASSE DALLA LISTA");
        classeController.readClasse();
        int idClasse = scanner.nextInt();

        viaggioService.updateViaggio(id,idGita,idClasse);
    }

    public void readViaggio()
    {
        List<Viaggio> listaViaggi = viaggioService.readViaggio();
        for (Viaggio viaggio : listaViaggi)
        {
            System.out.println(viaggio.getId()+ " "+ viaggio.getIdGita()+ " "+ viaggio.getIdClasse());
        }
    }

    public void deleteViaggio()
    {
        System.out.println("INSERISCI L'ID DEL VIAGGIO DA ELIMINARE DALLA LISTA");
        readViaggio();
        int id = scanner.nextInt();

        viaggioService.deleteViaggio(id);
    }
}
