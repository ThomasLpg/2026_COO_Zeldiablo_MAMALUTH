package items;

import Roles.Hero;

public class Epee extends Item{

    private int degats;

    /**
     *  Constructeur de l'item épée
     * @param x
     * @param y
     * @param d
     */
    public Epee(int x, int y, int d){
        super(x, y);
        this.degats = d;
    }

    /**
     * Ajoute aux dégats de base du héros les dégats de l'épée
     * @param h le héro
     */
    public void affecter(Hero h){
       h.addDegats(this.degats);
    }

    /**
     * Getter des dégats l'épée
     * @return int dégats
     */
    public int getDegats(){return this.degats;}
}
