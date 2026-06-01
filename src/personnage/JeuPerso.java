package personnage;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso extends Personnage implements Jeu {
    private Personnage personnage;
    private Labyrinthe labyrinthe = new Labyrinthe(10, 10);

    public JeuPerso(int x, int y){
        this.personnage = new Personnage(x, y);
        this.labyrinthe.construireMurs();
    }

    public void evoluer(Commande c){
        personnage.deplacer(c);
    }

    public boolean etreFini(){
        return this.labyrinthe.etreMur(personnage.getY(), personnage.getX());
    }

    public Personnage getPj(){
        return this.personnage;
    }
}
