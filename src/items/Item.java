package items;

import Roles.Hero;

import java.awt.*;

import static personnage.DessinPerso.TAILLE;

public abstract class Item {
    private int x;
    private int y;

    /**
     * Constructeur d'un item
     * @param x
     * @param y
     */
    public Item(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getter coordonnée x de l'item
     * @return x
     */
    public int getX(){return this.x;}

    /**
     * Getter coordonnée y de l'item
     * @return y
     */
    public int getY(){return this.y;}

    /**
     * Gère le comportement de l'item
     * @param h
     */
    public abstract void affecter(Hero h);

    /**
     * Permet de dessiner un item
     * @param g
     * @param c
     */
    public void dessiner(Graphics2D g, Color c){
        g.setColor(c);
        //ajouter le sprite
        g.fillOval(this.x*TAILLE, this.y*TAILLE, TAILLE, TAILLE);
    }
}
