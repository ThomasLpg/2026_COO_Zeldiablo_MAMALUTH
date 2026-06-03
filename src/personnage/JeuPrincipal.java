package personnage;

import dessins.Dessins;
import moteurJeu.MoteurGraphique;

public class JeuPrincipal {
    private JeuPerso jp;
    public static Dessins liste_dessins;
    private MoteurGraphique moteur;

    /**
     * Constructeur d'un jeu
     * @param j liste des personnages
     * @param d liste des dessins des personnages
     * @param m moteurGraphique
     */
    public JeuPrincipal(JeuPerso j, Dessins d, MoteurGraphique m){
        this.jp = j;
        liste_dessins = d;
        this.moteur = m;
    }

    /**
     * Permet de lancer le jeu
     * @param width largeur de la page sur laquelle le niveau apparait
     * @param height longueur de la page sur laquelle le niveau apparait
     * @throws InterruptedException
     */
    public void lancerJeu(int width, int height) throws InterruptedException {
        this.moteur.lancerJeu(width, height);
    }

    /**
     * Getter de la liste de personnage dans Personnage
     * @param jp liste de Personnage
     */
    public void getJp(JeuPerso jp) {
        this.jp = jp;
    }

    /**
     * Getter de la liste de dessins
     * @param liste_dessins liste des dessins
     */
    public void getListe_dessins(Dessins liste_dessins) {
        JeuPrincipal.liste_dessins = liste_dessins;
    }

    /**
     * Getter du moteur graphique du jeu
     * @param moteur moteur graphique du jeu
     */
    public void getMoteur(MoteurGraphique moteur) {
        this.moteur = moteur;
    }
}
