@rem Create Databases for IIB courses        *
@echo off
@rem * Created by Sharon Watts,  IBM Middleware    *
@rem * updated June 2015    
@rem (c) Copyright IBM Corp. firstyr, updatedyr 
@rem US Government Users Restricted Rights - Use duplication or
@rem disclosure restricted by GSA ADP Schedule Contract with
@rem IBM Corp
                                *
@rem *********************************************************/


@echo on

DB2 START DATABASE MANAGER

DB2 UNCATALOG SYSTEM ODBC DATA SOURCE MSGSTORE
DB2 DROP DATABASE MSGSTORE
DB2 CREATE DATABASE MSGSTORE
DB2 CATALOG SYSTEM ODBC DATA SOURCE MSGSTORE
DB2 CONNECT TO MSGSTORE
DB2 CREATE TABLE COMPLAIN (MSGID VARCHAR(100), RECEIVED VARCHAR(50), MESSAGE VARCHAR (2000)  ) DATA CAPTURE NONE 
DB2 CONNECT RESET


DB2 UNCATALOG SYSTEM ODBC DATA SOURCE SAMPLE
DB2 DROP DATABASE SAMPLE
DB2 CREATE DATABASE SAMPLE
DB2 CATALOG SYSTEM ODBC DATA SOURCE SAMPLE
DB2 CONNECT TO SAMPLE
DB2 CREATE TABLE EMPLOYEE (EMPNO CHAR(6), FIRSTNME VARCHAR(12), MIDINIT CHAR(1), LASTNAME VARCHAR(15), WORKDEPT CHAR(3), PHONENO CHAR(4), JOB CHAR(8)) DATA CAPTURE NONE
DB2 INSERT INTO EMPLOYEE VALUES ('EMP012', 'Willie', 'F', 'Makeit', 'E01', '4547', 'MANAGER')
DB2 INSERT INTO EMPLOYEE VALUES ('EMP025', 'Justin', 'Q', 'Public', 'E01', '4524', 'EMPLOYEE')
DB2 INSERT INTO EMPLOYEE VALUES ('EMP106', 'Betty', 'M', 'Bacon', 'C01', '4891', 'MANAGER')
DB2 INSERT INTO EMPLOYEE VALUES ('EMP077', 'Colin', 'J', 'Watson', 'C01', '4835', 'EMPLOYEE')
DB2 INSERT INTO EMPLOYEE VALUES ('EMP301', 'Rebecca', 'L', 'Sunset', 'C01', '4890', 'EMPLOYEE')
DB2 CONNECT RESET

DB2 LIST SYSTEM ODBC DATA SOURCES

