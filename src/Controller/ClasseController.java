package Controller;
import java.util.Scanner;

import Entity.Classe;
import Service.ClasseService;
import java.util.List;

public class ClasseController {
    Scanner scanner = new Scanner(System.in);
    DocenteController docenteController = new DocenteController();
    ClasseService classeService = new ClasseService();

    public void createClasse()
    {
        System.out.println("DIGITA LA SEZIONE");
        String sezione = scanner.nextLine();
        System.out.println("DIGITA L'ID CORRISPONDENTE DEL DOCENTE COORDINATORE DALLA LISTA");
        docenteController.readDocente();
        int idDocente= scanner.nextInt();
        classeService.createClasse(sezione,idDocente);
    }

    public void updateClasse()
    {
        System.out.println("DIGITA L'ID DELLA CLASSE DA MODIFICARE");
        readClasse();
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DIGITA LA NUOVA SEZIONE");
        String sezione = scanner.nextLine();
        System.out.println("DIGITA L'ID CORRISPONDENTE DEL NUOVO DOCENTE COORDINATORE DALLA LISTA");
        docenteController.readDocente();
        int idDocente= scanner.nextInt();

        classeService.updateClasse(id,sezione,idDocente);
    }

    public void readClasse()
    {
        List <Classe> listaClassi = classeService.readClasse();
        for (Classe classe: listaClassi)
        {
            System.out.println(classe.getId() + " " + classe.getSezione() + " " + classe.getIdDocente());
        }
    }

    public void deleteClasse()
    {
        System.out.println("DIGITA L'ID DELLA CLASSE DA ELIMINARE");
        readClasse();
        int id = scanner.nextInt();
        scanner.nextLine();
        classeService.deleteClasse(id);
    }

}
