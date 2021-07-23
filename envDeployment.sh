#!/bin/bash
git pull
mvn clean package
docker build . -t gcr.io/sab-ors-poc-sbx-01-9096/et-traffice-generator
docker push gcr.io/sab-ors-poc-sbx-01-9096/et-traffice-generator:latest
kubectl apply -f deployment.yaml