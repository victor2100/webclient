#!/bin/bash
#mvn assembly:assembly -DdescriptorId=jar-with-dependencies -Dmaven.test.skip=true
mvn package -Dmaven.test.skip=true
cp target/webclient-*-dependencies.jar .
sudo java -jar webclient-*-dependencies.jar config
