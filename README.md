# API Blog Management

Cette API permet de gérer des articles de blog, y compris la création, la lecture, la mise à jour et la suppression d'articles et de commentaires, avec une base de données PostgreSQL.

## Prérequis

- Java 17, 21, 22 (ou supérieur)
- **Maven** (pour la gestion des dépendances)
- **PostgreSQL** (installé et configuré localement)

## Installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/loickenmoe/API-Blog-Management
   cd API-Blog-Management

2. **Configurer la base de données PostgreSQL :** :   
   -Créez une base de données nommée blog_db :
   "CREATE DATABASE blog_db;"
   -Vérifiez les identifiants dans application.properties :
     spring.datasource.username=postgres
     spring.datasource.password=Lucas1998*
     spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db


## Lancer l'application 
   "mvn spring-boot:run"
   -L'API sera disponible sur http://localhost:9010.

##   Utilisation de l'application :
      Endpoints

      Méthode	   Endpoint	                      Description
       GET	        /articles	                  Lister tous les articles
       POST	        /articles	                  Créer un nouvel article
       GET	        /articles/{id}	              Obtenir un article par ID
       PUT	        /articles/{id}	              Mettre à jour un article par ID
       DELETE	    /articles/{id}	              Supprimer un article par ID
       POST	        /articles/{id}/comments	      Ajouter un commentaire à un article
       GET	        /articles/{id}/comments	      Lister les commentaires d'un article
       DELETE	    /comments/{id}	              Supprimer un commentaire par ID

## Lien Swagger :
   http://localhost:9010/swagger-ui/index.html

##  Exemples de requêtes :

    -Créer un nouvelle article :
    POST http://localhost:9010/articles
    Content-Type: application/json
    {
    "title": "Introduction à Spring Boot",
    "content": "Spring Boot facilite le développement d'applications web Java."
    }

    Reponse attendue:
    {
    "id": 5,
    "title": "Introduction à Spring Boot",
    "content": "Spring Boot facilite le développement d'applications web Java.",
    "publishedAt": "2025-03-27T11:05:49.7210984",
    "comments": []
    }
    
    -Lister tous les articles :
    GET http://localhost:9010/articles
    Reponse attendue:
    [
    {"id":1,"title":"Mon premier article","content":"Ceci est le contenu de l'article.","publishedAt":"2025-03-26T15:38:14.360567","comments":[]},
    {"id":2,"title":"Mon premier article","content":"Ceci est le contenu de l'article.","publishedAt":"2025-03-26T15:42:41.47467","comments":[]},
    {"id":4,"title":"string","content":"string","publishedAt":"2025-03-27T10:07:13.825976","comments":[]},
    {"id":5,"title":"Introduction à Spring Boot","content":"Spring Boot facilite le développement d'applications web Java.","publishedAt":"2025-03-27T11:05:49.721098","comments":[]}
    ]
    
    -Supprimer un articles :
    DELETE http://localhost:9010/articles/2
    
    si on consulte la liste de tous les articles à nouveau, on obtient:
    [
    {"id":1,"title":"Mon premier article","content":"Ceci est le contenu de l'article.","publishedAt":"2025-03-26T15:38:14.360567","comments":[]},
    {"id":4,"title":"string","content":"string","publishedAt":"2025-03-27T10:07:13.825976","comments":[]},
    {"id":5,"title":"Introduction à Spring Boot","content":"Spring Boot facilite le développement d'applications web Java.","publishedAt":"2025-03-27T11:05:49.721098","comments":[]}
    ]


  