package Roles;
import moteurJeu.Commande;
import personnage.Personnage;

public class Monstre extends Personnage {

    public Monstre(int x, int y, String n, int p, int d) {
        super(x, y, n, p, d);
    }

    public Commande directionAleatoire() {
        int direction = (int) Math.floor(Math.random() * 32);
        Commande c = new Commande();

        switch (direction) {
            case 0:
                c.haut = true;
                break;
            case 1:
                c.droite = true;
                c.haut = true;
                break;
            case 2:
                c.droite = true;
                break;
            case 3:
                c.droite = true;
                c.bas = true;
                break;
            case 4:
                c.bas = true;
                break;
            case 5:
                c.gauche = true;
                c.bas = true;
                break;
            case 6:
                c.gauche = true;
                break;
            case 7:
                c.haut = true;
                c.gauche = true;
                break;
        }
        return c;
    }
}
