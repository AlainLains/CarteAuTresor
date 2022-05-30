# Carbon IT - Carte au trésor
Ce projet est un exercice proposé par Carbon IT pour faire valoir ce que de droit.

## Contexte
L'objectif est de réaliser le suivi d'un aventurier sur une carte générée à l'aide d'un fichier d'entrée.<br>
Ce suivi est fait par la rédaction d'un fichier de sortie qui sert de compte-rendu d'une exploration.

## Lancement du projet
Une fois le projet cloné, vous pouvez utiliser votre IDE afin de lancer le projet.<br><br>
**Attention :** Il est nécessaire de saisir un argument qui correspondra au chemin d'accès du fichier d'entrée (vous pouvez trouver des exemples de fichier d'entrée dans le dossier <u>"ressources"<u> du projet).<br><br>

Vous pourrez également gérer tout ça en lignes de commandes. Allez à la racine du fichier et faites un **mvn clean install**.<br>
Allez dans le dossier <u>"target"</u> et saisissez la commande suivante :<br>
- **java -jar .\CarteAuTresor-1.0-SNAPSHOT.jar [chemin_du_fichier_source]**

## Architecture
Le projet est décomposé comme ceci :
  - **models** : contient les différents objets qui seront créés au cours de l'application (Aventurier, Case et Coordonnées),
  - **services** : correspond à la partie fonctionnelle du projet. Il contient les fonctions utilisées pour faire vivre les objets au cours de l'application,
  - **utils** : correspond à la partie technique du projet. Il contient les fonctions de lecture et d'écriture de fichiers.
  - **MainCarteAuTresor.java** : main de l'application,
  - **ressources** : contient des exemples de fichier d'entrée,
  - **test** : contient les tests unitaires.

## Axes d'améliorations identifiés
- Peu de connaissances sur les tests unitaires
- Redondance entres les fonctions turnLeft et turnRight dans ***AventurierMouvementsService.java***
- Gestion des exceptions
  
## Versions
- Java 11<br>
- JUnit 5<br>
- Maven 3<br>
- Intellij IDEA<br>
