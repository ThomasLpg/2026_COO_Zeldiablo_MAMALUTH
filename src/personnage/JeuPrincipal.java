package personnage;

import dessins.Dessins;
import moteurJeu.MoteurGraphique;

public class JeuPrincipal {
    private JeuPerso jp;
    public static Dessins liste_dessins;
    private MoteurGraphique moteur;

    public JeuPrincipal(JeuPerso j, Dessins d, MoteurGraphique m){
        this.jp = j;
        liste_dessins = d;
        this.moteur = m;
    }

    public void lancerJeu(int width, int height) throws InterruptedException {
        this.moteur.lancerJeu(width, height);
    }

    public void getJp(JeuPerso jp) {
        this.jp = jp;
    }

    public void getListe_dessins(Dessins liste_dessins) {
        JeuPrincipal.liste_dessins = liste_dessins;
    }

    public void getMoteur(MoteurGraphique moteur) {
        this.moteur = moteur;
    }
}
