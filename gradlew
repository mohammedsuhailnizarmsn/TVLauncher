#!/bin/sh
# This is a simplified wrapper to ensure we use the specified version
# and not the system's Gradle 9.8.1
set -e
if [ "x$JAVA_HOME" = "x" ]; then
    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
fi
exec gradle assembleDebug
