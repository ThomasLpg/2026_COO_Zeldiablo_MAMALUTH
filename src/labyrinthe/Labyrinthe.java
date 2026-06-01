package labyrinthe;

public class Labyrinthe {
    private boolean[][] murs;

    public Labyrinthe(int x, int y){
        this.murs = new boolean[y][x];
    }

    public void construireMurs(){
        for (int i = 0; i < this.murs.length; i++) {
            for (int j = 0; j < this.murs[i].length; j++) {
                if(i == 0){
                    this.murs[0][j] = true;
                } else if (i == this.murs.length -1) {
                    this.murs[this.murs.length -1 ][j] = true;
                } else{
                    this.murs[i][this.murs[i].length - 1] = true;
                    this.murs[i][0] = true;
                }
            }
        }
    }

    public boolean etreMur(int x, int y){
        return this.murs[y][x];
    }

    public boolean[][] getMurs(){ return this.murs;}

}
