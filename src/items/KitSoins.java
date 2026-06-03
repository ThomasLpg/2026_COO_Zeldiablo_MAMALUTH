package items;

import Roles.Hero;

public class KitSoins extends Item{

    private int soins;

    /**
     * Constructeur d'un item kit de soins
     * @param x coordonnée x de l'item
     * @param y coordonnée y de l'item
     * @param s vie donnée au hero
     */
    public KitSoins(int x, int y, int s){
        super(x, y);
        this.soins = s;
    }

    /**
     * Gère le comportement du kit de soins sur le personnage
     * @param h
     */
    public void affecter(Hero h){
        h.ajouterVie(this.soins);
    }

    /**
     * Getter du nombre de point de vie qu'un kit de soins va donner
     * @return
     */
    public int getSoins(){return this.soins;}

}