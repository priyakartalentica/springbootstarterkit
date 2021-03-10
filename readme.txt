sudo docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=publication -e MYSQL_USER=root -e MYSQL_PASSWORD=password -p 3307:3306 -d mysql/mysql-server

sudo docker exec -it mysql-standalone mysql -uroot -p
