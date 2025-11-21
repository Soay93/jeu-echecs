public class Roi extends Piece {

    // Constructeur UML : Roi(boolean couleur, int colonne, int rangee)
    public Roi(boolean couleur, int colonne, int rangee) {
        super(couleur); // Appel du constructeur de la classe mère
    }

    //Implémentation de la méthode abstraite deplacementValide.
    //Le roi peut se déplacer d'une seule case dans n'importe quelle direction.
    public boolean deplacementValide(CaseEchiquier destination) {
        CaseEchiquier origine = this.getPosition();
        // Calcul des différences de position
        int diffLigne = destination.getLigne() - origine.getLigne();
        int diffColonne = destination.getColonne() - origine.getColonne();
        
        // Vérifie si le déplacement est d'au plus 1 case horizontalement ET verticalement
        return (diffLigne >= -1 && diffLigne <= 1) && 
               (diffColonne >= -1 && diffColonne <= 1);
    }
    




    // Le roi n'a pas de valeur chiffrée (car il est indispensable).
    public int getValeur() {
        return 0; // Le roi n'a pas de valeur en points
    }

    // Renvoie le symbole du roi selon sa couleur.
    //'R' pour un roi blanc, 'r' pour un roi noir.
    public char getsymbole() {
        if (this.getCouleur()) {
                return 'R';
            } else {
                return 'r';
            }
        }
        
        public String toString() {
            return String.valueOf(getsymbole());
        }
}