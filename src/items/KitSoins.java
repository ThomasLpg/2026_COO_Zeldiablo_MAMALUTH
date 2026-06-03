package items;

import Roles.Hero;

public class KitSoins extends Item{

    private int soins;

    public KitSoins(int x, int y, int s){
        super(x, y);
        this.soins = s;
    }

    public void affecter(Hero h){
        h.ajouterVie(this.soins);
    }

    public int getSoins(){return this.soins;}

}