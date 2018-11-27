CREATE DATABASE IF NOT EXISTS randomPlaces CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use randomPlaces;

create TABLE Users
(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  email varchar(100) NOT NULL UNIQUE,
  currentPassword varchar(100) NOT NULL,
  firstName varchar(50) NOT NULL,
  lastName varchar(50),
  city varchar(50) NOT NULL

);

create TABLE Places
(
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name varchar(100) NOT NULL,
  specification varchar(50) NOT NULL,
  city varchar(100) NOT NULL,
  address varchar(100) NOT NULL,
  description varchar(200) NOT NULL ,
  imagePath varchar(200) NOT NULL,
  userId int NOT NULL,
  CONSTRAINT `place_user`
  FOREIGN KEY (userId) REFERENCES Users (id)
  ON DELETE CASCADE
  ON UPDATE RESTRICT
);
