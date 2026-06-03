package personnage;
import dessins.Dessins;
import labyrinthe.DessinLabyrinthe;
import moteurJeu.MoteurGraphique;

import java.io.IOException;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException, IOException {



        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/NiveauEnorme.txt");

        DessinPerso aff = new DessinPerso(jeu, jeu.getListePerso());

        DessinLabyrinthe dessinLabyrinthe = new DessinLabyrinthe(jeu.getLaby());

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
