####################################################################
#																   #
#       Aman Engineering Expense Management System Help file       #
#																   #
####################################################################

#How to deploy:
1. Create database in MySQL server with name "amaneng_ems_db"
2. Right click on "amaneng_ems_db" and select option "Import Batch file...". Execute the sql file from [workspace]/AmanEngineering/setup/mysql-5.5/amaneng_ems_db.sql
3. Build the project by executing pom.xml using Maven (Eclipse plugin)
4. update docBase path in [workspace]/aman.ems/setup/tomcat-6.0/AmanEMS.xml
5. Copy [workspace]/aman.ems/setup/tomcat-6.0/AmanEMS.xml to [Hard disk][TOMCAT_HOME]/conf/Catalina/localhost
6. Start tomcat

#Access URL
http://localhost:8080/AmanEMS

#Default userId/Password
userId  = root
password= 123

#Log file path
D:\\AmanEngineering\\LOGS\\AmanEMS.log