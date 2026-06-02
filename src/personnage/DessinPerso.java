package personnage;

import Roles.Hero;
import Roles.Monstre;
import moteurJeu.DessinJeu;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DessinPerso implements DessinJeu {
    ArrayList<Personnage> listePerso;

    public static final int TAILLE = 20;
    JeuPerso jeu;

    public DessinPerso(JeuPerso j, ArrayList<Personnage> listePerso){
        this.jeu = j;
        this.listePerso = listePerso;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (Personnage p : this.listePerso){
            if(p instanceof Hero){
                p.dessiner(g, Color.BLUE);
            } else if (p instanceof Monstre) {
                p.dessiner(g, Color.RED);
            }
        }

        g.dispose();


    }
}
