docker run -d -p 27017:27017 --name mongo-demo -v ~/data:/data/db mongo
docker run --name consul-demo -p 8500:8500 consul
docker run -d --name zipkin-demo -p 9411:9411 openzipkin/zipkin
