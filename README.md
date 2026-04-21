# SameGame 

Notre projet **"SameGame"**, un jeu de réflexion et d'élimination de blocs. Ce projet a été réalisé dans le cadre de la **SAÉ 2.1** de l'IUT de Sénart-Fontainebleau.

## Description du projet

**SameGame** est un jeu de plateau où le but est d'éliminer des groupes de blocs adjacents de même couleur pour vider la grille et obtenir le score le plus élevé. Le logiciel propose une interface graphique complète avec la gestion des scores, des thèmes visuels et différentes interactions à la souris.

Ce projet a été développé en **Java** en respectant les principes de la programmation orientée objet et les consignes pédagogiques.

## Compilation et exécution

### Pré-requis

- **Java JDK** (version 17 ou supérieure recommandée)
    
- L'outil **Make** installé sur votre système
    

### Compilation

On utilise le fichier `Makefile` pour compiler l'ensemble des classes Java avec la commande :

Bash

```
make
```

### Exécution du programme

Pour lancer le jeu une fois la compilation terminée, utilisez la commande :

Bash

```
make run
```

### Création de la documentation Javadoc

Vous pouvez générer la documentation technique du projet (fichiers HTML) via Javadoc grâce au Makefile :

Bash

```
make javadoc
```

### Nettoyage des fichiers compilés

Pour supprimer les fichiers `.class` et réinitialiser le répertoire de travail, utilisez :

Bash

```
make clean
```

## Rapport

Le rapport complet de la SAÉ, détaillant les choix de conception et les algorithmes utilisés (notamment dans `Algojeu.java`), est disponible à la racine du projet sous le nom : **RAPPORT_SAE21_2024_MIEKISIAK_TRAN.pdf**

---
