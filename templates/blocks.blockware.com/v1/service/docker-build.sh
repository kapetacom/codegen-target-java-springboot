//#FILENAME:scripts/docker-build.sh:write-always:755
#!/usr/bin/env bash
echo "Building jar file";
mvn -U clean package "$@" || exit 1

echo "Building docker image";
docker build . -t {{lowercase data.metadata.name}} || exit 1

echo "Done. Image ready: {{lowercase data.metadata.name}}";
