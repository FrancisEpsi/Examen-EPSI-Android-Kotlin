# Examen-EPSI-Android-Kotlin
Projet d'examen pour l'école EPSI sur du développement Android Kotlin avec Android Studio pour valider le module de 20H

## Conditions de développement
- Pas d'utilisation de l'émulateur (ne fonctionne pas sur mon ordinateur de développement)
- Débuggage uniquement sur mon téléphone Samsung Galaxy S20FE sous Android 11 avec la surcouche Samsung One UI en version 3.1
- Mon téléphone est configuré en français
- Mon téléphone à le DarkMode d'activé
- Développement sous Android Studio Artic Fox | 2020.3.1 Patch 3

## Fonctionnalitées
- Prise de charge de la langue anglais (défaut) et français (avec un dossier values-fr dans la solution android)
- Conçu pour les différents modes d'affichage (LightMode et Darkmode)
- Affichage des informations sur le développeur (Etape 1 du cahier des charges)
- Visite des catégories et produits d'un magasin grâce à l'utilisation de requête HTTP vers une Web API retournant du JSON (étape 2)
- Page de crédit des images (ou sont nommés tous les designers/graphistes des icônes utilisées dans l'application)
- [BONUS] Fonctionnalitée permettant de noter l'application (et voir son dernier vote) grâce à des requête HTTP sur un serveur (Backend web en php).


## Objectifs
- Utiliser au maximum les ressources strings plutôt que d'insérer un string hardcodé dans le code
- Être clair dans les conventions de nommage.
- Design simple et soigné

## Objectifs manqués
- Utiliser le ScrollView au maximum.
- Utilisation systématique des thèmes (car ça peut être pratique).
- Pas d'affichage de Progressbar durant les opérations asynchrones (+ cacher / afficher des contrôles)
- Je n'ai pas eu le temps de regarder comment changer la couleur de fond d'un élément lorsqu'on pose le doigt dessus (OnTouchListenner ?) Par exemple pour stylisé les éléments du RecycleView.
- Je n'ai pas vraiment encore compris tout ce qu'il se passe derrière le RecycleView.

