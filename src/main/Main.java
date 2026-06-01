package main;

public class Main {

    /**
     * methode pour tester le lancement des tests unitaires
     */
    public int retour() {
        return 1;
    }

    /**
     * simple helloWorld
     */
    public static void main(String[] args) {

        int[][] bjr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        for (int i = 0; i < bjr.length; i++) {
            for (int j = 0; j < bjr[i].length; j++) {
                System.out.println(bjr[i][j]);

            }
        }
    }

}
