package Roles;

import personnage.Personnage;

public abstract class Role implements Victime{

    private String nom;
    private int pv;
    private int degats;

    public Role(String n, int p, int d){
        this.nom = n;
        this.pv = p;
        this.degats = d;
    }

    public Role() {

    }

    public String getNom(){
        return this.nom;
    }

    public int getPv(){
        return this.pv;
    }

    public int getDegats(){
        return this.degats;
    }

    public abstract boolean etreMort();

    public abstract void ajouterVie(int vie);

    public abstract int subirDegats(int coup);

    public abstract String toString();

    public abstract void attaquer(Role r);
}
