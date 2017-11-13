Les services fournit par l'API: 

- http://localhost:8080/interface/v1/perm/create : ce service permet de créer un nouvel utilisateur.
- http://localhost:8080/interface/v1/perm/authenticate: ce service permet à un utilisateur de s'authentifier en utilisant ses credentials
- http://localhost:8080/interface/v1/auth/get-favourite-activities: ce service permet de récupérer les activités favorite de l'utilisateur
- http://localhost:8080/intefrace/v1/auth/get-favourite-locations: ce service permet de récupérer les regions favorites de l'utilisateur
- http://localhost:8080/interface/v1/auth/generated-proposal: ce service permet de suggérer des activitiés à l'utilisateur en fonction de la météo
- http://localhost:8080/interface/v1/perm/logout: ce service permet de se déconnecter de l'application 
- http://localhost:8080/interface/v1/auth/request-deletion : ce service permet de demander un email qui va être envoyer à la boite mail renseigné au debut pour supprimer un compte .
- http://localhost:8080/interface/v1/auth/generated-proposal: ce service permet de proposer aux utilisateurs des activitiés en fonction de la météo.
- http://localhost:8080/interface/v1/perm/validate-mail: ce service permet à un utilisateur de valider son email.
- http://localhost:8080/interface/v1/perm/check-email: ce service permet de vérifier, lors de la création d'un nouveau compte, si l'email saisit par l'utilisateur n'existe pas déjà dans la base de données(si ce dernier existe un message d'erreur est affichée sur l'interface demandant à l'utilisateur de changer d'adress mail vue que celle-ci existe déjà)
- http://localhost:8080/interface/v1/perm/check-username: ce service permet de vérifier, lors de la création d'un nouveau compte, si le nom d'utilisateur saisit par l'utilisateur n'existe pas déjà dans la base de données(si ce dernier existe un message d'erreur est affichée sur l'interface demandant à l'utilisateur de changer le nom d'utilisateur vue que celle-ci existe déjà)
- http://localhost:8080/interface/v1/perm/update-weathe: ce service devrait mettre à jour la météo chaque mardi (pas implémenter)
- http://localhost:8080/interface/v1/perm/request-current-weather: ce service permet de récuperer la météo en lui specifiant la région


L'état d'avancement du projet actuel est tel que : 
les services sont disponible et fonctionnel 
sur l'IHM il est actuellement possible de se connecter déconnécté, créer un utilisateur dans la base de données, l'application renvoie aussi  

Comment exécuter l'application : 
créér une base de donnée sous mysql "TAA_PROJECT" bien veiller à garder le même nom
jouer le script de création des tables avec le script fournis alter createtable.sql
jour le script des données alter_data.sql
lancer le serveur nginx avec la commande ng serve à l'interieur du projet weekend-advisor (front_TAA)
faire un maven package sur partie rest pour créer le jar correspondant  mvn package -e 
faire un java -jar sur le jar généré dans le dossier target par la commande précédente 
se connecter sur localhost:4200
se connecter sur l'ihm avec l'utilisateur zigh, password : hakima