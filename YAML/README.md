# Blue-green deployment testing

### 此版使用藍綠部署，前一版則使用 Rolling Upgrade
### 先從 DB's Operator 建立起
``` 
$ oc login -u admin -p pwd https://api.ocp4.com:6443
$ oc new-project demo
$ oc apply -f 01-og.yaml
$ oc apply -f 02-sub.yaml
```
Waiting for an operator pod running
```
$ oc apply -f 03-db.yaml
```

Prepare the ConfigMap & Secrets
```
$ oc apply -f 04-cm.yaml
```
### Deploy Quarkus backend service "people"
```
$ oc apply -f 05-people-dc.yaml

```

### 前端用 spring boot 
``` $ oc new-app openjdk-11-rhel8:1.0~https://github.com/dyangcht/query-labs.git --context-dir=spring-boot-ui --name spring-boot-ui ```
