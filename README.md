# Postgresql DBMS

## Table of content
- [Project Description](#project-description)
- [Steps](#steps)



## Project Description

### Course 
DataBase 2- (CSEN 604), spring 2022

### Theme
The theme of the project is working on postgreSql DBMS and understand the concept of query optmization .
### used Tools 
PgAdmin - Psql shell - java - latex

### Objectives
- Learn how to read the execution plan of a certain query
- Leran how to inspect the queries and find the columns needed to be indexed .
- Learn how to optmized queries' performance .
- understand how PostgreSql works
- Learn ro deal with pg admin


## Steps
- [Table_creation](##Table_creation)
- [Insertion_modification](##Insertion_modification)
- [Update_table_statistics](##Update_table_statistics)
- [Indexing](##Indexing)
- [Optmizing](##Optmizing)

##Table_creation
   first we started the project by running the script that creates the four schemas that will work on them . 

##Insertion_modification
   then we modified the insertion in java that is connected to our postgresql DBengine to make a number of rows sufficient for each query that will help the planner to make a good estimate about how the exection plan will look like
##Update_table_statistics 
   Then we update the statistics needed to be collected to enhance the performance using theese commands on each schema `ANALZE` `Create Statistics`
##Indexing
Then we inspect the execution plan after running each query to find which column if we make index on it will improve the performance .
##Optmizing
Then we tried to find an alternative query that will force the planner to ignore some of the inner subplans and hence speed the execution time and decrease performance .

Link to a deatailed report :
 
