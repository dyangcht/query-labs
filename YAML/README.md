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
$ oc apply -f 06-people-svc.yaml
```

### 前端用 spring boot 
```
$ oc apply -f 07-ui-deployment.yaml
$ oc expose svc spring-boot-ui
$ oc get route
$ curl spring-boot-ui-demo.apps.cluster-99ee.sandbox1882.opentlc.com
```

### Deploy Quarkus backend service "people" version 2
``` $ oc apply -f 09-people-dc.yaml ```

### Apply the version 2 of service
```
$ oc apply -f 10-people-svc.yaml
```
