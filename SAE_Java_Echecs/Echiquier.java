public class Echiquier {

    private CaseEchiquier[][] cases;                       // Déclaration d’un tableau 2D de cases : 8 lignes × 8 colonnes


                                                 // Constructeur : il crée l’échiquier vide (64 cases)
    public Echiquier() {
        cases = new CaseEchiquier[8][8];                                           // Création du tableau 8x8

        for (int ligne = 0; ligne < 8; ligne++) {                         // Parcours de chaque ligne de 0 à 7
            for (int colonne = 0; colonne < 8; colonne++) {               // Parcours de chaque colonne de 0 à 7
                cases[ligne][colonne] = new CaseEchiquier(ligne, colonne);         // Création d’une case vide à la position [ligne][colonne]

            }
        }
    }

    public void initialiserEchiquier() {// Méthode pour placer les pièces au début du jeu
        //Pion
        for (int col = 0; col < 8; col++) {                               // Ajout des 8 pions blancs à la ligne 1 (index 1)
            cases[1][col].setPiece(new Pion(true));                       // On place un nouveau pion blanc (true)
        }

        for (int col = 0; col < 8; col++) {                               // Ajout des 8 pions noirs à la ligne 6 (index 6)
            cases[6][col].setPiece(new Pion(false));                      // On place un nouveau pion noir (false)
        }

        //Tour
        cases[0][0].setPiece(new Tour(false, 0, 0));   
        cases[0][7].setPiece(new Tour(false, 7, 0));        
        cases[7][0].setPiece(new Tour(true,  0, 7));       
        cases[7][7].setPiece(new Tour(true,  7, 7));


        //Cavalier
        cases[0][1].setPiece(new Cavalier(false, 1, 0)); // c noir en b8
        cases[0][6].setPiece(new Cavalier(false, 6, 0)); // c noir en g8
        cases[7][1].setPiece(new Cavalier(true,  1, 7));  // C blanc en b1
        cases[7][6].setPiece(new Cavalier(true,  6, 7));  // C blanc en g1



        //Fou
        cases[0][2].setPiece(new Fou(false, 2, 0));  // Fou noir c1
        cases[0][5].setPiece(new Fou(false, 5, 0));  // Fou noir f1
        cases[7][2].setPiece(new Fou(true,  2, 7));   // Fou blanc c8
        cases[7][5].setPiece(new Fou(true,  5, 7));   // Fou blanc f8

        //Dame
        cases[0][3].setPiece(new Dame(false, 3, 0)); // Dame noire d1
        cases[7][3].setPiece(new Dame(true,  3, 7));  // Dame blanche d8

        //Roi
        cases[0][4].setPiece(new Roi(false, 4, 0));  // Roi noir e1
        cases[7][4].setPiece(new Roi(true,  4, 7));   // Roi blanc e8



        // On ne place pas encore les autres pièces pour l’instant
    }

    public void afficherEchiquier() {                                     // Méthode pour afficher l’échiquier dans la console

        for (int ligne = 7; ligne >= 0; ligne--) {                        // On commence par afficher la dernière ligne (ligne 7 → 8 affichée)
            System.out.print((ligne + 1) + " ");                          // Affiche le numéro de la ligne (de 8 à 1)

            for (int col = 0; col < 8; col++) {                           // Affiche toutes les colonnes de cette ligne
                
                System.out.print(cases[ligne][col].toString() + " ");     // Affiche le contenu de la case (".", ou symbole de pièce)
            }

            System.out.println();                                         // Retour à la ligne
        }

        System.out.println("  a b c d e f g h");                          // Affiche les lettres des colonnes (a à h)
    }

    public CaseEchiquier getCase(int ligne, int colonne) {                         // Méthode pour récupérer une case avec ses coordonnées entières

        if (ligne < 0 || ligne > 7 || colonne < 0 || colonne > 7) {       // Si la case est en dehors de l’échiquier, on retourne null
            return null;
        }

        return cases[ligne][colonne];                                     // Sinon on retourne la case demandée
    }

    public CaseEchiquier getCase(String pos) {                                     // Méthode pour récupérer une case à partir d’un texte comme "e2"
        
        if (pos.length() != 2) return null;                               // Si le texte n’a pas 2 caractères, c’est invalide
        char lettreColonne = pos.charAt(0);                               // Récupère la lettre de colonne (ex: 'e')
        char chiffreLigne = pos.charAt(1);                                // Récupère le chiffre de la ligne (ex: '2')

        int colonne = lettreColonne - 'a';                                // Convertit la lettre en numéro de colonne (ex: 'a' → 0, 'h' → 7)
        int ligne = chiffreLigne - '1';                                   // Convertit le chiffre en numéro de ligne (ex: '1' → 0, '8' → 7)

        return getCase(ligne, colonne);                                   // Retourne la case correspondante

    }
}
