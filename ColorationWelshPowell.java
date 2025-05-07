package Graphe;

import java.util.*;

public class ColorationWelshPowell {
    public static Map<Integer, Integer> colorier(GrapheNonOriente graphe) {
        List<Sommet> sommets = new ArrayList<>(graphe.getListeDesSommets());
        sommets.sort((a, b) -> b.getVoisins().size() - a.getVoisins().size());

        Map<Integer, Integer> couleurs = new HashMap<>();

        for (Sommet s : sommets) {
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
