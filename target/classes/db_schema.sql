create database if not exists JPA;
use JPA;


create table if not exists department(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100)
);

create table if not exists employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	salary LONG,
	dept_id INT,
	street varchar(100),
	city varchar(100),
	state varchar(100),
	zip_code varchar(10),
	birthday TIMESTAMP,
	FOREIGN KEY(dept_id) REFERENCES department(id)
);

create table if not exists project (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name varchar(100),
	project_manager varchar(100),
	description varchar(500)
);


INSERT INTO department VALUES (1,"SALES");
INSERT INTO department VALUES (2,"PRE-SALES");
INSERT INTO department VALUES (3,"IT");
INSERT INTO department VALUES (4,"MANAGEMENT");
INSERT INTO department VALUES (5,"DEVELOPMENT");
INSERT INTO department VALUES (6,"TESTING");
INSERT INTO department VALUES (7,"SUPPORT");

INSERT INTO employee VALUES (1,"Adrian",23,6,"Sos Pantelimon","Bucharest","Romania","021602",27/08/1992);
INSERT INTO employee VALUES (2,"Lavinia",43,3,"Mihai Bravu","Bucharest","USA","029902",27/05/1989);
INSERT INTO employee VALUES (3,"Costi",53,1,"Sos Pantelimon","Bucharest","France","021601",18/01/1992);
INSERT INTO employee VALUES (4,"Johnny",66,5,"Aleea Floreasca","Iasi","Romania","021202",15/05/1992);
INSERT INTO employee VALUES (5,"Victor",35,6,"Sos Pantelimon","Bucharest","United Kingdom","051602",30/08/1981);
INSERT INTO employee VALUES (6,"Alex",100,2,"Dristor","Bucharest","Spain","022602",27/11/1992);
INSERT INTO employee VALUES (7,"Daniel",85,6,"Sos Iancului","Bucharest","Romania","021602",20/01/1992);
INSERT INTO employee VALUES (8,"Alexandra",53,4,"Sos Timisoara","Timisoara","Romania","021602",01/08/1987);
INSERT INTO employee VALUES (9,"Matei",53,4,"Bristol Street","London","United Kingdom","216123",21/12/1960);


INSERT INTO project VALUES (1000,"Kinder","Alexandra","Bring joy to kids!");
INSERT INTO project VALUES (1001,"Altispanac","Victor","Cel mai cel!");
INSERT INTO project VALUES (1002,"Endava","Radu","Pass it on!");
INSERT INTO project VALUES (1003,"Amazon","Alexandra","Using AWS - Amazon Web Services!");
INSERT INTO project VALUES (1004,"Liverpool","Adrian","New website for the greatest club in the world");
INSERT INTO project VALUES (1005,"WPW","Alexandra","Nu stiu de la ce vine WPW");
INSERT INTO project VALUES (1006,"X","Adrian","Take over the world!");
