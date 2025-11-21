public class Joueur {

    // Attribut : nom du joueur (ex : "Sarah")
    private String nom;

    // Attribut : couleur du joueur (true = blanc, false = noir)
    private boolean couleur;

    // Constructeur : crée un joueur avec un nom et une couleur
    public Joueur(String nom, boolean couleur) {
        this.nom = nom;             // On stocke le nom du joueur
        this.couleur = couleur;     // On stocke la couleur du joueur (true = blanc)
    }

    // Méthode pour obtenir le nom du joueur
    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir la couleur du joueur (true = blanc, false = noir)
    public boolean getCouleur() {
        return couleur;
    }

    // Méthode pour afficher le joueur sous forme de texte
    public String toString() {
        // Si couleur est true, on écrit "blanc", sinon "noir"
        String texteCouleur = (couleur ? "blanc" : "noir");

        // Exemple : "Sarah (blanc)"
        return nom + " (" + texteCouleur + ")";
    }
}
