package Graphe;

import java.util.*;

public class Sommet {
    private int identifiant;
    private List<Lien> voisins = new ArrayList<>();

    public Sommet(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public List<Lien> getVoisins() {
        return voisins;
    }

    public void ajouterVoisin(Sommet voisin) {
        voisins.add(new Lien(this, voisin));
    }

    public boolean aPourVoisin(int id) {
        for (Lien lien : voisins) {
            if (lien.getDestination().getIdentifiant() == id) return true;
        }
        return false;
    }
}
