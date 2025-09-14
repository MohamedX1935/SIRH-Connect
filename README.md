# SIRH Connect

Application web full stack pour la gestion des ressources humaines.

## Démarrage rapide

### Prérequis
- Docker et Docker Compose

### Lancement
```bash
docker-compose up --build
```

L'API est disponible sur `http://localhost:8080` et l'interface Angular sur `http://localhost:4200`.

Identifiants par défaut :
- admin / password
- hr / password
- employee / password

## Architecture
- **Backend** : Spring Boot, JPA, Security JWT
- **Frontend** : Angular + Tailwind CSS
- **Base de données** : PostgreSQL
- **CI/CD** : GitLab CI

## Modules
- Gestion des employés (CRUD)
- Gestion des congés (demande, validation)
- Gestion des présences
- Paie (calcul simple)
- Tableau de bord RH
- Authentification JWT (Admin, RH, Employé)

## Scripts PowerShell
Des scripts d'import/export CSV sont disponibles dans le dossier `scripts`.

## Schéma base de données
Le fichier `db/schema.sql` décrit les tables principales de l'application.
