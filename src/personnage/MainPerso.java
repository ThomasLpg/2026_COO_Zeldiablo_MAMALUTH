package personnage;
import Roles.Hero;
import Roles.Monstre;
import dessins.Dessins;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.Labyrinthe;
import moteurJeu.MoteurGraphique;

import java.io.IOException;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException, IOException {

        Monstre monstre = new Monstre(15 , 15, "chien", 50, 10);

        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");

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
