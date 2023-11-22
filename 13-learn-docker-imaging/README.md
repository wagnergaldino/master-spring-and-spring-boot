use Dockerfile(vide Dockerfile) or maven build: spring-boot:build-image

run using: sudo docker container run -d -p 7000:7000 13-learn-docker-imaging:0.0.1-SNAPSHOT
for maven generated image or

sudo docker run -d -p 7000:7000 wagal/hello-world-docker:v3
for command line(Dockerfile) generated image