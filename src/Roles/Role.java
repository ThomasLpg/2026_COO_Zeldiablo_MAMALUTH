package Roles;

import personnage.Personnage;

public abstract class Role implements Victime{

    private String nom;
    private int pv;

    public Role(String n, int p){
        this.nom = n;
        this.pv = p;
    }

    public String getNom(){
        return this.nom;
    }

    public int getPv(){
        return this.pv;
    }

    public abstract boolean etreMort();

    public abstract void ajouterVie(int vie);

    public abstract int subirDegats(int coup);

    public abstract String toString();

    public abstract void attaquer(Personnage p);
}
