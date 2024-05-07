#!/usr/bin/env bash
if ! jest --testMatch '<rootDir>/test/**/*.test.ts'; then
  exit $RESULT
fi
cd test/resources/examples/users || exit
TEMP_DIR=$(mktemp -d)
if ! mvn clean package -q; then
  rm -rf $TEMP_DIR
  exit $RESULT
fi
rm -rf $TEMP_DIR
cd - || exit

TEMP_DIR=$(mktemp -d)
cd test/resources/examples/todo || exit
if ! mvn clean package -q; then
  rm -rf $TEMP_DIR
  exit $RESULT
fi
rm -rf $TEMP_DIR
cd - || exit
