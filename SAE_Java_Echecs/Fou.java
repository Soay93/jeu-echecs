public class Fou extends Piece {
    
    // Constructeur UML (boolean couleur, int colonne, int rangee)
    public Fou(boolean couleur, int colonne, int rangee) {
        super(couleur);// On appelle le constructeur de la classe mère
    }

    // Implémentation de la méthode abstraite deplacementValide().
    //Le fou se déplace uniquement en diagonale, donc :
    //Le déplacement est valide si la différence de ligne == différence de colonne.
    public boolean deplacementValide(CaseEchiquier destination) {
        CaseEchiquier origine = this.getPosition();
        int diffLigne = destination.getLigne() - origine.getLigne();
        int diffColonne = destination.getColonne() - origine.getColonne();
        return (diffLigne == diffColonne) || (diffLigne == -diffColonne);
    }

    //Le fou vaut 3 points.
    public int getValeur() {
        return 3;
    }

    //Renvoie le symbole représentant le fou, en respectant les conventions UML.
    //'F' pour une tour blanche, 'f' pour une tour noire.
    public char getsymbole() {
        if (this.getCouleur()) {
            return 'F';
        } else {
            return 'f';
        }
    }
    
    public String toString() {
        return String.valueOf(getsymbole());
    }
}