public class Dame extends Piece {

    // Constructeur UML : Dame(boolean couleur, int colonne, int rangee)
    public Dame(boolean couleur, int colonne, int rangee) {
        super(couleur);// Appel au constructeur de la classe mère
    }

    //Redéfinition de la méthode abstraite deplacementValide().
    //La dame combine les déplacements de la tour ET du fou :
    //horizontal/vertical (comme la tour),
    //ou diagonal (comme le fou).
    public boolean deplacementValide(CaseEchiquier destination) {
        CaseEchiquier origine = this.getPosition();
        
        int diffLigne = destination.getLigne() - origine.getLigne();
        int diffColonne = destination.getColonne() - origine.getColonne();
        
        // Déplacement comme une Tour (même ligne OU même colonne)
        boolean commeTour = (diffLigne == 0) || (diffColonne == 0);
        
        // Déplacement comme un Fou (diagonale : |diffLigne| == |diffColonne|)
        boolean commeFou = (diffLigne == diffColonne) || (diffLigne == -diffColonne);
        
        return commeTour || commeFou;
    }



    // La dame est la pièce la plus puissante après le roi, elle vaut 9 points.
    public int getValour() {
        return 9;
    }

    //Renvoie le symbole représentant la dame, en respectant les conventions UML.
    //'D' pour une tour blanche, 'd' pour une tour noire.
    public char getsymbole() {
        if (this.getCouleur()) {
            return 'D';
        } else {
            return 'd';
        }
    }
    
    public String toString() {
        return String.valueOf(getsymbole());
    }
}
