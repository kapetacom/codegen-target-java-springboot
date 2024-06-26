#!/usr/bin/env bash

jest --testMatch '<rootDir>/test/**/*.test.ts' || exit $?

cd test/resources/examples/users || exit
TEMP_DIR=$(mktemp -d)
if ! mvn clean package -q; then
  RESULT=$?
  rm -rf "$TEMP_DIR"
  exit $RESULT
fi
rm -rf "$TEMP_DIR"
cd - || exit 2

TEMP_DIR=$(mktemp -d)
cd test/resources/examples/todo || exit
if ! mvn clean package -q; then
  RESULT=$?
  rm -rf "$TEMP_DIR"
  exit $RESULT
fi
rm -rf "$TEMP_DIR"
exit 0
