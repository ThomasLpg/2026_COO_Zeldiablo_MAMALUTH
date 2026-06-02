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

    public JeuPerso(Labyrinthe laby){
        this.personnage = new ArrayList<>(0);
        this.laby = laby;
    }

    public void ajouterPerso(Personnage p){
        this.personnage.add(p);
    }

    public void lireFichier(String fichier) throws IOException {
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        String ligne = br.readLine();
        char c;
        int y = 0, nbmonstre = 0;
        while (ligne != null){
            for (int i = 0; i < ligne.length() ; i++){
                c = ligne.charAt(i);
                switch (c){
                    case '#' :
                        this.laby.getMurs()[i][y] = true;
                        break;
                    case '&' :
                        this.personnage.add(new Hero(i, y, "Héros", 100, 10));
                        break;
                    case '€' :
                        this.personnage.add(new Monstre(i, y, "Monstre " + nbmonstre, 30, 20));
                        nbmonstre++;
                    default:
                        this.laby.getMurs()[i][y] = false;
                        break;
                }
            }

            y++;
            ligne = br.readLine();
        }
        br.close();
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
        boolean b = c.bas;
        boolean h = c.haut;
        boolean d = c.droite;
        boolean g = c.gauche;
        int[] cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
        int cooSuivanteX = cooSuivante[0];
        int cooSuivanteY = cooSuivante [1];
        if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))){
            personnage.getFirst().deplacer(c);
        } else switch("" + d + "-" + g + "-" + h + "-" + b){
            case"true-false-true-false":
                c.haut = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if (!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                        personnage.getFirst().deplacer(c);
                    }
                }
            case "true-false-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if (!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                        personnage.getFirst().deplacer(c);
                    }
                }
            case "false-true-true-false":
                c.haut = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if (!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                        personnage.getFirst().deplacer(c);
                    }
                }
            case "false-true-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if (!(laby.etreMur(cooSuivanteX, cooSuivanteY))) {
                        personnage.getFirst().deplacer(c);
                    }
                }
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
}
