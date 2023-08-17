DROP DATABASE IF EXISTS userInfo;
CREATE DATABASE userInfo;
USE userInfo;
CREATE TABLE credentials (
	id int primary key auto_increment,
	mail varchar(255) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    role varchar(255) NOT NULL
);
