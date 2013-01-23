#!/bin/bash

# crmF local development start-up script
# basically just sets-up the database credentials and starts up jetty

# variations of the same maven run command

# mvn org.mortbay.jetty:maven-jetty-plugin:run
# java -jar target/endorsed/jetty-runner.jar target/*.war


export CLEARDB_DATABASE_URL=mysql://root:h@localhost/crm_framework
# echo $CLEARDB_DATABASE_URL

# this is how to get the cleardb config url from heroku toolbelt
# heroku config | grep CLEARDB_DATABASE_URL

# necessary for jetty auto reload scanner

export MAVEN_OPTS="-Xmx1024m -XX:MaxPermSize=512m -XX:PermSize=512m"
mvn jetty:run
