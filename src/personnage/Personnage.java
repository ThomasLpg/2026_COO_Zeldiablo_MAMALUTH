package personnage;
import labyrinthe.Labyrinthe;
import labyrinthe.Portail;
import moteurJeu.Commande;
import java.awt.*;

import static personnage.DessinPerso.TAILLE;

public abstract class Personnage {

    private int x = 0; //Position / coordonnée x
    private int y = 0; //Position / coordonnée y
    private String nom = "";
    private int pv = 0 ;
    private int degats = 0      ;

    /**
     * Constructeur d'un personnage
     * @param x coordonnée x du personnage
     * @param y coordonnée y du personnage
     * @param n nom du personnage
     * @param p point de vie du personnage
     * @param d dégat que fait le personnage
     */
    public Personnage(int x, int y, String n, int p, int d) {
        this.x = x;
        this.y = y;
        this.nom = n;
        if(p < 0){
            this.pv = 0;
        }else {
            this.pv = p;
        }
        this.degats = d;
    }

    /**
     * Permet de déplacer le personnage à partir d'une direction (haut, bas, gauche, droite et les diagonales)
     * les commandes sont des booléens, voire Commande
     * @param commande
     */
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

    /**
     * Getter coordonnée x du personnage
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter coordonnée y du personnage
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter des points de vie du personnage
     * @return pv
     */
    public int getPv(){ return this.pv;}

    /**
     * Getter du nom du personnage, Héros si c'est un Heros, 1 2 3 etc si c'est un Monstre
     * @return
     */
    public String getNom(){ return this.nom;}

    /**
     * Retire int coup aux pvs du personnage sur qui la méthode est appliquée
     * @param coup int du nombre de dégats subis
     * @return
     */
    public int subirDegats(int coup){
        if(this.pv -coup < 0){
            this.pv = 0;

        }else{
            this.pv -= coup;
        }
        return coup;
    }

    /**
     * Permet au Heros de prendre un portail vers le niveau suivant, par rapport à l'orientation du portail,
     * le heros réapparaitra à "l'entrée" du prochain niveau
     * @param p
     * @param laby
     */
    public void prendrePortail(Portail p, Labyrinthe laby){
        if (p == null) return;
        switch (p.getOrientation()){
            case "haut" :
                this.y = laby.getMurs().length-1;
                break;
            case "bas" :
                this.y = 0;
                break;
            case "gauche":
                this.x = laby.getMurs()[0].length;
                break;
            case "droite" :
                this.x = 0;
                break;
        }

    }

    /**
     * Permet de vérifier si un personnage est mort
     * @return boolean true si mort, false sinon
     */
    public boolean etreMort(){
        return(this.pv == 0);
    }

    /**
     * Permet d'ajouter de la vie au héros
     * @param vie
     */
    public void ajouterVie(int vie){
        this.pv += vie;
    }

    /**
     * Permet d'ajouter des dégats aux dégats de base du héros
     * @param degats
     */
    public void addDegats(int degats){ this.degats += degats;}

    /**
     * Méthode toString
     * @return
     */
    public String toString(){
        String s = "";
        s += "Nom: " + this.nom + ", pv: " + this.pv;
        return s;
    }

    /**
     * Permet d'attaquer un personnage
     * @param r
     */
    public void attaquer(Personnage r){
        r.subirDegats(this.degats);
    }


    /**
     * Permet de dessiner des personnages (des ronds)
     * @param g
     * @param c
     */
    public void dessiner(Graphics2D g, Color c){
        g.setColor(c);
        g.fillOval(this.x*TAILLE, this.y*TAILLE, TAILLE, TAILLE);
    }
}
