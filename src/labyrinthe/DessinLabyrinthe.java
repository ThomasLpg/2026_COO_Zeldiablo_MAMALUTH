package labyrinthe;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinLabyrinthe implements DessinJeu {
    Labyrinthe labyrinthe;
    public static final int TAILLE = 20;

    public DessinLabyrinthe(Labyrinthe labyrinthe){
        this.labyrinthe = labyrinthe;
    }
    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        labyrinthe.construireMurs();
        for(int i = 0; i<this.labyrinthe.getMurs().length; i++){
            for(int j = 0; j<this.labyrinthe.getMurs()[i].length; j++){
                if(this.labyrinthe.etreMur(i,j)){
                    g.fillRect(i*TAILLE, j*TAILLE, TAILLE, TAILLE);
                }
            }

        }


        g.dispose();
    }
}
