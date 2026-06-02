package Roles;

import personnage.Personnage;

import java.awt.*;

import static personnage.DessinPerso.TAILLE;

public class Monstre extends Personnage {

    private String nom;
    private int pv;
    private int degats;

    public Monstre(int x, int y,String n, int p, int d){
        super(x,y, n, p, d);
    }
}
