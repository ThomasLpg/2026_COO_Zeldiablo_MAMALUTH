package personnage;

import moteurJeu.MoteurGraphique;


public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
        JeuPerso jeu = new JeuPerso(5,5);
        DessinPerso aff = new DessinPerso(jeu);


        MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(400, 400);

        // lorsque le jeu est fini

    }
}
