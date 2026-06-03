package personnage;
import Roles.Hero;
import Roles.Monstre;
import jdk.jshell.execution.JdiExecutionControlProvider;
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
        int nbmonstre = 1, longmax = 0;

        while (ligne != null){
            liste_lignes.add(ligne);

            if (ligne.length() > longmax) longmax = ligne.length();
            ligne = br.readLine();
        }
        br.close();
        this.laby = new Labyrinthe(longmax, liste_lignes.size());
        for (int y = 0 ; y < liste_lignes.size() ; y++){
            for (int x = 0; x < liste_lignes.get(y).length() ; x++) {
                c = liste_lignes.get(y).charAt(x);
                switch (c) {
                    case '#':
                        this.laby.getMurs()[y][x] = true;
                        break;
                    case '&':
                        this.personnage.addFirst(new Hero(x, y, "Héros", 100, 10));
                        break;
                    case '€':
                        this.personnage.add(new Monstre(x, y, "Monstre " + nbmonstre, 30, 20));
                        nbmonstre++;
                    default:
                        this.laby.getMurs()[y][x] = false;
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


    public boolean deplacementPossible(int x, int y){
        boolean res = true;

        if(this.laby.etreMur(x, y)){
            return false;
        }

        if(this.etrePersonnage(x, y)){
            return false;
        }

        return  res;
    }


    public boolean verifsuivant(int x, int y, Commande c){
        boolean res = false;
        int[] cooSuivante = this.getSuivant(x, y, c);
        if (deplacementPossible(cooSuivante[0], cooSuivante[1])){
            return true;
        }
        return res;
    }


    public void evoluer(Commande c){
        Personnage p;
        p = this.personnage.getFirst();

        if (verifsuivant(p.getX(), p.getY(), c)) {
            p.deplacer(c);
        } else {
            deplacerDiagonale(c);
        }

        for (int i = 1; i < this.personnage.size(); i++) {
            p = this.personnage.get(i);
            Commande cMonstre = ((Monstre) p).directionAleatoire();
            if (verifsuivant(p.getX(), p.getY(), cMonstre)) {
                p.deplacer(cMonstre);
            }
        }
    }

    public boolean etreFini(){

        return false;
    }

    public Personnage getPersonnage(String nom){
        for (Personnage p : this.personnage){
            if (p.getNom().equals(nom)) return p;
        }
        return null;
    }

    public ArrayList<Personnage> getListePerso(){
        return this.personnage;
    }

    public Personnage getPj(){
        return this.getPersonnage("Héros");
    }

    public Labyrinthe getLaby(){
        return this.laby;
    }

    public boolean etrePersonnage(int x, int y){
        boolean perso = false;
        for(Personnage p : this.personnage){
            if(p.getX() == x && p.getY() == y){
                perso = true;
            }
        }
        return perso;
    }

    public void deplacerDiagonale(Commande c){
        boolean b = c.bas;
        boolean h = c.haut;
        boolean d = c.droite;
        boolean g = c.gauche;
        int[] cooSuivante;
        int cooSuivanteX;
        int cooSuivanteY;
        switch("" + d + "-" + g + "-" + h + "-" + b){
            case"true-false-true-false":
                c.haut = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                        personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "true-false-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "false-true-true-false":
                c.haut = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "false-true-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY)) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
        }
    }
}
