import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

    public static void sauvegarder(ArrayList<Double> depenses, ArrayList<String> nomsDepenses, ArrayList<Double> revenu,
            ArrayList<String> nomsRevenu) {
        try {
            FileWriter fw1 = new FileWriter("depenses.txt");
            for (int i = 0; i < depenses.size(); i++) {
                fw1.write(nomsDepenses.get(i) + "," + depenses.get(i) + "\n");
            }
            fw1.close();
            FileWriter fw2 = new FileWriter("revenu.txt");
            for (int i = 0; i < revenu.size(); i++) {
                fw2.write(nomsRevenu.get(i) + "," + revenu.get(i) + "\n");
            }
            fw2.close();

        } catch (Exception e) {
            System.out.println("Erreur de sauvegarde!");
        }
    }

    public static void charger(ArrayList<Double> depenses, ArrayList<String> nomsDepenses, ArrayList<Double> revenu,
            ArrayList<String> nomsRevenu) {
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("depenses.txt"));
            String ligne1;
            while((ligne1 = br1.readLine()) != null){
                String[] parties = ligne1.split(",");
                if (parties.length >= 2) {
                    nomsDepenses.add(parties[0]);
                    depenses.add(Double.parseDouble(parties[1]));
                }
            }
            BufferedReader br2 = new BufferedReader(new FileReader("revenu.txt"));
            String ligne2;
            while((ligne2 = br2.readLine()) != null){
                String[] parties = ligne2.split(",");
                if (parties.length >= 2) {
                    nomsRevenu.add(parties[0]);
                    revenu.add(Double.parseDouble(parties[1]));
                }
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        ArrayList<Double> depenses = new ArrayList<>();
        ArrayList<String> nomsDepenses = new ArrayList<>();
        ArrayList<Double> revenu = new ArrayList<>();
        ArrayList<String> nomsRevenu = new ArrayList<>();

        int choix = 0;

        charger(depenses, nomsDepenses, revenu, nomsRevenu);

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
        sauvegarder(depenses, nomsDepenses, revenu, nomsRevenu);
        ;
    }
}
