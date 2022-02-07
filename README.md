# Query Lab

### 後端用 Quarkus
### 預設會將 Quarkus Application Push 至 OpenShift Server，所以要先用 oc login
``` $ mvn clean package ```

### 前端用 spring boot 
``` $ oc new-app openjdk-11-rhel8:1.0~https://github.com/dyangcht/query-labs.git --context-dir=spring-boot-ui --name spring-boot-ui ```
