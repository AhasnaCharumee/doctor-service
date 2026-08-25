# Doctor Service

**Student Name:** Ahasna Charumee
**Student Number:** 241722057
**GCP Project ID:** project-f26e7e83-129c-40a6-977

## Project Description
Microservice responsible for managing doctor records in the City Care Hospital Management platform. Provides REST APIs to register doctors, retrieve the doctor roster, and upload supporting files to Google Cloud Storage. The Appointment Service verifies doctor records against this service when booking appointments.

## Technology Stack
- Java 25
- Spring Boot
- Spring Data MongoDB
- MongoDB (hosted on the backend VM)
- Google Cloud Storage client library (file upload)
- Spring Cloud Netflix Eureka Client
- Spring Cloud Config Client
- PM2 (process management)
- Deployed on Google Cloud Platform (Compute Engine, Managed Instance Group, Cloud Storage)

## Setup / Getting Started
1. Clone the repository
2. Build the project: `./mvnw clean package -DskipTests`
3. Run with PM2: `pm2 start ecosystem.config.js`
4. Service runs on port `8082`, connects to a MongoDB database (`doctor_db`), and registers itself with Eureka on startup.
5. File upload endpoint: `POST /api/doctors/files/upload` — stores uploaded files in the `eca-storage-project-f26e7e83` Google Cloud Storage bucket.

## Deployment
Deployed on a Google Compute Engine Managed Instance Group as part of the IaaS backend platform. Uses a non-relational database (MongoDB) running on the same backend VM. Managed by PM2 for automatic restart, and covered by auto-scaling and health checks. Demonstrates Google Cloud Storage integration via the file upload endpoint, using a service account with `roles/storage.objectAdmin`.