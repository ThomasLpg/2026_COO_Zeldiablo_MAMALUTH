package Roles;

public class Monstre extends Role{

    private String nom;
    private int pv;
    private int degats;

    public Monstre(String n, int p, int d){
        super(n, p, d);
    }
    public boolean etreMort(){
        return (this.pv == 0);
    }

    public void ajouterVie(int vie){
        this.pv += vie;
    }

    public int subirDegats(int coup){
        this.pv -= coup;
        return coup;
    }

    public String toString(){
        String s = "";
        s += "Nom: " + this.nom + ", pv: " + this.pv;
        return s;
    }

    public void attaquer(Role r){
        r.subirDegats(this.degats);
    }

}
