package Graphe;

import java.util.*;

public class ColorationDSatur {
    public static Map<Integer, Integer> colorier(GrapheNonOriente graphe) {
        Map<Integer, Integer> couleurs = new HashMap<>();
        Set<Sommet> nonColories = new HashSet<>(graphe.getListeDesSommets());

        while (!nonColories.isEmpty()) {
            Sommet maxSatur = null;
            int maxSaturation = -1;
            int maxDegre = -1;

            for (Sommet s : nonColories) {
                Set<Integer> couleursVoisins = new HashSet<>();
                for (Lien lien : s.getVoisins()) {
                    int voisin = lien.getDestination().getIdentifiant();
                    if (couleurs.containsKey(voisin)) couleursVoisins.add(couleurs.get(voisin));
                }
                int saturation = couleursVoisins.size();
                int degre = s.getVoisins().size();

                if (saturation > maxSaturation || (saturation == maxSaturation && degre > maxDegre)) {
                    maxSatur = s;
                    maxSaturation = saturation;
                    maxDegre = degre;
                }
            }

            Set<Integer> interdites = new HashSet<>();
            for (Lien lien : maxSatur.getVoisins()) {
                int voisin = lien.getDestination().getIdentifiant();
                if (couleurs.containsKey(voisin)) interdites.add(couleurs.get(voisin));
            }

            int couleur = 1;
            while (interdites.contains(couleur)) couleur++;
            couleurs.put(maxSatur.getIdentifiant(), couleur);
            nonColories.remove(maxSatur);
        }

        return couleurs;
    }
}
