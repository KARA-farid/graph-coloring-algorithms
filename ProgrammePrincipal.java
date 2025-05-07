package Graphe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Programme principal pour tester et comparer différents algorithmes
 * de coloration de graphes, et générer des fichiers CSV pour visualisation.
 */
public class ProgrammePrincipal {

    public static void main(String[] args) throws IOException {

        // Tailles de graphes à tester
        int[] tailles = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Fichier de sortie pour la comparaison des algorithmes
        FileWriter comparaison = new FileWriter("comparaison_algorithmes.csv");
        comparaison.write("Taille,Algorithme,Temps(ms),NombreCouleurs\n");

        // Pour chaque taille de graphe
        for (int taille : tailles) {
            // Création du graphe
            GrapheNonOriente graphe = new GrapheNonOriente();
            Random alea = new Random();

            for (int i = 0; i < taille; i++) graphe.ajouterSommet(i);

            // Ajout d’arêtes aléatoires
            for (int i = 0; i < taille * 2; i++) {
                int a = alea.nextInt(taille);
                int b = alea.nextInt(taille);
                if (a != b) graphe.ajouterLien(a, b);
            }

            // Liste des algorithmes à tester
            String[] algorithmes = {"Glouton", "WelshPowell", "DSatur", "Exact"};

            for (String algo : algorithmes) {
                Map<Integer, Integer> couleurs = new HashMap<>();
                long debut = System.currentTimeMillis();
                int nbCouleurs = 0;

                switch (algo) {
                    case "Glouton":
                        couleurs = ColorationGloutonne.colorier(graphe);
                        nbCouleurs = new HashSet<>(couleurs.values()).size();
                        break;

                    case "WelshPowell":
                        couleurs = ColorationWelshPowell.colorier(graphe);
                        nbCouleurs = new HashSet<>(couleurs.values()).size();
                        break;

                    case "DSatur":
                        couleurs = ColorationDSatur.colorier(graphe);
                        nbCouleurs = new HashSet<>(couleurs.values()).size();
                        break;

                    case "Exact":
                        ColorationExacte exacte = new ColorationExacte(graphe);
                        nbCouleurs = exacte.colorier();
                        couleurs = exacte.getCouleurs();
                        break;
                }

                long fin = System.currentTimeMillis();
                long temps = fin - debut;

                // Enregistrement dans le fichier de comparaison
                comparaison.write(taille + "," + algo + "," + temps + "," + nbCouleurs + "\n");

                // Export des fichiers CSV pour chaque algorithme
                graphe.exporterFichierLiens(algo + "_" + taille + "_liens.csv");
                graphe.exporterFichierSommets(algo + "_" + taille + "_sommets.csv", couleurs);
            }
        }

        comparaison.close();
        System.out.println("Comparaison terminée. Tous les fichiers CSV ont été générés !");
    }
}
