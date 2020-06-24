create database librarydb;

-- TABLE author
create table authors ( 
authorid INTEGER PRIMARY KEY auto_increment,
authorname    VARCHAR(50)
);

-- TABLE publisher
create table publishers ( 
publisherid INTEGER PRIMARY KEY auto_increment,
publishername VARCHAR(50)
);

-- TABLE book
create table books ( 
bookid INTEGER PRIMARY KEY auto_increment, 
title          VARCHAR(50)    NOT NULL,
authorid      INTEGER         NOT NULL,
publisherid   INTEGER         NOT NULL,
publisheddate   DATE,
pages integer(10),
FOREIGN KEY (authorid) REFERENCES authors(authorid),
FOREIGN KEY (publisherid) REFERENCES publishers(publisherid)
);

-- TABLE user
create table user(
    user_id int(11) NOT NULL AUTO_INCREMENT,
    username varchar(100) not null ,
    password varchar(100) not null,
    email varchar(100),
    PRIMARY KEY (`user_id`)
);
