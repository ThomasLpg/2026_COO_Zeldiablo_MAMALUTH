package Roles;

import personnage.Personnage;

public class Hero extends Personnage {
    private String nom;
    private int pv;
    private int degats;

    public Hero(int x, int y,String n, int p, int d){
        super(x,y, n, p, d);
    }

}
