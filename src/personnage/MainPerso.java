package personnage;

import labyrinthe.DessinLabyrinthe;
import labyrinthe.Labyrinthe;
import moteurJeu.MoteurGraphique;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
        JeuPerso jeu = new JeuPerso(5,5);
        DessinPerso aff = new DessinPerso(jeu);

        Labyrinthe laby = new Labyrinthe(10, 10);
        DessinLabyrinthe dessinLabyrinthe = new DessinLabyrinthe(laby);


        MoteurGraphique moteur = new MoteurGraphique(jeu, dessinLabyrinthe);
        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(400, 400);

        // lorsque le jeu est fini

    }
}
