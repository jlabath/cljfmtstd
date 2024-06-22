#!/usr/bin/env fish

# set JAVA_HOME first
set -lx JAVA_HOME /Library/Java/JavaVirtualMachines/jdk-22-oracle-graalvm-community.jdk/Contents/Home

# update paths
set -p PATH $JAVA_HOME/bin


# finally call native image
# command native-image $argv
# for some reason this works - where the $argv did not
# could be fish shell thing

command native-image --report-unsupported-elements-at-runtime --initialize-at-build-time --no-server -jar $argv[1] -o $argv[2]
