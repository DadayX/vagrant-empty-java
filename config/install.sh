#!/bin/sh
####################
#   
#   script: %install.sh%
#   description: % install all dependecies and packages %
#
####################

echo "update package and repository ... "
sudo apk update && apk upgrade
sudo mkdir ~/bkp/
echo "Install JDK 8.."
sudo apk add openjdk8

echo "Install MySQL 5.7 ..."
sudo apk add mysql mysql-client
sudo cp -p /etc/mysql/my.cnf ~/bkp/

echo "Install tomcat ..."
sudo apk add wget tar gzip
sudo mkdir -p /opt/tomcat /root/bin
cd /root/bin
wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.73/bin/apache-tomcat-9.0.73.tar.gz
tar -xzf apache-tomcat-9.0.73.tar.gz  --strip-components 1 --directory /opt/tomcat

########## Install GIT ##########
echo "Install GIT........"
sudo apk add git



