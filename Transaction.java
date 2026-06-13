public class Transaction {
    String nom;
    double montant;

    public Transaction(String nom, double montant) {
        this.nom = nom;
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public double getMontant() {
        return montant;
    }
}
