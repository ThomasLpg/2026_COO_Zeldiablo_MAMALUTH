import Roles.Hero;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import org.junit.jupiter.api.Test;
import personnage.JeuPerso;
import personnage.Personnage;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLabyrinthe {
    @Test
    public void testConstructeurDimensions(){
        // Initialisation d'un labyrinthe de 20 par 20
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);

        // Vérification des dimensions
        assertEquals(20, labyrinthe.getMurs().length);
        assertEquals(20, labyrinthe.getMurs()[0].length);


    }

    @Test
    public void testEtreMur() {
        // Initialisation d'un labyrinthe de 20 par 20
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