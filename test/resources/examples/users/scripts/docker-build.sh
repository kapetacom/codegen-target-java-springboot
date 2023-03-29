#!/usr/bin/env bash
echo "Building jar file";
mvn -U clean package "$@" || exit 1

echo "Building docker image";
docker build . -t kapeta/users || exit 1

echo "Done. Image ready: kapeta/users";
