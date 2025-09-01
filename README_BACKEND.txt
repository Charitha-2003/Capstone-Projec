Insta Approval - Backend (Eureka + Gateway + Customer + Admin)

Services & Ports
- eureka-server     : 8761  (http://localhost:8761)
- customer-service  : 8081
- admin-service     : 8082
- api-gateway       : 8080  (routes /api/customer/** and /api/admin/** via Eureka)

Run (Windows PowerShell)
1) Open this folder (contains eureka-server/, api-gateway/, customer-service/, admin-service/)
2) Run: .\scripts\run-all.ps1
3) Check:
   - Eureka Dashboard: http://localhost:8761
   - Gateway health:   http://localhost:8080/actuator/health
   - Try list pending: GET http://localhost:8080/api/admin/loans/pending

Manual
- cd eureka-server;    mvn -q -DskipTests spring-boot:run
- cd customer-service; mvn -q -DskipTests spring-boot:run
- cd admin-service;    mvn -q -DskipTests spring-boot:run
- cd api-gateway;      mvn -q -DskipTests spring-boot:run

Prereqs
- Java 17+, Maven, Internet access for dependencies.
