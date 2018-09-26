#!/usr/bin/env bash

# Script to deploy the app
deploy(){
# From the remote host-machine, run the following cmd
    docker pull s34n/sciroc-img
    docker run --name='sciroc' -d -it -p 80:8000 s34n/sciroc-img && docker logs sciroc -f
}

# Tag-And-Push Script to tag & push the app
tagAndPush(){
    docker tag sciroc-img:latest s34n/sciroc-img:latest
    docker push s34n/sciroc-img:latest
}

# Rebuild-Script to clean & build the app using the Dockerfile script
rebuild(){
    gradle clean
    gradle build
    docker build -f Dockerfile -t sciroc-img . --no-cache
    tagAndPush
}

# Let's get rid of the pre-existing docker images on the machine.
if [[ ! -z "$(docker container ps | grep sciroc)" ]]; then
    echo "Sciroc-Service Docker Container Found"
    docker stop sciroc && docker rm sciroc && docker rmi sciroc-img
    rebuild
else
    echo "Sciroc-Service Docker Container NOT Found"
    rebuild
fi

