package Roles;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import personnage.Personnage;

public class Monstre extends Personnage {

    public Monstre(int x, int y,String n, int p, int d){
        super(x, y, n, p, d);
    }

    public void deplacerMonstre(int x, int y, Labyrinthe laby){
        int deplacement = (int) Math.floor(Math.random() * 8);

        switch (deplacement){
            case 0 :
                if (!laby.getMurs()[y-1][x]){
                    Commande c = new Commande();
                    c.haut = true;
                    this.deplacer(c);

                }
                break;
            case 1 :
                if (!laby.getMurs()[y-1][x+1]){
                    Commande c = new Commande();
                    c.droite = true;
                    c.haut = true;
                    this.deplacer(c);
                }
                break;
            case 2 :
                if (!laby.getMurs()[y][x+1]){
                    Commande c = new Commande();
                    c.droite = true;
                    this.deplacer(c);
                }
                break;
            case 3 :
                if (!laby.getMurs()[y+1][x+1]){
                    Commande c = new Commande();
                    c.droite = true;
                    c.bas = true;
                    this.deplacer(c);
                }
                break;
            case 4 :
                if (!laby.getMurs()[y+1][x]){
                    Commande c = new Commande();
                    c.bas = true;
                    this.deplacer(c);
                }
                break;
            case 5 :
                if (!laby.getMurs()[y+1][x-1]){
                    Commande c = new Commande();
                    c.gauche = true;
                    c.bas = true;
                    this.deplacer(c);
                }
                break;
            case 6 :
                if (!laby.getMurs()[y][x-1]){
                    Commande c = new Commande();
                    c.gauche = true;
                    this.deplacer(c);
                }
                break;
            case 7 :
                if (!laby.getMurs()[y-1][x-1]){
                    Commande c = new Commande();
                    c.haut = true;
                    c.gauche = true;
                    this.deplacer(c);
                }
                break;
        }
    }
}
