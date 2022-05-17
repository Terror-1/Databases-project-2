*REGARDING RUNNING script.sh ON PSQL SHELL*

- To open psql shell (command window), type "psql" or "sql shell" in the windows search bar.
- In order to use the shell, you need to enter your database authentication info (Server, Database, Port, Username, Password). Each of those offer default values to enter in case someone went along with the default installation process.
- After authentication, run the "script.sh" file using the following command: "\i YOUR_PERSONAL_FILE_PATH/script.sh". 
- Note that in the previous step, the path is separated by the common slashes '/' not '\'



*REGARDING DB CONNECTION BETWEEN JAVA AND POSTGRESQL*

- As mentioned in the project document, you are required to change the 2nd and third argument in the connection statement in the main method (username and password). 
- Next, you run each of the Java Classes to create your databases/tables. If an error occured after due to the password being wrong, follow the below steps:
	1- Open your postgreSQL data file directory. (For example, the default directory for postgreSQL 14 is C:\Program Files\PostgreSQL\14\data)
	2- Edit pg_hba.conf as notepad.
	3- At the end of the file, change the connection method for ALL types to "trust" (This allows connections without the need of a password) as follows:


# TYPE  DATABASE        USER            ADDRESS                 METHOD

# "local" is for Unix domain socket connections only
local   all             all                                     trust
# IPv4 local connections:
host    all             all             127.0.0.1/32            trust
# IPv6 local connections:
host    all             all             ::1/128                 trust
# Allow replication connections from localhost, by a user with the
# replication privilege.
local   replication     all                                     trust
host    all             all             127.0.0.1/32            trust
host    replication     all             ::1/128                 trust


	4- Save the config file and run the Java Classes again. Everything should work fine now.

If you have questions related to the project, post is on the project discussion on Piazza
piazza.com/guc.edu.eg/spring2022/csen604
