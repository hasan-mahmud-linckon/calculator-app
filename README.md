<div align="center">

# Calculator App

</div>

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)![Docker Hub](https://img.shields.io/badge/Docker_Hub-2496ED?style=for-the-badge&logo=docker&logoColor=white)![Ansible](https://img.shields.io/badge/Ansible-EE0000?style=for-the-badge&logo=ansible&logoColor=white)![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)![AWS EC2](https://img.shields.io/badge/AWS_EC2-FF9900?style=for-the-badge&logo=amazon-ec2&logoColor=white)

</div>

A simple REST API calculator application built with Spring Boot that provides basic mathematical operations: addition, subtraction, and multiplication. This repository also includes a complete CI/CD pipeline using GitHub Actions to build, test, containerize, and deploy to staging and production EC2 instances with automated smoke tests, rollback, and Discord notifications.

## Branching and Environments:

- Feature/bugfix work: feat/<feature-name>, bugfix/<bug-name>
- Staging environment: stage branch
- Production environment: main branch

## Pipeline at a Glance:

- Push to feat/** or bugfix/** → build-n-test.yml runs (build + unit tests + Docker build)
- Open PR to stage or main → on_pr.yml runs (unit tests + Docker build)
- Merge to stage → deploy_stage.yml runs (deploy to Staging EC2)
- Merge to main → deploy_prod.yml runs (deploy to Production EC2)
 
### CI/CD Workflow Documentation

Our project's CI/CD pipeline is managed via GitHub Actions with the following triggers:

- **Push to `feat/**` or `bugfix/**` branches**  
  Triggers: `build-n-test.yml`  
  Actions:
  - Set up JDK 17
  - Run unit tests: -Dtest="*ServiceTest"
  - Build Maven package  
  - Build Docker image tagged with commit SHA (not pushed)

- **Open a Pull Request to `stage` or `main`**  
  Triggers: `on_pr.yml`  
  Actions:  
  - Set up JDK 17
  - Run unit tests: -Dtest="*ServiceTest"
  - Build Docker image tagged pr-<PR_NUMBER> (not pushed) 

- **Merge to `stage`**  
  Triggers: `deploy_stage.yml`  
  Actions:  
  - Deploys the application to the Staging EC2 environment  
  - Smoke test health endpoint, auto-rollback on failure
  - Notify Discord channel about deployment status

- **Merge to `main`**  
  Triggers: `deploy_prod.yml`  
  Actions:  
  - Deploys the application to the Production EC2 environment  
  - Smoke test health endpoint, auto-rollback on failure
  - Discord notifications (success / rollback / failure)  

#### Branch Strategy

- Feature development occurs on `feat/**` branches
- Bugfixes occur on `bugfix/**` branches
- Integration occurs on the `stage` branch (Staging)
- Production code resides in the `main` branch

#### Environments

- **Staging EC2:** Used for pre-production validation. All code merges into `stage` trigger an automated deployment here.
- **Production EC2:** Only code merged into `main` is auto-deployed to the live environment.

#### Required Repository Secrets

- Docker Hub

  - DOCKER_USERNAME: Your Docker Hub username
  - DOCKER_PASSWORD

- Staging

  - EC2_STAGING_HOST
  - EC2_STAGING_USER
  - EC2_STAGING_PRIVATE_KEY
  - DISCORD_WEBHOOK_URL

- Production

  - EC2_PROD_HOSTS
  - EC2_PROD_USER
  - EC2_PROD_PRIVATE_KEY
  - DISCORD_WEBHOOK_URL

Refer to individual workflow `.yml` files for pipeline details and the [docs/README.md](README.md) for application details.