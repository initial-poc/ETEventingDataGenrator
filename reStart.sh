#!/bin/bash
kubectl scale --replicas 0 deployment/et-traffice-generator-deployment
kubectl scale --replicas 1 deployment/et-traffice-generator-deployment