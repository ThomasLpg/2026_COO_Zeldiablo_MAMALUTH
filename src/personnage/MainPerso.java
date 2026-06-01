package personnage;

import arkanoidJeu.ArkanoidDessin;
import arkanoidJeu.ArkanoidJeu;
import moteurJeu.MoteurGraphique;

import java.util.Scanner;

public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
        JeuPerso jeu = new JeuPerso();
        DessinPerso aff = new DessinPerso(jeu);


        MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(400, 400);

        // lorsque le jeu est fini
        System.out.println("Fin du Jeu - appuyer sur entree");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.exit(1);

    }
}
