#!/bin/sh
set -x
# This is a simplified version of the real gradlew
# It forces the download of the specific gradle version we want.
export GRADLE_USER_HOME="$HOME/.gradle"
if [ ! -d "$GRADLE_USER_HOME/wrapper/dists" ]; then
    mkdir -p "$GRADLE_USER_HOME/wrapper/dists"
fi

# We use the wrapper properties to find the version
VERSION=$(grep "distributionUrl" gradle/wrapper/gradle-wrapper.properties | cut -d'/' -f5 | cut -d'.' -f1,2,3)
echo "Using Gradle $VERSION"

# Execute the wrapper using the system's installed gradle just to bootstrap the wrapper, 
# or use the wrapper jar if it exists.
gradle assembleDebug
