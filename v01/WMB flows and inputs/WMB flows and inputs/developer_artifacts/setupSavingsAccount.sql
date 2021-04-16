connect to SAVG_ACC
drop table "DB2SCHEMA".SAVINGS_ACCOUNT
create table "DB2SCHEMA".SAVINGS_ACCOUNT("ACCOUNT_NO" BIGINT NOT NULL, "ACCOUNT_NAME" VARCHAR(50) , "BALANCE" DOUBLE, PRIMARY KEY(ACCOUNT_NO))
INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT VALUES(100003,'JOHN',25990.00)
INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT VALUES(100004,'PETER',75125.00)
INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT VALUES(100005,'ANDREW',72500.00)
INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT VALUES(100006,'MARY',55000.00)
INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT VALUES(100007,'DAVID',69800.00)
drop table "DB2SCHEMA".SAVINGS_ACCOUNT_TRANSACTION
create table "DB2SCHEMA".SAVINGS_ACCOUNT_TRANSACTION("ACCOUNT_NO" BIGINT NOT NULL, "ACCOUNT_NAME" VARCHAR(50) , "BALANCE" DOUBLE,"TRANSACTION_AMOUNT" DOUBLE, "TRANSACTION_STATUS" VARCHAR(50))
drop procedure "DB2SCHEMA".update_savings_account
CREATE PROCEDURE "DB2SCHEMA".update_savings_account(IN saccount_no INT,IN saccount_name CHAR(50), IN amount FLOAT,IN tran CHAR(10), OUT balance FLOAT,OUT status CHAR(10)) LANGUAGE SQL   BEGIN  DECLARE SQLSTATE CHAR(5); DECLARE acc_no INT; DECLARE acc_name CHAR(50); DECLARE bal FLOAT; DECLARE stat CHAR(10); DECLARE not_found CONDITION FOR SQLSTATE '02000'; DECLARE c1 CURSOR FOR SELECT ACCOUNT_NO, ACCOUNT_NAME , BALANCE FROM "DB2SCHEMA".SAVINGS_ACCOUNT WHERE ACCOUNT_NO = saccount_no AND ACCOUNT_NAME = saccount_name; DECLARE EXIT HANDLER FOR not_found  SET stat = 'NOT FOUND'; Open c1; Fetch c1 into acc_no,acc_name,bal;if (tran = 'DEBIT') then if ( amount < bal) then  SET bal = bal - amount ;  UPDATE "DB2SCHEMA".SAVINGS_ACCOUNT SET BALANCE = bal WHERE ACCOUNT_NO = saccount_no AND ACCOUNT_NAME = saccount_name; SET stat = 'SUCCESS' ;INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT_TRANSACTION values (acc_no,acc_name,bal,amount,'TRANSACTION COMPLETED SUCCESSFULLY');else SET stat = 'FAILURE' ;INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT_TRANSACTION values (acc_no,acc_name,bal,amount,'TRANSACTION FAILED - INSUFFICIENT FUNDS'); end if; elseif (tran = 'CREDIT') then SET bal = bal + amount ;  UPDATE "DB2SCHEMA".SAVINGS_ACCOUNT SET BALANCE = bal WHERE ACCOUNT_NO = saccount_no AND ACCOUNT_NAME = saccount_name; SET stat = 'SUCCESS';INSERT into "DB2SCHEMA".SAVINGS_ACCOUNT_TRANSACTION values (acc_no,acc_name,bal,amount,'TRANSACTION COMPLETED SUCCESSFULLY'); end if; SET balance = bal; SET status = stat;END
Disconnect SAVG_ACC