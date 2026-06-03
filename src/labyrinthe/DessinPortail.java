package labyrinthe;

import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import personnage.JeuPerso;
import personnage.Personnage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static labyrinthe.DessinLabyrinthe.TAILLE;

public class DessinPortail implements DessinJeu {
    private ArrayList<Portail> liste_portails;
    private Jeu jeu;

    public DessinPortail(JeuPerso j, ArrayList<Portail> listePortail){
        this.jeu = j;
        this.liste_portails = listePortail;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (Portail p : this.liste_portails){
            p.dessiner(image);
        }
        g.dispose();
    }
}
