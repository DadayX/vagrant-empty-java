# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "generic/alpine38"
  config.vm.provider "virtualbox" do |provider|
      provider.cpus=1
      provider.memory=1024
  end
  
  config.vm.network "private_network", ip: "192.168.56.16"
  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.synced_folder "./src", "/data/source"
  #config.vm.provision "shell", inline: <<-SHELL
  #  cd .
  #  git pull
  #SHELL
  config.vm.provision "shell", path: "./config/install.sh"
  config.vm.provision "file" do |file2|
    file2.source = "./config/dbSecure.sql"
    file2.destination = "/home/vagrant/conf/dbSecure.sql"
  end
  config.vm.provision "file" do |file3|
    file3.source = "./config/my.cnf"
    file3.destination = "/home/vagrant/conf/my.cnf"
  end
  config.vm.provision "file" do |file4|
    file4.source = "./config/mynote.sql"
    file4.destination = "/home/vagrant/conf/mynote.sql"
  end
  config.vm.provision "shell", path: "./config/updateConfig1.sh"
  #config.vm.provision "shell", path: "./config/step0.sh"
  #config.vm.provision "shell", inline: <<-SHELL
  #  apt-get update
  #  apt-get install -y apache2
  #SHELL
end
