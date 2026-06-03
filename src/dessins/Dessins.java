package dessins;

import moteurJeu.DessinJeu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Permet d'ajouter à une liste de dessin tous les objets
 * qui doivent être dessiner pour créer le niveau,
 * le heros, les monstres, les murs
 */
public class Dessins implements DessinJeu {
    ArrayList<DessinJeu> liste = new ArrayList<>(0);

    /**
     * Permet d'ajouter le dessin dj à la liste
     * @param dj un dessin à ajouter
     */
    public void ajouterDessin(DessinJeu dj){
        this.liste.add(dj);
    }

    /**
     * Crée les dessins
     * @param image à dessiner
     */
    @Override
    public void dessiner(BufferedImage image) {

        for (DessinJeu elt : this.liste){
            elt.dessiner(image);
        }
    }
}
