package personnage;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {
    private Personnage personnage;
    private Labyrinthe labyrinthe = new Labyrinthe(10, 10);

    public JeuPerso(int x, int y){
        this.personnage = new Personnage(x, y, null, 0, 0);
        this.labyrinthe.construireMurs();
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
        int[] cooSuivante = getSuivant(personnage.getX(), personnage.getY(), c);
        int cooSuivanteX = cooSuivante[0];
        int cooSuivanteY = cooSuivante [1];
        if(!(labyrinthe.etreMur(cooSuivanteX, cooSuivanteY))){
            personnage.deplacer(c);
        }
    }

    public boolean etreFini(){
        return this.labyrinthe.etreMur(personnage.getY(), personnage.getX());
    }

    public Personnage getPj(){
        return this.personnage;
    }
}
