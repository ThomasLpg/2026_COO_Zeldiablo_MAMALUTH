package personnage;
import Roles.Hero;
import Roles.Monstre;
import labyrinthe.DessinLabyrinthe;
import labyrinthe.Labyrinthe;
import labyrinthe.Portail;
import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JeuPerso implements Jeu {
    private ArrayList<Personnage> personnage;
    private Labyrinthe laby;
    private ArrayList<Portail> portails = new ArrayList<>(0);

    /**
     * Constructeur de Personnage, est une arrayList qui augmentera de capacité
     * à chaque Personnage ajouté
     */
    public JeuPerso(){
        this.personnage = new ArrayList<>(0);
    }

    /**
     * Ajoute un nouveau personnage à la liste de Personnage
     * @param p personnage à ajouter
     */
    public JeuPerso(Personnage p) {this.personnage.set(0, p);}
    public void ajouterPerso(Personnage p){
        this.personnage.add(p);
    }

    /**
     * lis le fichier txt qui définie un niveau, dans lequel se trouve des murs, un heros, des monstres
     * @param fichier txt à lire
     * @throws IOException
     */
    public void lireFichier(String fichier) throws IOException {
        this.personnage = new ArrayList<>(0);
        this.laby = null;
        this.portails = new ArrayList<>(0);
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
                        break;
                    case '{':
                        this.portails.add(new Portail(x, y, "src/labyrinthe/niveaux/Niveau2.txt", "droite"));
                        break;
                    case '_':
                        this.portails.add(new Portail(x, y, "src/labyrinthe/niveaux/Niveau3.txt", "haut"));
                        break;
                    default:
                        this.laby.getMurs()[y][x] = false;
                        break;
                }
            }
        }
    }

    /**
     * Permet de créer un nouveau niveau lorsque le heros prend un portail
     * @param nomFichier fichier du nouveau niveau
     * @throws IOException
     */
    public void recharger(String nomFichier) throws IOException {
        Hero h = (Hero) this.getPj();
        this.lireFichier(nomFichier);


        DessinLabyrinthe ds = new DessinLabyrinthe(this.laby);
        DessinPerso dp = new DessinPerso(this, this.personnage);
        JeuPrincipal.liste_dessins.ajouterDessin(ds);
        JeuPrincipal.liste_dessins.ajouterDessin(dp);
        this.personnage.addFirst(h);

    }

    /**
     * Permet d'obtenir la case suivante, en prenant une commande, on sait dans quelle direction le personnage
     * veut se déplacer, on prend la case dans cette direction
     *
     * @param x coordonnée x du personnage
     * @param y coordonnée y du personnage
     * @param c direction dans laquelle le personnage veut aller
     * @return un tableau des coordonnées de la case suivante par rapport à la commande
     */
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

    /**
     * Regarde ce qui se trouve dans la case en x y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return true si la case est vide, false si il quelque chose est dedans
     */
    public int deplacementPossible(int x, int y){
        if(this.laby.etreMur(x, y)) return 0;

        if(this.etrePersonnage(x, y)) return 1;

        if (this.etrePortail(x, y)) return 2;

        return 10;
    }

    /**
     * Vérifie si on peut se déplacer dans la case suivante, utilise la méthode getSuivant pour
     * obtenir les coordonnées de la case suivante, et deplacementPossible pour savoir ce qui se
     * trouve dans cette case
     * @param x coordonnée x de la case suivante
     * @param y coordonnée y de la case suivante
     * @param c Commande pour savoir dans quelle direction est la case suivante
     * @return boolean True si le deplacement dans la case suivante est possible, false sinon
     */
    public int verifsuivant(int x, int y, Commande c){

        int[] cooSuivante = this.getSuivant(x, y, c);
        return deplacementPossible(cooSuivante[0], cooSuivante[1]);

    }

    /**
     * Permet de déplacer le personnage (heros ou monstre), si verifSuivant
     * @param c commande utilisateur
     */
    public void evoluer(Commande c){
        Personnage p = this.personnage.getFirst();


        //Si c'est un portail, le jeux est rechagé vers le niveau voulu
        if (verifsuivant(p.getX(), p.getY(), c) == 2) {
            try {
                int[] cp = this.getSuivant(p.getX(), p.getY(), c);
                p.prendrePortail(this.getPortail(cp[0], cp[1]), this.laby);
                this.recharger(this.getListePortails().getFirst().getDestination());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //Si c'est un personnage, il attaque le personnage en lui infligeant son
        //nombre de dégats en attribut
        if(verifsuivant(p.getX(), p.getY(), c) == 1){
            int cooSuivante[] = getSuivant(p.getX(), p.getY(),c);
            Personnage pAttaque = personnageSurCetteCase(cooSuivante[0], cooSuivante[1]);
            p.attaquer(pAttaque);
        }

        //Si c'est du vide, il s'y déplace librement
        if (verifsuivant(p.getX(), p.getY(), c) == 10) {
            p.deplacer(c);
        } else {
            deplacerDiagonale(c);
        }


        for (int i = 1; i < this.personnage.size(); i++) {
            p = this.personnage.get(i);
            Commande cMonstre = ((Monstre) p).directionAleatoire();
            if(verifsuivant(p.getX(), p.getY(), cMonstre) == 1){
                int cooSuivante[] = getSuivant(p.getX(), p.getY(),cMonstre);
                Personnage pAttaque = personnageSurCetteCase(cooSuivante[0], cooSuivante[1]);
                p.attaquer(pAttaque);
            }
            if (verifsuivant(p.getX(), p.getY(), cMonstre) == 10) {
                p.deplacer(cMonstre);
            }
        }
    }

    /**
     * Arrête le jeu lorsque condition atteinte
     * @return
     */
    public boolean etreFini(){
        return false;
    }

    /**
     * Getter d'un personnage par rapport à son nom
     * @param nom du personnage
     * @return le personnage
     */
    public Personnage getPersonnage(String nom){
        for (Personnage p : this.personnage){
            if (p.getNom().equals(nom)) return p;
        }
        return null;
    }

    /**
     * Getter de la liste des portails
     * @return liste de portail
     */
    public ArrayList<Portail> getListePortails(){
        return this.portails;
    }

    public Portail getPortail(int x, int y){
        for (Portail p : this.portails){
            if (p.getX() == x && p.getY() == y){
                return p;
            }
        }
        return null;
    }


    /**
     * Getter de la liste des personnages
     * @return liste de personnage
     */
    public ArrayList<Personnage> getListePerso(){
        return this.personnage;
    }

    /**
     * Getter des personnages Heros
     * @return personnage avec le nom Héros
     */
    public Personnage getPj(){
        return this.getPersonnage("Héros");
    }

    /**
     * Getter du labyrinthe
     * @return le labyrinthe (niveau)
     */
    public Labyrinthe getLaby(){
        return this.laby;
    }

    /**
     * Vérifie si une case aux coordonnées x y est un personnage ou non
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return boolean true si la case est un personnage, false sinon
     */
    public boolean etrePersonnage(int x, int y){
        boolean perso = false;
        for(Personnage p : this.personnage){
            if (p.getX() == x && p.getY() == y) {
                perso = true;
                break;
            }
        }
        return perso;
    }

    public Personnage personnageSurCetteCase(int x, int y){
        for(Personnage p : this.personnage){
            if(p.getX() == x && p.getY() == y){
                System.out.println(p);
                return p;
            }
        }
        System.out.println("personne");
        return null;
    }

    /**
     * Vérifie si une case aux coordonées x y est un portail ou non
     * @param x coordonnée  de la case
     * @param y coordonnée y de la case
     * @return boolean true si la case est un portail, false sinon
     */
    public boolean etrePortail(int x, int y){
        boolean port = false;
        for(Portail p : this.portails){
            if (p.getX() == x && p.getY() == y) {
                port = true;
                break;
            }
        }
        return port;
    }

    /**
     * Permet aux Personnages de se déplacer en diagonale, permet aussi lorsque que le heros est contre un mur,
     * si il continue d'aller vers ce mur et va dans une autre direction, d'aller dans cette autre direction
     * @param c
     */
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
                if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                    personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                        personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "true-false-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.droite = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "false-true-true-false":
                c.haut = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.haut = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
            case "false-true-false-true":
                c.bas = false;
                cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                cooSuivanteX = cooSuivante[0];
                cooSuivanteY = cooSuivante [1];
                if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                        personnage.getFirst().deplacer(c);
                }else{
                    c.bas = true;
                    c.gauche = false;
                    cooSuivante = getSuivant(personnage.getFirst().getX(), personnage.getFirst().getY(), c);
                    cooSuivanteX = cooSuivante[0];
                    cooSuivanteY = cooSuivante[1];
                    if(deplacementPossible(cooSuivanteX, cooSuivanteY) == 10) {
                            personnage.getFirst().deplacer(c);
                    }
                }
                break;
        }
    }
}
