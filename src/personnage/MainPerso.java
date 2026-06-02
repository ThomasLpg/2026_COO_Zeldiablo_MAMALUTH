package personnage;
import Roles.Hero;
import Roles.Monstre;
import dessins.Dessins;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.Labyrinthe;
import moteurJeu.MoteurGraphique;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
        Labyrinthe laby = new Labyrinthe(20, 20);
        Hero hero = new Hero(10, 10, "Perrin", 100, 20);
        System.out.println(hero.toString());
        Monstre monstre = new Monstre(15 , 15, "chien", 50, 10);
        System.out.println(monstre);

        JeuPerso jeu = new JeuPerso(laby);
        jeu.ajouterPerso(hero);
        jeu.ajouterPerso(monstre);

        DessinPerso aff = new DessinPerso(jeu, jeu.getListePerso());

        DessinLabyrinthe dessinLabyrinthe = new DessinLabyrinthe(laby);

        Dessins dess = new Dessins();
        dess.ajouterDessin(aff);
        dess.ajouterDessin(dessinLabyrinthe);


        MoteurGraphique moteur = new MoteurGraphique(jeu, dess);

        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(400, 400);

        // lorsque le jeu est fini
        System.out.println("FIN");
    }
}
