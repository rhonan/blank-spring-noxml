MYSQL_PID=/var/run/mysqld/mysqld.pid

while [ ! -f $MYSQL_PID ]; do
	sleep 1
done

mysql -u root < "/vagrant/create.sql"
