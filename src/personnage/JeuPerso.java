package personnage;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;

public class JeuPerso extends Personnage {
    private Personnage personnage = new Personnage();
    private Labyrinthe labyrinthe = new Labyrinthe(10, 10);

    public void evoluerCommande(Commande c){
        deplacer(c);
    }

    public boolean etreFini(){
        return this.labyrinthe.etreMur(personnage.getY(), personnage.getX());
    }

    public Personnage getPj(){
        return this.personnage;
    }
}
