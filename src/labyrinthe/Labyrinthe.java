package labyrinthe;



public class Labyrinthe {
    private boolean[][] murs;

    public Labyrinthe(int x, int y){
        this.murs = new boolean[y][x];
    }


    public boolean etreMur(int x, int y){
        return this.murs[y][x];
    }

    public boolean[][] getMurs(){ return this.murs;}

}
