package labyrinthe;
import moteurJeu.DessinJeu;



import java.awt.*;
import java.awt.image.BufferedImage;


import static labyrinthe.DessinLabyrinthe.TAILLE;

public class Portail implements DessinJeu {
    int x, y;
    String niveauDestination;
    String orientation;

    public Portail(int abs, int ord, String destination, String orientation){
        this.x = abs;
        this.y = ord;
        this.niveauDestination = destination;
        this.orientation = orientation;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(this.x*TAILLE, this.y*TAILLE, TAILLE, TAILLE);
        g.dispose();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOrientation(){
        return this.orientation;
    }

    public String getDestination() {
        return niveauDestination;
    }
}
