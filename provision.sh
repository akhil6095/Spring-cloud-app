#!/bin/bash

echo 'updating box'
yum update -y

echo 'installing wget'
yum -y install wget


echo 'installing java'
if [ ! -f /usr/bin/java ];
then
    sudo yum install java-1.8.0-openjdk.x86_64 -y
    wait
else
    echo 'Java installed with version : ' $(java -version)
fi


echo 'installing maven'
if [ ! -f /usr/bin/mvn ];
then
    sudo yum install -y maven
    wait
else
    echo 'Maven installed with version : ' $(mvn -version)
fi

echo 'installing git'
if [ ! -f /usr/bin/git ];
then
    sudo yum install -y git
    wait
else
    echo 'GIT installed with version : ' $(git --version)
fi


echo 'installing docker'
if [ ! -f /usr/bin/docker ]; 
then
	wget -qO- https://get.docker.com/ | sh
	wait
    sudo usermod -aG docker $(whoami)
else
	echo "docker already installed with version : " $(docker -v)

fi

echo 'Restarting docker'
sudo service docker restart

echo 'installing docker-compose'
if [ ! -f /usr/bin/docker-compose ]; 
then
	sudo curl -L https://github.com/docker/compose/releases/download/1.14.0/docker-compose-`uname -s`-`uname -m` > /usr/bin/docker-compose
	sudo chmod +x /usr/bin/docker-compose
	sudo chown $USER:$USER /usr/bin/docker-compose 
else
	echo "docker-compose already installed with version : " $(docker-compose -v)
fi


if [ ! -d /home/vagrant/Spring-cloud-app ];
then
    echo 'Cloning spring project project'
    cd /home/vagrant/
    git clone https://github.com/akhil6095/Spring-cloud-app.git
else
    echo 'Updating repo'
    cd /home/vagrant/Spring-cloud-app
    git pull origin master
fi

cd /home/vagrant/Spring-cloud-app
sudo mvn clean package
sudo docker-compose up -d
