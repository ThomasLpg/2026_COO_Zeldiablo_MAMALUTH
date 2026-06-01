package personnage;

import arkanoidJeu.modele.Balle;
import arkanoidJeu.modele.Raquette;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class DessinPerso extends JeuPerso implements DessinJeu {

    public static final int TAILLE = 20;
    JeuPerso jeu;

    public DessinPerso(JeuPerso j){
        this.jeu = j;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();

        g.setColor(Color.BLUE);
        Personnage perso = jeu.getPj();
        int persoX = (perso.getX() - 1) * TAILLE;
        int persoY = (perso.getY() + 1) * TAILLE;
        g.fillOval(persoX, persoY, 3 * TAILLE, TAILLE / 4);

        g.dispose();
    }
}
