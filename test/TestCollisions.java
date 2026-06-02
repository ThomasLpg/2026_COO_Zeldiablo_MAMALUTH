package main;

import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import personnage.Personnage;


public class TestCollisions {
    @Test
    public void testCollisions(){
        Personnage personnage = new Personnage(19, 1, "Lucas", 100, 10);
        Labyrinthe labyrinthe = new Labyrinthe(20, 20);


        personnage.deplacer(commande);



    }

}
