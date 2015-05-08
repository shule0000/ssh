drop database if exists sshTest;
create database sshTest;
use sshTest;

create table user(
	id int(11) auto_increment,
	username varchar(50) not null unique,
	password varchar(50) not null,
	agname varchar(50),
	primary key(id)
);

insert into user(username, password, agname) values('shule0000','shule.0000','金俊梅');

select * from user;