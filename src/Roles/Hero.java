package Roles;
import personnage.Personnage;


public class Hero extends Personnage {
    /**
     * Constructeur d'un Hero
     * @param x coordonnée x du hero
     * @param y coordonnée y du hero
     * @param n nom du hero
     * @param p point de vie du hero
     * @param d dégats que le hero fait
     */
    public Hero(int x, int y,String n, int p, int d){
        super(x, y, n, p, d);
    }
}
