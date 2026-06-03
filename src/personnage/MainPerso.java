package personnage;
import dessins.Dessins;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.DessinPortail;
import labyrinthe.Portail;
import moteurJeu.DessinJeu;
import moteurJeu.MoteurGraphique;

import java.io.IOException;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException, IOException {



        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");

        DessinPerso aff = new DessinPerso(jeu, jeu.getListePerso());

        DessinLabyrinthe dessinLabyrinthe = new DessinLabyrinthe(jeu.getLaby());

        DessinPortail dessinPortail = new DessinPortail(jeu, jeu.getListePortails());
        Dessins dess = new Dessins();

        dess.ajouterDessin(dessinLabyrinthe);
        dess.ajouterDessin(aff);
        dess.ajouterDessin(dessinPortail);



        MoteurGraphique moteur = new MoteurGraphique(jeu, dess);

        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(400, 400);

        // lorsque le jeu est fini
        System.out.println("FIN");
    }
}
