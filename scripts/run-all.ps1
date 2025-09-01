Write-Host "Starting Eureka -> Customer -> Admin -> Gateway ..."
Start-Process powershell -ArgumentList "-NoExit","-Command","cd .\eureka-server; mvn -q -DskipTests spring-boot:run"
Start-Sleep -Seconds 6
Start-Process powershell -ArgumentList "-NoExit","-Command","cd .\customer-service; mvn -q -DskipTests spring-boot:run"
Start-Sleep -Seconds 3
Start-Process powershell -ArgumentList "-NoExit","-Command","cd .\admin-service; mvn -q -DskipTests spring-boot:run"
Start-Sleep -Seconds 3
Start-Process powershell -ArgumentList "-NoExit","-Command","cd .\api-gateway; mvn -q -DskipTests spring-boot:run"
