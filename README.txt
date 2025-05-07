#  Algorithmes de Coloration de Graphes en Java

Ce projet implémente **quatre algorithmes de coloration de graphes non orientés** :

-  Glouton
-  Welsh-Powell
-  DSatur
-  Coloration exacte (backtracking)

Il permet de comparer leur performance sur des graphes générés aléatoirement, en mesurant :

- Le **nombre de couleurs utilisées**
- Le **temps d’exécution**
- La **complexité algorithmique observée**

---

##  Objectifs pédagogiques

- Implémenter différentes stratégies de coloration de graphes
- Travailler avec des structures de données orientées objet (Java)
- Comparer les algorithmes à l’aide de données expérimentales
- Visualiser les résultats et tirer des conclusions sur l’efficacité

---
Les fichiers *_liens.csv et *_sommets.csv peuvent être importés dans Cytoscape pour visualiser les colorations des sommets.

liens.csv : structure du graphe (arêtes)

sommets.csv : ID + couleur (affichable sous forme de style de nœuds)

Cela permet de comparer visuellement les résultats produits par les différents algorithmes.

---
Le fichier comparaison_algorithmes.csv peut être importé dans Canaries, un outil d’analyse expérimentale.

Cela permet de :

Générer des graphiques (temps d’exécution, nombre de couleurs)

Comparer visuellement les performances en fonction de la taille du graphe

Étudier la complexité expérimentale

