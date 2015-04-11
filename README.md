spring-mvc-angularjs
====================

A simple application to demonstrating the use of Spring MVC as the RESTful service provider and AngularJS for the front end javascript framework

The demo illustrates the menu item with Home  , Actions are two tabs. 

It has the image on the menu 

consists of the Actions view page with listes the actions and also exposes some CRUD functionality.

sql script to setup test data in mysql

delete from action;
delete from users;

create table if not exists action(id smallint primary key, asignee_id varchar(255), name varchar(50) , created_date varchar(10),due_date varchar(10));

create table if not exists user (id smallint primary key, user_name varchar(255) , first_name varchar(255) , last_name varchar(255));


insert into action values (1,1 , 'Action 1' ,'12/12/2012','12/12/2015');
insert into action values (2,2 , 'Action 2' ,'12/12/2013','12/12/2016');
insert into action values (3,3 , 'Action 3' ,'12/12/2014','12/12/2017');
insert into action values (4,4 , 'Action 4' ,'12/12/2015','12/12/2018');
insert into action values (5,5 , 'Action 5' ,'12/12/2016','12/12/2019');
insert into action values (6,3, 'Action 6' ,'12/12/2016','12/12/2019');
insert into action values (7,2 , 'Action 7' ,'12/12/2016','12/12/2019');
insert into action values (8,4 , 'Action 8' ,'12/12/2016','12/12/2019');
insert into action values (9,5 , 'Action 9' ,'12/12/2016','12/12/2019');
insert into action values (10,2 , 'Action 10' ,'12/12/2016','12/12/2019');


insert into user values (1,'badrish123@ymail.com' , 'Badrish','Davay'  );
insert into user values (2,'don@himail.com', 'Don' , 'Braddy');
insert into user values (3,'nancy124@haii.com' , 'Nancy' , 'Hopkins');
insert into user values (4,'ruhnu@hyi.com' , 'Ranger' , 'Runhn');
insert into user values (5,'sally@127gat.com' ,'Fredric' , 'Sally');



Then open the URL: http://localhost:8080/AngularSpringApp/#/home