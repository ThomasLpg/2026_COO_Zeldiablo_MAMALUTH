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
    public void testDeplacementVide() throws IOException {

        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso( labyrinthe);
        jp.lireFichier("src/labyrinthe/niveaux/Niveau1.txt");


        Commande commande = new Commande();
        commande.droite = true;


        jp.evoluer(commande);
        assertEquals(11, jp.getPj().getX());


    }

    @Test
    public void testCollisionMur() {
        Hero hero = new Hero(18, 1, "Lucas", 100, 10);
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        JeuPerso jp = new JeuPerso(labyrinthe);


        Commande commande = new Commande();
        commande.droite = true;


        jp.evoluer(commande);
        assertEquals(18, hero.getX(), "Le mur est a x = 19, le personnage" +
                "devrait rester en place");
    }
}