#mvn org.mortbay.jetty:maven-jetty-plugin:run
#java -jar target/endorsed/jetty-runner.jar target/*.war

#export CLEARDB_DATABASE_URL='mysql://b2ea198aa681b2:79f8c401@us-cdbr-east-02.cleardb.com/heroku_dde7524bbccd5bf?reconnect=true'
export CLEARDB_DATABASE_URL=mysql://root:h@localhost/crm_framework
echo $CLEARDB_DATABASE_URL

#heroku config | grep CLEARDB_DATABASE_URL

mvn jetty:run