# API de Gestion de Blog
Cette API permet de gérer un blog en permettant aux utilisateurs de publier des articles et d'ajouter des commentaires.

## Prérequis
- Java 22 (ou supérieur)
- Maven (pour la gestion des dépendances)
- PostgreSQL (pour la persistance des données)

## Installation

### Cloner le dépôt :
```bash
    git clone https://github.com/loickenmoe/Blog-Management-API.git
    cd Blog-Management-API

###  Configurer la base de données :
    spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
    spring.datasource.username=postgres
    spring.datasource.password=Lucas1998*

### Lancer l'application :
    mvn spring-boot:run


##  Utilisation de l'API
  Méthode	  Endpoint	                    Description
    POST	    /api/articles	                Ajouter un nouvel article
    GET	        /api/articles	                Récupérer tous les articles
    GET	        /api/articles/{id}	            Récupérer un article par ID
    PUT	        /api/articles/{id}	            Modifier un article
    DELETE	    /api/articles/{id}	            Supprimer un article
    POST	    /api/articles/{id}/comments	    Ajouter un commentaire à un article


## Lien Swagger 
    http://localhost:9010/swagger-ui.html

##Exemples de requêtes
    - Ajouter un article
        POST  http://localhost:9010/articles
        {
          "title": "Introduction à Spring Boot",
          "content": "Spring Boot facilite le développement d'applications..."
        }
    - Reponse Attendu
        {
            "id": 2,
            "title": "Mon premier article",
            "content": "Ceci est le contenu de l'article.",
            "publishedAt": "2025-03-26T15:42:41.4746695",
            "comments": null
        }

    - Ajouter un commentaire
        POST http://localhost:9010/comments/1
        {
          "author": "Alice",
          "content": "Super article !"
        }
        
    - Reponse Attendu
        