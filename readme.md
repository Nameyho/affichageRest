# affichageRest


Ceci est la partie Back-end de mon projet de fin d'étude celui-ci posséde plusieurs caractéristiques : 

- Utilisation de Spring-boot pour mettre en place un serveur Tomcat; 
- Utilisation de JPA/Hibernate pour la persistence de mes données;
- Sécurisation de mes données avec Spring Security;
- Formatage et envoie de données en JSON
- Persistence de données reçues en JSON





























16 aout …

ajout d'info dans le JSON EcranAbsenceQueryDTO

15 aout …

Ajout d'un controller de personne par numero unique

14 aout …

augmentation de la taille des messages


11 aout …

suite des ajout des requetes par écran specifique

10 aout …

ajout de la fonction findAllByEcranResultatID_IdEcran

4 aout …

ajout du numero unique dans le json des resultats

4 aout …

ajout pour l'uniformisation du code unique des personnes

3 aout …

Ajout du numéro unique à 7 chiffres

2 aout …

suppression de variables inutiles

19 juillet …

creation du controller ecran

17 juillet

Rajout des affectation des dates début et fin de cours …


15 juillet …

correction d'un petit oublie sur le CoursQueryDTO

9 juillet …

Création de EcranMessage

dto,service,dao,controller,etc...

8 juillet …

Création EcranResultat.java

ainsi que service,DTO,Controller,DAO

question sur l'utilité de pouvoir mettre a jour ceci vu que les seuls info sont les composant de la clef 
primaire composé et que donc la modifié amenera a faire une nouvelle entrée

7 juillet …

début de ecran résultat


6 juillet 

Modification de PersonResultat

ainsi que le création de AbsenceEcran dans le but de faciliter la créationd d'un écran d'affichage d'absence.

d'autre Ecran sont prévu

5 juin

petite modification pour la PersonIndisponibiliteController
PersonIndisponibiliteServiceImplement.java

30 juin

modification de la classe personneIndisponibile afin de gérer au mieux le get specifique a une absence

29 juin

modification dans le DTO indisponibilite
correctif update Message

24 juin

FindallBYrole : creation

18-19 juin

vérification des endpoint

+

modification de la classer user et persons

17 Juin

Changement de l'API pour fournir des données plus précises et plus claires

changement des DTO

6 juin

création d'une méthode afin d'obtenir les résultat par person

PersonResultatController.getResultatPersonne

mise à jours des modeles afin d'obtenir un identifiant unique basé sur les bytes


4 Juin

création d'une méthode afin d'obtenir les résultat par person

PersonResultatController.getResultatPersonne

28 mai : création du controller CoursEnsController aprés avoir oublié de le faire 

27 mai: création du controller PersonResultat aprés avoir oublié de le faire

+

création du controller PersonIndisponibiliteController

25 mai : petit mise a jour

24 mars : creation de la couche dao,service et controller des personnes

31 mars : creation de la couche dao,service et controller des Cours

1 avril :  creation de la couche dao,service et controller des Messages,Indisponibilites,Roles

3 avril : creation dao couche intermediaire

7 avril : DTO_person 
création de create et update dto

8 avril , personGetDto

création de la commande get{id} ; get et delete

10 avril, DTO_role

création de la commande get{id},get,delete,create,update

12 avril : création DTO de la classe Message

Get,Get{id},update;create,delete

+

réparation bug de JSON qui boucle dans persondto

12 avril

création de la couche DTO de CoursEnseigneRepository

ainsi qu'un controller GlobalController

13 avril

création de la couche DTO de CoursRepository

14 avril

mise à jour des fichiers au niveau des id

création de la clé composite de coursenseigne pour la couche dto

17 avril

fin de la couche DTO


21->25 avril

spring security

basic auth

28 avril

petite mise a jour de la bdd

30 avril

Mise à jour des vérifications d'entrée dans le formulaire

+

Data Loader pour données de test

