import Controller.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClasseController classeController = new ClasseController();
        DocenteController docenteController = new DocenteController();
        GitaController gitaController = new GitaController();
        ViaggioController viaggioController = new ViaggioController();
        QueryController queryController = new QueryController();
        int choice1;
        int choice2;

        do
        {
            System.out.println("+++MENU INIZIALE+++");
            System.out.println("Scegli cosa fare digitando il numero");
            System.out.println("1) CLASSE");
            System.out.println("2) DOCENTE");
            System.out.println("3) GITA SCOLASTICA");
            System.out.println("4) VIAGGIO");
            System.out.println("5) QUERY");
            System.out.println("9) ESCI");
            choice1 = scanner.nextInt();
            if (choice1 == 1)
            {
                do
                {
                    System.out.println("---CLASSE---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        classeController.createClasse();
                    }
                    else if (choice2 == 2)
                    {
                        classeController.updateClasse();
                    }
                    else if (choice2 == 3)
                    {
                        classeController.readClasse();
                    }
                    else if (choice2 == 4)
                    {
                        classeController.deleteClasse();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==1);
            }
            else if (choice1 == 2)
            {
                do
                {
                    System.out.println("---DOCENTE---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        docenteController.createDocente();
                    }
                    else if (choice2 == 2)
                    {
                        docenteController.updateDocente();
                    }
                    else if (choice2 == 3)
                    {
                        docenteController.readDocente();
                    }
                    else if (choice2 == 4)
                    {
                        docenteController.deleteDocente();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==2);
            }
            else if (choice1 == 3)
            {
                do
                {
                    System.out.println("---GITA SCOLASTICA--");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        gitaController.createGita();
                    }
                    else if (choice2 == 2)
                    {
                        gitaController.updateGita();
                    }
                    else if (choice2 == 3)
                    {
                        gitaController.readGita();
                    }
                    else if (choice2 == 4)
                    {
                        gitaController.deleteGita();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==3);
            }
            else if (choice1 == 4)
            {
                do
                {
                    System.out.println("---VIAGGIO--");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        viaggioController.createViaggio();
                    }
                    else if (choice2 == 2)
                    {
                        viaggioController.updateViaggio();
                    }
                    else if (choice2 == 3)
                    {
                        viaggioController.readViaggio();
                    }
                    else if (choice2 == 4)
                    {
                        viaggioController.deleteViaggio();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==4);
            }
            else if (choice1 == 5)
            {
                do
                {
                    System.out.println("---QUERY---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) TUTTE LE CLASSI CHE VANNO IN UN LUOGO");
                    System.out.println("2) TUTTI I VIAGGI TENUTI DA UN DOCENTE");
                    System.out.println("3) TUTTE LEE CLASSI E I RISPETTIVI COORDINATORI");
                    System.out.println("4) TUTTI I VIAGGI");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        queryController.query1();
                    }
                    else if (choice2 == 2)
                    {
                        queryController.query2();
                    }
                    else if (choice2 == 3)
                    {
                        queryController.query3();
                    }
                    else if (choice2 == 4)
                    {
                        queryController.query4();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==4);
            }
        }
        while (choice1 != 9);
        scanner.close();
    }
}