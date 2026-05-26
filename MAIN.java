import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        ArrayList<Double> depenses = new ArrayList<>();
        ArrayList<String> nomsDepenses = new ArrayList<>();
        ArrayList<Double> revenu = new ArrayList<>();
        ArrayList<String> nomsRevenu = new ArrayList<>();

        int choix = 0;

        while (choix != 4) {

            System.out.println("\n--- Budget App ---");
            System.out.println("1. Ajouter une depense");
            System.out.println("2. Ajouter un revenu");
            System.out.println("3. Voir mon solde");
            System.out.println("4. Quitter");
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
                nomsDepenses.add(nom);

            } else if (choix == 2) {

                double montant = 0;
                String nom;
                System.out.println("\n--- Ajouter un revenu ---");
                System.out.print("Quel nom voulez-vous donner a ce revenu? : ");
                nom = scanner.nextLine();
                System.out.print("Quel montant voulez-vous ajouter au revenu? : ");
                montant = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Revenu ajouté : " + nom + " - " + montant + "$");
                revenu.add(montant);
                nomsRevenu.add(nom);

            } else if (choix == 3) {

                double sommeDepenses = 0;
                double sommeRevenus = 0;
                double solde = 0;
                System.out.println("\n--- Mes depenses ---");

                for (int i = 0; i < depenses.size(); i++) {
                    int numero = i + 1;
                    sommeDepenses += depenses.get(i);
                    System.out.println(numero + ". " + nomsDepenses.get(i) + " - " + depenses.get(i) + "$");
                }

                System.out.println("--------------------");
                System.out.println("\n--- Mes revenus ---");

                for (int i = 0; i < revenu.size(); i++) {
                    int numero = i + 1;
                    sommeRevenus += revenu.get(i);
                    System.out.println(numero + ". " + nomsRevenu.get(i) + " - " + revenu.get(i) + "$");
                }

                System.out.println("--------------------");
                solde = sommeRevenus - sommeDepenses;
                System.out.println("Total Dépense : " + sommeDepenses + "$");
                System.out.println("Total Revenus : " + sommeRevenus + "$");
                System.out.println("Solde : " + solde + "$");
            }

        }

        System.out.println("A bientot!");
    }
}
