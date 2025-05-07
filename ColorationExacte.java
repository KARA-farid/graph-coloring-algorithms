package Graphe;

import java.util.*;

/**
 * Classe implémentant une coloration exacte du graphe
 * en utilisant l'exploration exhaustive par retour arrière (backtracking).
 */
public class ColorationExacte {
    private GrapheNonOriente graphe;
    private Map<Integer, Integer> couleurs;

    /**
     * Constructeur.
     * @param graphe Le graphe à colorer.
     */
    public ColorationExacte(GrapheNonOriente graphe) {
        this.graphe = graphe;
        this.couleurs = new HashMap<>();
    }

    /**
     * Tente de colorier le sommet courant avec une couleur non utilisée par ses voisins.
     * @param index L'indice du sommet dans la liste.
     * @param nombreCouleurs Nombre total de couleurs autorisées.
     * @param listeDesSommets Liste ordonnée des sommets.
     * @return true si une coloration valide est trouvée.
     */
    private boolean estColoriable(int index, int nombreCouleurs, List<Sommet> listeDesSommets) {
        if (index == listeDesSommets.size()) return true;

        Sommet courant = listeDesSommets.get(index);
        Set<Integer> interdites = new HashSet<>();

        for (Lien lien : courant.getVoisins()) {
            int voisin = lien.getDestination().getIdentifiant();
            if (couleurs.containsKey(voisin)) {
                interdites.add(couleurs.get(voisin));
            }
        }

        for (int c = 1; c <= nombreCouleurs; c++) {
            if (!interdites.contains(c)) {
                couleurs.put(courant.getIdentifiant(), c);
                if (estColoriable(index + 1, nombreCouleurs, listeDesSommets)) return true;
                couleurs.remove(courant.getIdentifiant());
            }
        }

        return false;
    }

    /**
     * Trouve le nombre chromatique minimal du graphe.
     * @return Le plus petit nombre de couleurs nécessaires.
     */
    public int colorier() {
        int k = 1;
        while (!estColoriable(0, k, graphe.getListeDesSommets())) {
            k++;
        }
        return k;
    }

    /**
     * @return La table des couleurs associées à chaque sommet.
     */
    public Map<Integer, Integer> getCouleurs() {
        return couleurs;
    }

    /**
     * Affiche la coloration obtenue.
     */
    public void afficherColoration() {
        for (Map.Entry<Integer, Integer> entry : couleurs.entrySet()) {
            System.out.println("Sommet " + entry.getKey() + " → Couleur " + entry.getValue());
        }
    }
}
