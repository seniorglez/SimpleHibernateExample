# HibernateExample

First and foremost install mariadb on your machine. On my case as an Arch user:



```bash



	sudo pacman -Syu mariadb mariadb-clients libmariadbclient



	sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql



	sudo systemctl start mysqld.service



	sudo systemctl enable mysqld.service

	

```

Now we need to create owr db. First of all we will log into owr mariadb server.



```bash

	sudo mysql -u root



```

So go ahead and create the shop's db and a new user.



```sql

	CREATE DATABASE hibernate;

	GRANT ALL ON hibernate.* TO 'admin'@localhost IDENTIFIED BY 'hibernate';

	FLUSH privileges;

	exit


```



We can now login with this new user which have all privileges on that bd.



```bash

	mysql -u admin -p

```



Let's create the tables we need now.

```bash

	use hibernate

	CREATE TABLE IF NOT EXISTS event(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(20) NOT NULL,
	date DATETIME NOT NULL);

``` 
