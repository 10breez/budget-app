import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        ArrayList<Double> depenses = new ArrayList<>();
        ArrayList<String> revenue = new ArrayList<>();

        int choix = 0;

        while (choix != 3) {
            System.out.println("\n--- Budget App ---");
            System.out.println("1. Ajouter une depense");
            System.out.println("2. Voir mon solde");
            System.out.println("3. Quitter");
            System.out.print("Ton choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                double montant = 0;
                String nom;
                System.out.println("\n--- Ajouter une depense ---");
                System.out.print("Quel nom voulez-vous donner a la depense? : ");
                nom = scanner.nextLine();
                System.out.print("Quel montant voulez-vous ajouter a la depense? : ");
                montant = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Dépense ajoutée : " + nom + " - " + montant + "$");
                depenses.add(montant);
                revenue.add(nom);
            } else if (choix == 2) {
                double somme = 0;
                System.out.println("\n--- Mes depenses ---");
                for (int i = 0; i < depenses.size(); i++) {
                    int numero = i + 1;
                    somme += depenses.get(i);
                    System.out.println(numero + ". " + revenue.get(i) + " - " + depenses.get(i) + "$");
                }
                System.out.println("--------------------");
                System.out.println("Total : " + somme + "$");
            }

        }

        System.out.println("A bientot!");
    }
}
