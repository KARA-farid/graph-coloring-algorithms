package Graphe;

import java.io.*;
import java.util.*;

public class GrapheNonOriente {
    private List<Sommet> sommets = new ArrayList<>();

    public void ajouterSommet(int id) {
        if (getSommet(id) == null) sommets.add(new Sommet(id));
    }

    public Sommet getSommet(int id) {
        for (Sommet s : sommets) {
            if (s.getIdentifiant() == id) return s;
        }
        return null;
    }

    public void ajouterLien(int id1, int id2) {
        Sommet a = getSommet(id1), b = getSommet(id2);
        if (a == null) { a = new Sommet(id1); sommets.add(a); }
        if (b == null) { b = new Sommet(id2); sommets.add(b); }
        a.ajouterVoisin(b);
        b.ajouterVoisin(a);
    }

    public List<Sommet> getListeDesSommets() {
        return sommets;
    }

    public void exporterFichierLiens(String nomFichier) throws IOException {
        FileWriter fw = new FileWriter(nomFichier);
        fw.write("source,target\n");
        Set<String> liensVus = new HashSet<>();
        for (Sommet s : sommets) {
            for (Lien l : s.getVoisins()) {
                int a = l.getSource().getIdentifiant();
                int b = l.getDestination().getIdentifiant();
                String cle = Math.min(a, b) + "-" + Math.max(a, b);
                if (liensVus.add(cle)) {
                    fw.write(a + "," + b + "\n");
                }
            }
        }
        fw.close();
    }

    public void exporterFichierSommets(String nomFichier, Map<Integer, Integer> couleurs) throws IOException {
        FileWriter fw = new FileWriter(nomFichier);
        fw.write("id,couleur\n");
        String[] couleursHTML = {"gray", "red", "blue", "green", "orange", "purple", "cyan"};
        for (Sommet s : sommets) {
            int id = s.getIdentifiant();
            int couleur = couleurs.getOrDefault(id, 0);
            String c = couleursHTML[couleur % couleursHTML.length];
            fw.write(id + "," + c + "\n");
        }
        fw.close();
    }
}
