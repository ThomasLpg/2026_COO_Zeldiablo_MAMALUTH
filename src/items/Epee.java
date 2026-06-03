package items;

import Roles.Hero;

public class Epee extends Item{

    private int degats;

    public Epee(int x, int y, int d){
        super(x, y);
        this.degats = d;
    }

    public void affecter(Hero h){
       h.addDegats(this.degats);
    }

    public int getDegats(){return this.degats;}
}
