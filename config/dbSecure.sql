CREATE USER 'vagrant'@'%' IDENTIFIED BY 'vagrant@123#';
GRANT ALL PRIVILEGES ON *.* TO 'vagrant'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;