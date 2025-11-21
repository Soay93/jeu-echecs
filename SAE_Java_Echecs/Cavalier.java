public class Cavalier extends Piece {
    
    // Constructeur UML
    public Cavalier(boolean couleur, int colonne, int rangee) {
        super(couleur);// Appel du constructeur de la classe mère
    }




    //Implémentation de la méthode abstraite deplacementValide définie dans Piece.
    //Le Cavalier se déplace en L (2 cases dans une direction et 1 case perpendiculairement)
    public boolean deplacementValide(CaseEchiquier destination) {
        CaseEchiquier origine = this.getPosition();
        // Calcul des différences de position (peut être négatif)
        int diffLigne = destination.getLigne() - origine.getLigne();
        int diffColonne = destination.getColonne() - origine.getColonne();
        // Vérifie le déplacement en L (2-1 ou 1-2) en prenant en compte les deux sens
        if ((diffLigne == 2 && diffColonne == 1) || (diffLigne == 1 && diffColonne == 2)) {
            return true;
        }
        if ((diffLigne == -2 && diffColonne == -1) || (diffLigne == -1 && diffColonne == -2)) {
            return true;
        }
        if ((diffLigne == 2 && diffColonne == -1) || (diffLigne == 1 && diffColonne == -2)) {
            return true;
        }
        if ((diffLigne == -2 && diffColonne == 1) || (diffLigne == -1 && diffColonne == 2)) {
            return true;
        }
        
        return false; // Si aucun mouvement valide n'est détecté
    }

    



    // Retourne la valeur du cavalier aux echecs, donc 3.
    public int getValeur() {
        return 3;
    }


    //Renvoie le symbole représentant le cavalier, en respectant les conventions UML.
    //'C' pour une tour blanche, 'c' pour une tour noire.       
    public char getsymbole() {
        if (this.getCouleur()) {
            return 'C';
        } else {
            return 'c';
        }
    }

    public String toString() {
        return String.valueOf(getsymbole());
    }
}