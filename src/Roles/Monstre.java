package Roles;
import moteurJeu.Commande;
import personnage.Personnage;

public class Monstre extends Personnage {
    /**
     * Constructeur d'un Monstre
     * @param x coordonnée x du monstre
     * @param y coordonnée y du monstre
     * @param n nom du monstre
     * @param p point de vie du monstre
     * @param d dégats que le monstre fait
     */
    public Monstre(int x, int y, String n, int p, int d) {
        super(x, y, n, p, d);
    }

    /**
     * Permet aux monstres de se déplacer aléatoirement grace à une valeur choisit entre 0 et 32,
     * ce qui fait que à chaque frame, le monstre à 1/4 chance de se déplacer, donc déplacement plus lents
     * @return
     */
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
