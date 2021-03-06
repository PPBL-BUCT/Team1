mysql -uroot -proot

DROP USER 'root'@'%';

CREATE USER 'root'@'%' IDENTIFIED BY "root";

flush privileges;

SET PASSWORD FOR 'root'@'%'=PASSWORD('');

drop database springdb;

create database springdb default character set utf8 collate utf8_general_ci;

grant select,insert,update,delete,create,index,drop,alter,references on springdb.* to bankdb@"%" identified by "bankdb" with grant option;

CREATE TABLE `t_user` (  
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,  
  `USER_NAME` char(30) NOT NULL,  
  `USER_PASSWORD` char(10) NOT NULL,  
  `USER_EMAIL` char(30) NOT NULL,  
  PRIMARY KEY (`USER_ID`),  
  KEY `IDX_NAME` (`USER_NAME`)  
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (1, 'jack', '1234567@', 'ling20081005@126.com');
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (2, 'evan', '123', 'fff@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (3, 'kaka', 'cadg', 'fwsfg@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (4, 'simle', 'cscs', 'fsaf@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (5, 'arthur', 'csas', 'fsaff@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (6, '小德', 'yuh78', 'fdfas@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (7, '小小', 'cvff', 'fsaf@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (8, '林林之家', 'gvv', 'lin@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (9, '林炳文Evankaka', 'dfsc', 'ling2008@126.com');  
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (10, 'apple', 'uih6', 'ff@qq.com'); 