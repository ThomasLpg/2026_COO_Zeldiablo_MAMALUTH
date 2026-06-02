package personnage;

import moteurJeu.Commande;

import java.awt.*;
import java.util.ArrayList;

import static personnage.DessinPerso.TAILLE;

public class Personnage {

    private int x; //Position / coordonnée x
    private int y; //Position / coordonnée y
    private String nom;
    private int pv;
    private int degats;

    public Personnage(int x, int y, String n, int p, int d){
        this.nom = n;
        this.pv = p;
        this.degats = d;
        this.x = x;
        this.y = y;
    }

    public Personnage(){

    }

    public void deplacer(Commande commande){
        boolean b = commande.bas;
        boolean h = commande.haut;
        boolean d = commande.droite;
        boolean g = commande.gauche;
        switch ("" + d + "-" + g + "-" + h + "-" + b){
            case "true-false-false-false" :
                x += 1;
                break;

            case "false-true-false-false" :
                x -= 1;
                break;

            case "false-false-true-false" :
                y -= 1;
                break;

            case "false-false-false-true" :
                y += 1;
                break;

            case "true-false-true-false" :
                x += 1;
                y -= 1;
                break;

            case "true-false-false-true" :
                x += 1;
                y += 1;
                break;

            case "false-true-true-false" :
                x -= 1;
                y -= 1;
                break;

            case "false-true-false-true" :
                x -= 1;
                y += 1;
                break;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int subirDegats(int coup){
        this.pv -= coup;
        return coup;
    }

    public boolean etreMort(){
        return(this.pv == 0);
    }

    public void ajouterVie(int vie){
        this.pv += vie;
    }

    public String toString(){
        String s = "";
        s += "Nom: " + this.nom + ", pv: " + this.pv;
        return s;
    }

    public void attaquer(Personnage r){
        r.subirDegats(this.degats);
    }

    public void dessiner(Graphics2D g, Color c){
        g.setColor(c);
        g.fillOval(this.getX()*TAILLE, this.getY()*TAILLE, TAILLE, TAILLE);
    }
}
