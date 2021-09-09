#!/bin/bash
kubectl delete deployment et-traffice-generator-deployment
git pull
mvn clean package
docker build . -t gcr.io/sab-order-service-sbx/et-traffice-generator
docker push gcr.io/sab-order-service-sbx/et-traffice-generator:latest
kubectl apply -f deployment.yaml