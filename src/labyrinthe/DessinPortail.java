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


    /**
     * Permet de définir le portail à dessiner

     * @param listePortail
     */
    public DessinPortail(ArrayList<Portail> listePortail){
        this.liste_portails = listePortail;
    }

    /**
     * Appelle la méthode dessiner de Dessins pour dessiner le portail
     * @param image image sur laquelle dessiner
     */
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (Portail p : this.liste_portails){
            p.dessiner(image);
        }
        g.dispose();
    }
}
