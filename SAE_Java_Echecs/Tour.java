public class Tour extends Piece {  // Bien hériter de Piece
    
    public Tour(boolean couleur, int colonne, int rangee) {
        super(couleur); // On appelle le constructeur de la classe mère
            }

    //Implémentation de la méthode abstraite deplacementValide définie dans Piece.
    //Une tour se déplace uniquement en ligne droite : horizontalement ou verticalement.
    public boolean deplacementValide(CaseEchiquier destination) {
        CaseEchiquier origine = this.getPosition();
        return origine.getLigne() == destination.getLigne() || 
               origine.getColonne() == destination.getColonne();
    }

    //Renvoie le symbole représentant la tour, en respectant les conventions UML.
    //'T' pour une tour blanche, 't' pour une tour noire.
    public char getsymbole() {
        if (this.getCouleur()) {
            return 'T';
        } else {
            return 't';
        }
    }
    
    public String toString() {
        return String.valueOf(getsymbole());
    }
}