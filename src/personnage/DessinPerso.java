package personnage;
import Roles.Hero;
import Roles.Monstre;
import moteurJeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DessinPerso implements DessinJeu {
    ArrayList<Personnage> listePerso;

    public static final int TAILLE = 20;
    JeuPerso jeu;
    private BufferedImage imgHero;
    private BufferedImage imgMonstre;

    /**
     * Permet de définir le personnage à dessiner
     * @param j
     * @param listePerso
     */
    public DessinPerso(JeuPerso j, ArrayList<Personnage> listePerso){
        this.jeu = j;
        this.listePerso = listePerso;

        try{
            imgHero = ImageIO.read(new File("image/hero.png"));
            imgMonstre = ImageIO.read(new File("image/monstre.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dessine les personnages grace aux sprites donnés
     * @param image
     */
    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (Personnage p : this.listePerso){
            int x = p.getX() * TAILLE;
            int y = p.getY() * TAILLE;

            if (p instanceof Hero){
                g.drawImage(imgHero, x, y, TAILLE, TAILLE, null);

            } else if (p instanceof Monstre){
                g.drawImage(imgMonstre, x, y, TAILLE, TAILLE, null);
            }
        }
        g.dispose();
    }
}
