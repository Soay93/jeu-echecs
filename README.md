# Jeu d’échecs en Java (console)

Projet de SAE réalisé en binôme : implémentation d’un **jeu d’échecs jouable en console entre deux joueurs humains**, en Java orienté objet.

Le programme :
- demande les noms des joueurs,
- affiche l’échiquier en texte,
- vérifie la validité des coups selon les règles de base,
- garde l’historique des coups,
- détecte la fin de partie (échec et mat) et annonce le gagnant.

---

## Objectifs pédagogiques

- Concevoir un **modèle objet complet** pour un jeu d’échecs (Partie, Joueur, Échiquier, Case, Pièces…).
- Appliquer l’**héritage** et le **polymorphisme** via une classe abstraite `Piece` et ses spécialisations.
- Gérer une boucle de jeu complète : saisie des coups, validation, historique, détection de fin de partie.
- Produire une **modélisation UML** cohérente avec l’implémentation.

---

##  Fonctionnalités

- Jeu d’échecs **2 joueurs humains** (pas d’IA).
- Saisie et affichage des noms des joueurs.
- Affichage de l’échiquier en mode texte.
- Vérification de la validité des coups pour chaque type de pièce gérée.
- Mise à jour de l’échiquier après chaque coup.
- Historique des coups joués.
- Détection de l’échec et mat et annonce du vainqueur.

### Pièces implémentées

- `Tour`
- `Fou`
- `Dame`
- `Roi`
- `Pion`

### Limitations connues

- Le **Cavalier** n’est pas implémenté (déplacement en “L” non traité dans ce projet).
- Pas de **gestion du temps** (horloge) pour les joueurs.
- Pas de **roque**, **promotion du pion** ni **prise en passant** (non demandés dans la version simplifiée du sujet).

---

## Architecture du projet

Le projet suit une architecture orientée objet structurée autour des classes suivantes :

- `Partie`  
  Gère la boucle de jeu : contient les deux joueurs, l’échiquier et l’`historiqueCoups`.  
  Méthodes principales : démarrer la partie, jouer les coups, vérifier la fin de partie (échec et mat).

- `Joueur`  
  Représente un joueur avec son nom et sa couleur (blanc/noir).  
  Gère aussi éventuellement des informations de temps de jeu.

- `Echiquier`  
  Représente le plateau 8x8. Contient les 64 `Case`, permet de placer/déplacer les pièces et de vérifier si un chemin est libre pour un déplacement.

- `Case`  
  Représente une case de l’échiquier (colonne, rangée) et peut contenir 0 ou 1 `Piece`.  
  Permet de savoir si la case est occupée et de récupérer sa position en notation d’échecs.

- `Piece` (classe abstraite)  
  Classe mère de toutes les pièces : couleur, position, information sur le premier coup, etc.  
  Chaque sous-classe définit sa propre logique de déplacement via une méthode dédiée (ex. `deplacement()`).

- Spécialisations de `Piece`  
  - `Tour`  
  - `Fou`  
  - `Dame`  
  - `Roi`  
  - `Pion` (avec une logique spécifique pour ses déplacements et captures)

Les relations entre ces classes (association, héritage, composition) sont décrites dans les diagrammes UML fournis avec le rendu du projet.

---

## Technologies

- **Langage :** Java (JDK 8+ recommandé)
- **Interface :** console / texte
- **Paradigme :** Programmation orientée objet (héritage, polymorphisme, encapsulation)

---

## Compilation & exécution

Depuis un terminal :

1. Se positionner dans le dossier contenant les fichiers `.java` :

   ```bash
   cd SAE_Java_Echecs_AMMOUR_MESLIN

2. Compiler tous les fichiers `.java` :
   
   ```bash
   javac *.java

4. Lancer le programme via la classe principale :
   
   ```bash
   java Main 
  

