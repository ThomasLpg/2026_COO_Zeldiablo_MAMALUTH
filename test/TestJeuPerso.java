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



        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        boolean mur = jp.getLaby().getMurs()[0][0];

        assertTrue(mur);

        mur = jp.getLaby().getMurs()[1][10];
        assertFalse(mur);

        assertEquals(9, jp.getPj().getX());
        assertEquals(10, jp.getPj().getY());

        assertEquals(9, jp.getPersonnage("Monstre 1").getX());
        assertEquals(16, jp.getPersonnage("Monstre 1").getY());

    }

    @Test
    public void testGetSuivant(){


        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.bas = true;
        int[] suiv = jp.getSuivant(jp.getPj().getX(), jp.getPj().getY(), c);

        // Vérification
        assertEquals(9, suiv[0]);
        assertEquals(11, suiv[1]);
    }

    @Test
    public void testEvoluerHaut() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.haut = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(9, jp.getPj().getX());
        assertEquals(9, jp.getPj().getY());
    }

    @Test
    public void testEvoluerHautDroite() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.haut = true;
        c.droite = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(10, jp.getPj().getX());
        assertEquals(9, jp.getPj().getY());
    }

    @Test
    public void testEvoluerDroite() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.droite = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(10, jp.getPj().getX());
        assertEquals(10, jp.getPj().getY());
    }


    @Test
    public void testEvoluerBasDroite() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.bas = true;
        c.droite = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(10, jp.getPj().getX());
        assertEquals(11, jp.getPj().getY());
    }


    @Test
    public void testEvoluerBas() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.bas = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(9, jp.getPj().getX());
        assertEquals(11, jp.getPj().getY());
    }

    @Test
    public void testEvoluerBasGauche() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.bas = true;
        c.gauche = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(8, jp.getPj().getX());
        assertEquals(11, jp.getPj().getY());
    }

    @Test
    public void testEvoluerGauche() throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.gauche = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(8, jp.getPj().getX());
        assertEquals(10, jp.getPj().getY());
    }

    @Test
    public void testEvoluerHautGauche()  throws InterruptedException {
        JeuPerso jp = new JeuPerso();

        try {
            jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture de fichier...");
        }

        Commande c = new Commande();
        c.haut = true;
        c.gauche = true;
        jp.evoluer(c);

        // Vérification
        assertEquals(8, jp.getPj().getX());
        assertEquals(9, jp.getPj().getY());
    }
}