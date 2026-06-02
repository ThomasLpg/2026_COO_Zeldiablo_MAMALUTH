package personnage;
import Roles.Hero;
import Roles.Monstre;
import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JeuPerso implements Jeu {
    private ArrayList<Personnage> personnage;
    private Labyrinthe laby;

    public JeuPerso(){
        this.personnage = new ArrayList<>(0);
    }

    public void ajouterPerso(Personnage p){
        this.personnage.add(p);
    }

    public void lireFichier(String fichier) throws IOException {
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        String ligne = br.readLine();
        ArrayList<String> liste_lignes = new ArrayList<>(0);
        char c;
        int nbmonstre = 0, longmax = 0;

        while (ligne != null){
            liste_lignes.add(ligne);
            System.out.println(ligne.length());
            if (ligne.length() > longmax) longmax = ligne.length();
            ligne = br.readLine();
        }
        br.close();
        this.laby = new Labyrinthe(liste_lignes.size(), longmax);
        System.out.println(longmax);
        for (int y = 0 ; y < liste_lignes.size() ; y++){
            for (int i = 0; i < liste_lignes.get(y).length() ; i++) {
                c = liste_lignes.get(y).charAt(i);
                switch (c) {
                    case '#':
                        this.laby.getMurs()[i][y] = true;
                        break;
                    case '&':
                        this.personnage.add(new Hero(i, y, "Héros", 100, 10));
                        break;
                    case '€':
                        this.personnage.add(new Monstre(i, y, "Monstre " + nbmonstre, 30, 20));
                        nbmonstre++;
                    default:
                        this.laby.getMurs()[i][y] = false;
                        break;
                }
            }
        }



    }
    public int[] getSuivant(int x, int y, Commande c){

        if(c.bas){
            y += 1;
        }
        if(c.haut){
            y -= 1;
        };
        if(c.gauche){
            x -=1;
        };
        if(c.droite){
            x +=1;
        };
        int[] res = {x, y};
        return res;
    }

    public void evoluer(Commande c){
        int[] cooSuivante = this.getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);

        int cooSuivanteX = cooSuivante[0];
        int cooSuivanteY = cooSuivante [1];
        if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))){
            personnage.getFirst().deplacer(c);
        }
    }

    public boolean etreFini(){
        return this.laby.etreMur(personnage.getFirst().getY(), personnage.getFirst().getX());
    }

    public ArrayList<Personnage> getListePerso(){
        return this.personnage;
    }

    public Personnage getPj(){
        return this.personnage.getFirst();
    }

    public Labyrinthe getLaby(){
        return this.laby;
    }
}
