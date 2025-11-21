public class CaseEchiquier {
    private int ligne;              // de 0 à 7 (rangée)
    private int colonne;            // de 0 à 7 (colonne)
    private Piece piece;            // la pièce sur cette case (null si vide)

    public CaseEchiquier(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.piece = null;          // aucune pièce au départ
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean estOccupee() {
        return piece != null;
    }

    public String toString() {
        if (piece == null) {
            return ".";
        } else {
            return piece.toString();
        }
    }
}
