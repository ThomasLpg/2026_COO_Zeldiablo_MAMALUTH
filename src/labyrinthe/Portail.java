package labyrinthe;
import moteurJeu.DessinJeu;
import java.awt.*;
import java.awt.image.BufferedImage;
import static labyrinthe.DessinLabyrinthe.TAILLE;

public class Portail implements DessinJeu {
    int x, y;
    String niveauDestination;

    /**
     * Constructeur d'un portail (pour changer de niveau)
     * @param abs coordonnée x du portail (case où est le portail)
     * @param ord coordonnée y du portail (case où est le portail)
     * @param destination niveau de destination
     */
    public Portail(int abs, int ord, String destination){
        this.x = abs;
        this.y = ord;
        this.niveauDestination = destination;
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

    /**
     * Getter de la destination du portail
     * @return destination (niveau)
     */
    public String getDestination() {
        return niveauDestination;
    }
}
