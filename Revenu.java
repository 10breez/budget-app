public class Revenu extends Transaction {

    public Revenu(String nom, double montant) {
        super(nom, montant);
    }

    public double getMontantSigne(){
        return getMontant();
    }

}
