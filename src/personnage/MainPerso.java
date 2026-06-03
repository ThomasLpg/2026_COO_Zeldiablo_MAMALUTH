package personnage;
import dessins.Dessins;
import items.DessinItem;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.DessinPortail;
import labyrinthe.Portail;
import moteurJeu.DessinJeu;
import moteurJeu.MoteurGraphique;

import java.io.IOException;

import static labyrinthe.DessinLabyrinthe.TAILLE;


public class MainPerso {
    /**
     * Permet de lancer le jeu entier, avec les personnages, les niveaux, les portails
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {


        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/NiveauEnorme.txt");

        int hauteur = jeu.getLaby().getMurs().length;
        int largeur = jeu.getLaby().getMurs()[0].length;


        DessinPerso aff = new DessinPerso(jeu, jeu.getListePerso());

        DessinLabyrinthe dessinLabyrinthe = new DessinLabyrinthe(jeu.getLaby());

        DessinItem dessinItem = new DessinItem(jeu, jeu.getListeItems());

        DessinPortail dessinPortail = new DessinPortail(jeu, jeu.getListePortails());
        Dessins dess = new Dessins();

        dess.ajouterDessin(dessinLabyrinthe);
        dess.ajouterDessin(aff);
        dess.ajouterDessin(dessinPortail);
        dess.ajouterDessin(dessinItem);



        MoteurGraphique moteur = new MoteurGraphique(jeu, dess);

        JeuPrincipal main = new JeuPrincipal(jeu, dess, moteur);

        // lance la boucle de jeu qui tourne jusque la fin du jeu
        main.lancerJeu((largeur * TAILLE)-1, (hauteur*TAILLE)-1);

        // lorsque le jeu est fini
        System.out.println("FIN");
    }
}
