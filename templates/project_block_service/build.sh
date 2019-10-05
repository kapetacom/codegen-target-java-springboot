//#FILENAME:scripts/build.sh:write-always:755
#!/usr/bin/env bash
mvn -U clean compile "$@"