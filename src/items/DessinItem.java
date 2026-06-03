package items;

import moteurJeu.DessinJeu;
import personnage.JeuPerso;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DessinItem implements DessinJeu {
    ArrayList<Item> listeItems;
    JeuPerso jeu;

    /**
     * Permet de définir l'item à dessiner
     * @param j
     * @param items
     */
    public DessinItem(JeuPerso j, ArrayList<Item> items){
        this.jeu = j;
        this.listeItems = items;
    }

    /**
     * Appelle dessiner de Dessins pour dessiner l'item
     * @param image
     *            image sur laquelle dessiner
     */
    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        for(Item i: this.listeItems){
            if(i instanceof Piege){
                i.dessiner(g, Color.GRAY);
            } else if(i instanceof Epee){
                i.dessiner(g, Color.DARK_GRAY);
            } else if(i instanceof KitSoins){
                i.dessiner(g, Color.PINK);
            }
        }
        g.dispose();
    }

}
