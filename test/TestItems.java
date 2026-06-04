import Roles.Hero;
import items.Item;
import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import personnage.JeuPerso;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItems {
    @Test
    public void testEpee() throws IOException {
        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/testEpee");

        Commande commande = new Commande();
        commande.haut = true;

        Hero h = (Hero) jeu.getListePerso().getFirst();
        int degatDepart = h.getDegats();
        int[] cooSuivante = jeu.getSuivant(h.getX(), h.getY(), commande);
        Item item = jeu.itemSurCetteCase(cooSuivante[0], cooSuivante[1]);

        jeu.evoluer(commande);
        int degatArrive = h.getDegats();

        assertEquals(false, jeu.getListeItems().contains(item), "L'épée disparait");
        assertEquals(true, degatDepart<degatArrive, "Le personnage inflige maintenant" +
                "plus de dégat");

    }


    @Test
    public void testKitSoin() throws IOException {
        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/testKitSoin");

        Commande commande = new Commande();
        commande.haut = true;

        Hero h = (Hero) jeu.getListePerso().getFirst();
        int pvDepart = h.getPv();
        int[] cooSuivante = jeu.getSuivant(h.getX(), h.getY(), commande);

        Item item = jeu.itemSurCetteCase(cooSuivante[0], cooSuivante[1]);

        jeu.evoluer(commande);
        int pvArrive = h.getPv();

        assertEquals(false, jeu.getListeItems().contains(item), "Le kit de soin disparait");
        assertEquals(true, pvDepart<pvArrive, "Le personnage gagne des pvs");

    }

    @Test
    public void testPiege() throws IOException {
        JeuPerso jeu = new JeuPerso();
        jeu.lireFichier("src/labyrinthe/niveaux/testPiege");

        Commande commande = new Commande();
        commande.haut = true;

        Hero h = (Hero) jeu.getListePerso().getFirst();
        int pvDepart = h.getPv();

        int[] cooSuivante = jeu.getSuivant(h.getX(), h.getY(), commande);

        Item item = jeu.itemSurCetteCase(cooSuivante[0], cooSuivante[1]);

        jeu.evoluer(commande);
        int pvArrive = h.getPv();

        assertEquals(false, jeu.getListeItems().contains(item), "Le piege disparait");
        assertEquals(true, pvDepart>pvArrive, "Le personnage perd des pvs");

    }

}
