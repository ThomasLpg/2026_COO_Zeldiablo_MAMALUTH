package labyrinthe;
import moteurJeu.DessinJeu;
import java.awt.*;
import java.awt.image.BufferedImage;
import static labyrinthe.DessinLabyrinthe.TAILLE;

public class Portail implements DessinJeu {
    int x, y;
    String niveauDestination;
    int numNiveauDest;
    String orientation;

    /**
     * Constructeur d'un portail (pour changer de niveau)
     * @param abs coordonnée x du portail (case où est le portail)
     * @param ord coordonnée y du portail (case où est le portail)
     * @param destination niveau de destination
     */
    public Portail(int num, int abs, int ord, String destination, Labyrinthe lab){
        this.numNiveauDest = num;
        this.x = abs;
        this.y = ord;
        this.niveauDestination = destination;
        if (abs == 0) this.orientation = "gauche";
        if (abs == lab.getMurs()[0].length-1) this.orientation = "droite";
        if (ord == 0) this.orientation = "haut";
        if (ord == lab.getMurs().length-1) this.orientation = "bas";
    }

    /**
     * Redéfinition de la méthode dessiner de Dessins pour dessiner un portail
     * @param image image sur laquelle dessiner
     */
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(this.x*TAILLE, this.y*TAILLE, TAILLE, TAILLE);
        g.dispose();
    }

    /**
     * Getter de coordonnée x du portail
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter de coordonnée y du portail
     * @return y
     */
    public int getY() {
        return y;
    }

    public int getNumNiveauDest() {
        return numNiveauDest;
    }

    /**
     * Getter de l'orientation du portail
     * @return String haut / bas / gauche / droite
     */
    public String getOrientation(){
        return this.orientation;
    }

    /**
     * Getter de la destination du portail
     * @return destination (niveau)
     */
    public String getDestination() {
        return niveauDestination;
    }


}
