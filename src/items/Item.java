package items;

import Roles.Hero;

import java.awt.*;

import static personnage.DessinPerso.TAILLE;

public abstract class Item {
    private int x;
    private int y;

    public Item(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public abstract void affecter(Hero h);

    public void dessiner(Graphics2D g, Color c){
        g.setColor(c);
        //ajouter le sprite
        g.fillOval(this.x*TAILLE, this.y*TAILLE, TAILLE, TAILLE);
    }
}
