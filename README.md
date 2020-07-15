# products-api
Create a postgres deployment: 

kubectl apply -f postgres-config.yaml

Map hostname to the ip of the service created with postgres-config:

kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")

Build image:

docker build ./ -t <repo name>/<img name>
  
Change repo name in deployment.yaml file

Create deployment for application:

kubectl apply -f deployment.yaml
