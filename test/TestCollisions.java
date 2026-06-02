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




public class TestCollisions {
    @Test
    public void testCollisionMurBas() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurBas.txt");

        Commande commande = new Commande();
        commande.bas = true;

        jp.evoluer(commande);
        assertEquals(17, jp.getPj().getY(),
                "il y a un mur en y = 18");
    }

    @Test
    public void testCollisionMurHaut() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurHaut.txt");

        Commande commande = new Commande();
        commande.haut = true;

        jp.evoluer(commande);
        assertEquals(1, jp.getPj().getY(),
                "il y a un mur en y = 0");
    }

    @Test
    public void testCollisionMurDroite() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurDroit.txt");

        Commande commande = new Commande();
        commande.droite = true;

        jp.evoluer(commande);
        assertEquals(17, jp.getPj().getX(),
                "il y a un mur en x = 18");
    }

    @Test
    public void testCollisionMurGauche() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurGauche.txt");

        Commande commande = new Commande();
        commande.gauche = true;

        jp.evoluer(commande);
        assertEquals(1, jp.getPj().getX(),
                "il y a un mur en x = 0");
    }

    @Test
    public void testCollisionMurHautGauhe() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurHautGauche.txt");

        Commande commande = new Commande();
        commande.haut = true;
        commande.gauche = true;

        jp.evoluer(commande);
        assertEquals(1, jp.getPj().getX(),
                "il y a un mur en x = 0");
        assertEquals(1, jp.getPj().getY(),
                "il y a un mur en y = 0");
    }

    @Test
    public void testCollisionMurHautDroite() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/testMurHautDroite.txt");

        Commande commande = new Commande();
        commande.droite = true;
        commande.haut = true;

        jp.evoluer(commande);
        assertEquals(17, jp.getPj().getX(),
                "il y a un mur en x = 18");
        assertEquals(1, jp.getPj().getY(),
                "il y a un mur en y = 0");
    }



}