package personnage;

import moteurJeu.DessinJeu;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu {

    public static final int TAILLE = 20;
    JeuPerso jeu;

    public DessinPerso(JeuPerso j){

        this.jeu = j;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();


        Personnage perso = jeu.getPj();
        int persoX = (perso.getX() - 1) * TAILLE;
        int persoY = (perso.getY() + 1) * TAILLE;
        g.fillArc(persoX, persoY, TAILLE, TAILLE, 0, 360);
        g.setColor(Color.BLUE);
        g.dispose();
    }
}
