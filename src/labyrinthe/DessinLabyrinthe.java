package labyrinthe;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinLabyrinthe implements DessinJeu {
    Labyrinthe labyrinthe;
    public static final int TAILLE = 1;

    public DessinLabyrinthe(Labyrinthe labyrinthe){
        this.labyrinthe = labyrinthe;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        labyrinthe.construireMurs();
        for(int i = 0; i<this.labyrinthe.getMurs().length; i++){
            for(int j = 0; j<this.labyrinthe.getMurs().length; j++){
                System.out.print(labyrinthe.getMurs()[i][j]);
                if(this.labyrinthe.etreMur(i,j)){

                    g.setColor(Color.BLACK);
                    g.fillRect(i    , j, TAILLE, TAILLE);
                    g.dispose();
                }
            }
            System.out.println("");
        }
    }
}
