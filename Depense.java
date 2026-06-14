public class Depense extends Transaction {

    public Depense(String nom, double montant) {
        super(nom, montant);
    }

    public double getMontantSigne() {
        return -getMontant();
    }
}
