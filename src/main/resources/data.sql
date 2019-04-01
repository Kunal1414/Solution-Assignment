DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    userId int(3) NOT NULL,
    name varchar(200) NOT NULL,
    password varchar(500) DEFAULT NULL,
	status varchar(255),
    PRIMARY KEY (userid)
);

insert into User (userid,name,password,status) values(1,'Ranga', 'fghhASDF23VJG','ACTIVATED');
insert into User (userid,name,password,status) values(2,'Ravi', 'fghhASDF23VJG','DEACTIVATED');