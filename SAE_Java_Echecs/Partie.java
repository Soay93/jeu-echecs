import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie { // Classe Partie : elle gère toute la partie d'échecs.

    private Joueur joueur1;             // Le joueur blanc
    private Joueur joueur2;             // Le joueur noir
    private Joueur joueurCourant;       // Le joueur à qui c'est le tour
    private Echiquier echiquier;        // L’échiquier du jeu
    private List<String> historiqueCoups; // Liste des coups joués
    private boolean partieTerminee;     // Pour savoir si la partie est finie
    private Joueur vainqueur;           // Le joueur gagnant (null si partie nulle)

    // Constructeur : initialise tout
    public Partie(String nomJoueur1, String nomJoueur2) {
        this.joueur1 = new Joueur(nomJoueur1, true);    // blanc
        this.joueur2 = new Joueur(nomJoueur2, false);   // noir
        this.joueurCourant = joueur1;                   // Le blanc commence
        this.echiquier = new Echiquier();               // Création de l’échiquier
        this.historiqueCoups = new ArrayList<>();       // Liste vide au début
        this.partieTerminee = false;
        this.vainqueur = null;
        echiquier.initialiserEchiquier();               // On place les pièces de départ
    }

    // Méthode principale : lance et gère la partie
    public void demarrerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (!partieTerminee) {
            afficherPosition();
            afficherHistoriqueCoups();

            String coup = saisirCoup(scanner);

            while (!validerCoup(coup)) {
                System.out.println("Coup invalide. Réessayez.");
                coup = saisirCoup(scanner);
            }

            jouerCoup(coup);
            partieTerminee = verifierFinPartie();

            if (!partieTerminee) {
                changerJoueur();
            }
        }

        proclamerResultat();
        scanner.close();
    }

    // Affiche l’échiquier
    public void afficherPosition() {
        echiquier.afficherEchiquier();
    }

    // Affiche l’historique des coups
    public void afficherHistoriqueCoups() {
        System.out.println("Coups joués :");
        for (String coup : historiqueCoups) {
            System.out.println(coup);
        }
    }

    // Demande au joueur d’écrire un coup (ex: "e2 e4")
    public String saisirCoup(Scanner scanner) {
        System.out.print(joueurCourant.getNom() + ", entrez votre coup : ");
        return scanner.nextLine();
    }

    // Vérifie si un coup est valide
    public boolean validerCoup(String coup) {
        String[] parties = coup.trim().split(" ");

        if (parties.length != 2) {
            return false;
        }

        String depart = parties[0];
        String arrivee = parties[1];

        CaseEchiquier caseDepart = echiquier.getCase(depart);
        CaseEchiquier caseArrivee = echiquier.getCase(arrivee);

        if (caseDepart == null || caseArrivee == null) {
            return false;
        }

        Piece piece = caseDepart.getPiece();

        if (piece == null) {
            return false;
        }

        if (piece.getCouleur() != joueurCourant.getCouleur()) {
            return false;
        }

        piece.setPosition(caseDepart);

        if (!piece.deplacementValide(caseArrivee)) {
            return false;
        }

        if (caseArrivee.estOccupee() && caseArrivee.getPiece().getCouleur() == piece.getCouleur()) {
            return false;
        }

        return true;
    }

    // Applique le coup : déplace la pièce, capture si besoin
    public boolean jouerCoup(String coup) {
        String[] parties = coup.trim().split(" ");
        String depart = parties[0];
        String arrivee = parties[1];

        CaseEchiquier caseDepart = echiquier.getCase(depart);
        CaseEchiquier caseArrivee = echiquier.getCase(arrivee);
        Piece piece = caseDepart.getPiece();

        historiqueCoups.add(coup); // on ajoute le coup à la liste

        // On enlève la pièce de sa case de départ
        caseDepart.setPiece(null);

        // S'il y a une pièce à l'arrivée, elle est capturée
        if (caseArrivee.estOccupee()) {
            System.out.println("Pièce capturée : " + caseArrivee.getPiece().toString());
        }

        // On place la pièce sur la nouvelle case
        caseArrivee.setPiece(piece);
        piece.setPosition(caseArrivee);

        return true;
    }

    // Change le joueur courant
    public void changerJoueur() {
        if (joueurCourant == joueur1) {
            joueurCourant = joueur2;
        } else {
            joueurCourant = joueur1;
        }
    }

    // Vérifie si la partie est finie (mat ou pat)
    public boolean verifierFinPartie() {
        if (estMat(joueurCourant.getCouleur())) {
            partieTerminee = true;
            vainqueur = (joueurCourant == joueur1) ? joueur2 : joueur1;
            return true;
        }
        if (estPat(joueurCourant.getCouleur())) {
            partieTerminee = true;
            vainqueur = null;
            return true;
        }
        return false;
    }

    // Vérifie si le roi du joueur est en échec (à faire plus tard)
    public boolean estEchec(boolean couleur) {
        return false;
    }

    // Vérifie si le roi est mat (à faire plus tard)
    public boolean estMat(boolean couleur) {
        return false;
    }

    // Vérifie s’il y a pat (égalité) (à faire plus tard)
    public boolean estPat(boolean couleur) {
        return false;
    }

    // Affiche le résultat final
    public void proclamerResultat() {
        if (vainqueur == null) {
            System.out.println("Partie nulle !");
        } else {
            System.out.println("Victoire de " + vainqueur.getNom() + " !");
        }
    }
}
