public class Main {
    public static void main(String[] args) {
        // Crée une nouvelle partie avec 2 joueurs
        Partie partie = new Partie("JoueurBlanc", "JoueurNoir");
        
        // Lance la partie
        partie.demarrerPartie();
    }
}