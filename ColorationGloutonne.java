package Graphe;

import java.util.*;

public class ColorationGloutonne {
    public static Map<Integer, Integer> colorier(GrapheNonOriente graphe) {
        Map<Integer, Integer> couleurs = new HashMap<>();

        for (Sommet s : graphe.getListeDesSommets()) {
            Set<Integer> interdites = new HashSet<>();
            for (Lien lien : s.getVoisins()) {
                int voisin = lien.getDestination().getIdentifiant();
                if (couleurs.containsKey(voisin)) interdites.add(couleurs.get(voisin));
            }

            int couleur = 1;
            while (interdites.contains(couleur)) couleur++;
            couleurs.put(s.getIdentifiant(), couleur);
        }

        return couleurs;
    }
}
