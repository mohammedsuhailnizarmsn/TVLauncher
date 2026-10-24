#!/bin/sh
# Simple wrapper to invoke gradle
if [ -z "$GRADLE_HOME" ]; then
    # This is a simplified version that expects gradle to be on path 
    # or handled by the GitHub Action's setup-java
    gradle "$@"
else
    $GRADLE_HOME/bin/gradle "$@"
fi
