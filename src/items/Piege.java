package items;

import Roles.Hero;

public class Piege extends Item{

    private int degats;

    /**
     * Constructeur d'un piège
     * @param x coordonnée x du piège
     * @param y coordonnée y du piège
     * @param d dégats causés par le piège
     */
    public Piege(int x, int y, int d){
        super(x, y);
        this.degats = d;
    }

    /**
     * Permet d'affecter les dégats du piège à un héro
     * @param h
     */
    public void affecter(Hero h){
        h.subirDegats(this.degats);
    }

    /**
     * Getter du nombre de dégats causés par un piège
     * @return
     */
    public int getDegats(){return this.degats;}
}
