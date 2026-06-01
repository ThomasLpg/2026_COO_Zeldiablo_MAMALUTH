package personnage;
import Roles.Role;
import dessins.Dessins;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.Labyrinthe;
import moteurJeu.MoteurGraphique;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
        Labyrinthe laby = new Labyrinthe(20, 20);
        Personnage personnage = new Personnage(10, 10, "Perrin", 100, 20);
        JeuPerso jeu = new JeuPerso(personnage, laby);

        DessinPerso aff = new DessinPerso(jeu);

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
