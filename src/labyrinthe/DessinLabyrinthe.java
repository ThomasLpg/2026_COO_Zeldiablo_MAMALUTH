package labyrinthe;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinLabyrinthe implements DessinJeu {

    public static final int TAILLE = 1;
    Labyrinthe laby;

    public DessinLabyrinthe(Labyrinthe l){
        this.laby = l;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        for(int i = 0; i<laby.getMurs().length; i++){
            for(int j = 0; j<laby.getMurs().length; j++){
                boolean mur = laby.getMurs()[i][j];
                if(mur == true){
                    g.fillRect(i, j, TAILLE, TAILLE);
                    g.setColor(Color.GRAY);
                }
            }
        }
        g.dispose();
    }
}
