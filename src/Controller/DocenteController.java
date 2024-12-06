package Controller;
import java.util.Scanner;
import Service.DocenteService;
import java.util.List;
import Entity.Docente;

public class DocenteController {
    Scanner scanner=new Scanner(System.in);
    DocenteService docenteService = new DocenteService();

    public void createDocente()
    {
        System.out.println("INSERSCI IL NOME DEL DOCENTE");
        String nome = scanner.nextLine();
        System.out.println("INSERSCI IL COGNOME DEL DOCENTE");
        String cognome = scanner.nextLine();

        docenteService.createDocente(nome,cognome);
    }

    public void updateDocente()
    {
        System.out.println("SELEZIONA IL DOCENTE DA MODIFICARE DALL'ID");
        readDocente();
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("SELEZIONA IL NUOVO NOME DEL DOCENTE");
        String nome = scanner.nextLine();
        System.out.println("SELEZIONA IL NUOVO COGNOME DEL DOCENTE");
        String cognome = scanner.nextLine();

        docenteService.updateDocente(id,nome,cognome);
    }

    public void readDocente()
    {
        List<Docente> listaDocenti = docenteService.readDocente();
        for (Docente docente : listaDocenti)
        {
            System.out.println(docente.getId()+ " " + docente.getNome() + " " + docente.getCognome());
        }
    }

    public void deleteDocente()
    {
        System.out.println("SELEZIONA IL DOCENTE DA ELIMINARE DALL'ID");
        readDocente();
        int id = scanner.nextInt();
        scanner.nextLine();

        docenteService.deleteDocente(id);
    }
}
