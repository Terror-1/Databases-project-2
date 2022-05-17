sudo -u postgres psql;

CREATE DATABASE schema1;
\c schema1;

CREATE TABLE department(dep_name VARCHAR(20) PRIMARY KEY, building NUMERIC, budget NUMERIC);
CREATE TABLE instructor(ID INT PRIMARY KEY, name VARCHAR(20), salary NUMERIC, dep_name VARCHAR(20) REFERENCES department);
CREATE TABLE classroom(building INT, room_number INT, capacity NUMERIC, PRIMARY KEY(building, room_number), UNIQUE(building), UNIQUE(room_number));
CREATE TABLE time_slot(id INT PRIMARY KEY, day VARCHAR(10), start time, end_time time);
CREATE TABLE student(id INT PRIMARY KEY, name VARCHAR(20), tot_credit INT, department VARCHAR(20) REFERENCES department, advisor_id INT REFERENCES instructor);
CREATE TABLE course(course_id INT PRIMARY KEY, title VARCHAR(20), credits INT, department VARCHAR(20) REFERENCES department);
CREATE TABLE pre_requiste(course_id INT, prereq_id INT,PRIMARY KEY(course_id, prereq_id));
CREATE TABLE section(section_id INT PRIMARY KEY, semester INT, year INT, instructor_id INT REFERENCES instructor, course_id INT REFERENCES course,classroom_building INT REFERENCES classroom(building), classroom_room_no INT REFERENCES classroom(room_number));
CREATE TABLE takes(student_id INT REFERENCES student, section_id INT REFERENCES section, grade real, PRIMARY KEY(student_id, section_id));
CREATE TABLE section_time(time_slot INT REFERENCES time_slot, section_id INT REFERENCES section, PRIMARY KEY(time_slot, section_id));



CREATE DATABASE schema2;
\c schema2;

CREATE TABLE Employee(Fname CHAR(20), Minit CHAR(10), Lname CHAR(20), ssn INT PRIMARY KEY, Bdate date, address CHAR(20), sex CHARACTER(1), salary INT, Super_snn INT REFERENCES Employee(ssn), dno INT);

CREATE TABLE Department(Dname CHAR(20), Dnumber INT PRIMARY KEY, Mgr_snn int REFERENCES employee, Mgr_start_date date );

CREATE TABLE Dept_locations(Dnumber integer REFERENCES Department, Dlocation CHAR(20), PRIMARY KEY(Dnumber,Dlocation));

CREATE TABLE Project(Pname CHAR(20), Pnumber INT PRIMARY KEY, Plocation CHAR(50), Dnumber INT REFERENCES Department);

CREATE TABLE Works_on(Essn int REFERENCES Employee, Pno int REFERENCES Project, Hours int, PRIMARY KEY(Essn,Pno));

CREATE TABLE Dependent(Essn INT REFERENCES Employee, Dependent_name CHAR(20), sex CHARACTER(1), Bdate date, Relationship CHAR(20), PRIMARY KEY(Essn, Dependent_name));

CREATE DATABASE schema3;
\c schema3;

CREATE TABLE Sailors(sid INT PRIMARY KEY, sname CHAR(20), rating INT, age REAL);
CREATE TABLE Boat(bid INT PRIMARY KEY, bname CHAR(20), color CHAR(10));
CREATE TABLE Reserves(sid INT REFERENCES Sailors, bid INT REFERENCES Boat, day date, PRIMARY KEY(sid,bid));

CREATE DATABASE schema4;
\c schema4;

CREATE TABLE Movie(mov_id INT PRIMARY KEY, mov_title CHAR(50), mov_year INT, mov_time INT, mov_lang CHAR(50), mov_dt_rel date, mov_rel_country CHAR(5));

CREATE TABLE Reviewer(rev_id INT PRIMARY KEY, rev_name CHAR(30));

CREATE TABLE Genres(gen_id INT PRIMARY KEY, gen_title CHAR(20));

CREATE TABLE Actor(act_id INT PRIMARY KEY, act_fname CHAR(20), act_lname CHAR(20), act_gender CHAR(1));

CREATE TABLE Director(dir_id INT PRIMARY KEY, dir_fname CHAR(20), dir_lname CHAR(20));

CREATE TABLE movie_direction(dir_id INT REFERENCES Director, mov_id INT REFERENCES Movie, PRIMARY KEY(dir_id,mov_id));

CREATE TABLE movie_cast(act_id INT REFERENCES Actor, mov_id INT REFERENCES Movie, role CHAR(30), PRIMARY KEY(act_id, mov_id));

CREATE TABLE movie_genres(mov_id INT REFERENCES Movie, gen_id INT REFERENCES genres, PRIMARY KEY(mov_id,gen_id));

CREATE TABLE Rating(mov_id INT REFERENCES Movie, rev_id INT REFERENCES Reviewer, rev_stars INT, num_o_ratings INT, PRIMARY KEY(mov_id,rev_id));
