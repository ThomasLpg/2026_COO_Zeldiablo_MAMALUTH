package dessins;

import moteurJeu.DessinJeu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Dessins implements DessinJeu {
    ArrayList<DessinJeu> liste = new ArrayList<>(0);

    public void ajouterDessin(DessinJeu dj){
        this.liste.add(dj);
    }

    @Override
    public void dessiner(BufferedImage image) {
        for (DessinJeu elt : this.liste){
            elt.dessiner(image);
        }
    }
}
