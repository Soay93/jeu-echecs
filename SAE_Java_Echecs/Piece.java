// Classe abstraite : elle définit le modèle commun à toutes les pièces (pion, tour, etc.)
public abstract class Piece {

    // Couleur de la pièce : true = blanc, false = noir
    protected boolean couleur;

    // La case actuelle où se trouve la pièce
    protected CaseEchiquier position;

    // Constructeur de la pièce, avec la couleur donnée
    public Piece(boolean couleur) {
        this.couleur = couleur;     // Initialise la couleur
        this.position = null;       // La position sera fixée plus tard
    }

    // Méthode pour obtenir la couleur de la pièce (true ou false)
    public boolean getCouleur() {
        return couleur;
    }

    // Change la case où se trouve la pièce
    public void setPosition(CaseEchiquier c) {
        this.position = c;
    }

    // Renvoie la case actuelle de la pièce
    public CaseEchiquier getPosition() {
        return position;
    }

    // Méthode abstraite à définir dans chaque sous-classe (pion, tour, ...)
    // Elle vérifie si le déplacement est correct selon le type de pièce
    public abstract boolean deplacementValide(CaseEchiquier destination);

    // Méthode pour afficher la pièce (ex: "P" pour pion blanc, "p" pour pion noir)
    public abstract String toString();
}
