package personnage;

import moteurJeu.Commande;

public class Personnage {

    private int x; //Position / coordonnée x
    private int y; //Position / coordonnée y

    public Personnage(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Personnage(){}
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
}
