import Roles.Hero;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import org.junit.jupiter.api.Test;
import personnage.JeuPerso;
import personnage.Personnage;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestJeuPerso {
    @Test
    public void testLireFichier() {
        // Initialisation d'un labyrinthe de 20 par 20


        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        boolean mur = labyrinthe.getMurs()[0][0];

        assertTrue(mur);

        mur = labyrinthe.getMurs()[0][10];
        assertTrue(mur);

        mur = labyrinthe.getMurs()[1][10];
        assertFalse(mur);

        mur = labyrinthe.getMurs()[5][0];
        assertTrue(mur);

        mur = labyrinthe.getMurs()[19][10];
        assertTrue(mur);

    }

    @Test
    public void testEtreMur(){


        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }
        // Récupération d'un éventuel mur
        boolean mur = jp.getLaby().etreMur(0, 0);

        // Vérification
        assertTrue(mur);
    }


}