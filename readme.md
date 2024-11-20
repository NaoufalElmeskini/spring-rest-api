
local baseUrl : http://localhost:8080

usecase 0 : statut de l'application
    url : {baseUrl}/rest-api/status 

usecase 1 : recuperer produit 
    prerequis : demarrer price api
    url : {baseUrl}/rest-api/product/1


---
backlog désiré : 
- ajouter wiremock
- ajouter swagger
- organiser en architecture hexagonale