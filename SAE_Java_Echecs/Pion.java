public class Pion extends Piece {

    // Constructeur : couleur = true pour blanc, false pour noir
    public Pion(boolean couleur) {
        super(couleur); // On appelle le constructeur de la classe mère
    }

    // Vérifie si le déplacement vers une case est valide
    public boolean deplacementValide(CaseEchiquier destination) {
        // Case de départ
        CaseEchiquier origine = this.getPosition();

        // Coordonnées de départ
        int ligneDepart = origine.getLigne();
        int colDepart = origine.getColonne();

        // Coordonnées d’arrivée
        int ligneArrivee = destination.getLigne();
        int colArrivee = destination.getColonne();

        // Calcul des différences
        int diffLigne = ligneArrivee - ligneDepart;
        int diffColonne = colArrivee - colDepart;

        // Si pion blanc (il monte vers le haut = lignes +)
        if (this.getCouleur()) {
            // PRISE : une case en diagonale +1/-1, si une pièce ennemie est présente
            if (diffLigne == 1 && Math.abs(diffColonne) == 1) {
                return destination.estOccupee() && destination.getPiece().getCouleur() != this.getCouleur();
            }
            // AVANCE simple : 1 case devant, même colonne, case vide
            if (diffLigne == 1 && diffColonne == 0 && !destination.estOccupee()) {
                return true;
            }
            // AVANCE double depuis ligne 1 : 2 cases devant, même colonne, les deux cases doivent être vides
            if (ligneDepart == 1 && diffLigne == 2 && diffColonne == 0) {
                return true; // la vérification d'obstacles sera faite dans Partie
            }
        }
        // Si pion noir (il descend = lignes -)
        else {
            // PRISE diagonale vers le bas
            if (diffLigne == -1 && Math.abs(diffColonne) == 1) {
                return destination.estOccupee() && destination.getPiece().getCouleur() != this.getCouleur();
            }
            // AVANCE simple
            if (diffLigne == -1 && diffColonne == 0 && !destination.estOccupee()) {
                return true;
            }
            // AVANCE double depuis ligne 6
            if (ligneDepart == 6 && diffLigne == -2 && diffColonne == 0) {
                return true;
            }
        }

        // Tout le reste est interdit
        return false;
    }

    //Renvoie le symbole représentant le pion, en respectant les conventions UML.
    //'P' pour une tour blanche, 'p' pour une tour noire.
    public char getsymbole() {
        return this.getCouleur() ? 'P' : 'p';
    }
    public String toString() {
        return String.valueOf(getsymbole());
    }
}
