package personnage;

public class Personnage {

    private int x; //Position / coordonnée x
    private int y; //Position / coordonnée y
    private static final String GAUCHE = "gauche";
    private static final String DROITE = "droite";
    private static final String HAUT = "haut";
    private static final String BAS = "bas";

    public void deplacer(String commande){
        switch (commande){
            case GAUCHE :
                x -= 1;
                break;

            case DROITE :
                x += 1;
                break;

            case HAUT :
                y -= 1;
                break;

            case BAS :
                y += 1;
                break;
        }
    }
}
