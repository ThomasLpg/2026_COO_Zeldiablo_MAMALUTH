package labyrinthe;



public class Labyrinthe {
    private boolean[][] murs;

    /**
     * Crée un mur à partir des coordonnées récuperées (coordonnées qui définissent le labyrinthe dans le txt)
     * @param x
     * @param y
     */
    public Labyrinthe(int x, int y){
        this.murs = new boolean[y][x];
    }

    /**
     * Vérifie si la coordonnée donnée est un mur ou non
     * @param x
     * @param y
     * @return un boolean True si c'est un mur, false sinon
     */
    public boolean etreMur(int x, int y){
        return this.murs[y][x];
    }

    /**
     * Getter d'un mur
     * @return un mur
     */
    public boolean[][] getMurs(){ return this.murs;}

}
