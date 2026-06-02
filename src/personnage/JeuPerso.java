package personnage;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.util.ArrayList;

public class JeuPerso implements Jeu {
    private ArrayList<Personnage> personnage;
    private Labyrinthe laby;

    public JeuPerso(Labyrinthe laby){
        this.personnage = new ArrayList<>(0);
        this.laby = laby;
        laby.construireMurs();
    }

    public void ajouterPerso(Personnage p){
        this.personnage.add(p);
    }

    public int[] getSuivant(int x, int y, Commande c){
        if(c.bas){
            y += 1;
        }
        if(c.haut){
            y -= 1;
        };
        if(c.gauche){
            x -=1;
        };
        if(c.droite){
            x +=1;
        };
        int[] res = {x, y};
        return res;
    }

    public void evoluer(Commande c){
        int[] cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
        int cooSuivanteX = cooSuivante[0];
        int cooSuivanteY = cooSuivante [1];
        if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))){
            personnage.getFirst().deplacer(c);
        }
    }

    public boolean etreFini(){
        return this.laby.etreMur(personnage.getFirst().getY(), personnage.getFirst().getX());
    }

    public ArrayList<Personnage> getListePerso(){
        return this.personnage;
    }

    public Personnage getPj(){
        return this.personnage.getFirst();
    }
}
