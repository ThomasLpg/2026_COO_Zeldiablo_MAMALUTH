package items;

import Roles.Hero;

public class Piege extends Item{

    private int degats;

    public Piege(int x, int y, int d){
        super(x, y);
        this.degats = d;
    }

    public void affecter(Hero h){
        h.subirDegats(this.degats);
    }

    public int getDegats(){return this.degats;}
}
