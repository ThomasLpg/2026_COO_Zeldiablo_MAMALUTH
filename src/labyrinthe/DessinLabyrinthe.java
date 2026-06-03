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
        for(int y = 0; y<this.labyrinthe.getMurs().length; y++){
            for(int x = 0; x<this.labyrinthe.getMurs()[y].length; x++){
                if(this.labyrinthe.etreMur(x,y)){
                    g.fillRect(x*TAILLE, y*TAILLE, TAILLE, TAILLE);
                }
            }

        }


        g.dispose();
    }
}
