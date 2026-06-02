package Roles;

import personnage.Personnage;

import java.awt.*;
import java.awt.image.BufferedImage;

import static personnage.DessinPerso.TAILLE;


public class Hero extends Personnage {
    private String nom;
    private int pv;
    private int degats;

    public Hero(int x, int y,String n, int p, int d){
        super(x,y, n, p, d);
    }


}
