//#FILENAME:scripts/start-prod.sh:write-always:755
#!/usr/bin/env bash

trap "exit" INT TERM ERR
trap "kill 0" EXIT

mvn spring-boot:run "$@" &

wait