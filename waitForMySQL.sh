#!/bin/sh
# wait until MySQL is really available
maxcounter=45;
counter=1;
while ! mysql -u "app_user" -p "test123" -e "show databases;" > /dev/null 2>&1; do
    sleep 1
    counter=`expr $counter + 1`
    if [ $counter -gt $maxcounter ]; then
        >&2 echo "We have been waiting for MySQL too long already; failing."
        
        mysql -u "app_user" -p "test123" -e "create database spring_app_db"
        java -jar amazingco-api-0.0.1-SNAPSHOT.jar
    fi
done

