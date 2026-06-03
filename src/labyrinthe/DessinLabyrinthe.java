package labyrinthe;

import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinLabyrinthe implements DessinJeu {
    Labyrinthe labyrinthe;
    public static final int TAILLE = 20;

    /**
     * Permet de definir le labyrinthe à dessiner
     * @param labyrinthe
     */
    public DessinLabyrinthe(Labyrinthe labyrinthe){
        this.labyrinthe = labyrinthe;
    }

    /**
     * Appelle la méthode dessiner de Dessins pour dessiner le labyrinthe
     * @param image
     */
    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        this.reset(g, this.labyrinthe.getMurs().length, this.labyrinthe.getMurs()[0].length);
        for(int y = 0; y<this.labyrinthe.getMurs().length; y++){
            for(int x = 0; x<this.labyrinthe.getMurs()[y].length; x++){
                if(this.labyrinthe.etreMur(x,y)){
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x*TAILLE, y*TAILLE, TAILLE, TAILLE);
            }

        }


        g.dispose();
    }

    public void reset(Graphics2D g, int x, int y){

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, TAILLE*y, TAILLE*x);
    }
}
