/*1. insert new record in employees table with following details using prepared statement
  EMPLOYEE_ID 999
  FIRST_NAME ROHAN
  LAST_NAME  SHAH
  EMAIL  rohan.shah@hotmail.com
  PHONENUMER 230-987-111
  SALARY 45000
  COMMISSION_PCT 0.2
  MANAGER_ID 101
  DEPARTMENT_ID 10*/
  
  prepare insertstmt from 'insert into employees (employee_id,first_name,last_name,email,phone_number,salary,commission_pct,manager_id,department_id,hire_date,job_id) values (?,?,?,?,?,?,?,?,?,current_date,"AC_MGR")';
  
  set @Id=999;
  set @FirstName='Rohan';
  set @LastName='Shah';
  set @Email='rohan.shah@hotmail.com';
  set @PhoneNumber='230-987-111';
  set @Salary=45000;
  set @CommissionPct=0.2;
  set @ManagerId=101;
  set @DepartmentId=10;
  
  execute insertstmt using @Id,@FirstName,@LastName,@Email,@PhoneNumber,@Salary,@CommissionPct,@ManagerId,@DepartmentId;
  deallocate prepare insertstmt;
  

/*2. delete a record from employees table for following employee_id using prepared statement   
  EMPLOYEE_ID 101*/
prepare deletestmt from 
'delete from employees e
where employee_id=?';

set @Id=101;

execute deletestmt using @Id;
deallocate prepare deletestmt;

/*
3. Update employee email and phonenumber with following details using prepared statement
  EMAIL: official@yash.com
  PHONENUMBER: 789-778-221*/
  
  prepare stmt from 
  'update employees set email=?, phone_number=? where employee_id=?';
  
  set @Email='official@yash.com';
  set @PhoneNo='789-778-221';
  set @Id=101;
  execute stmt using @Email,@PhoneNo,@Id;
  deallocate prepare stmt;

/*4. Create a table States with following columns,
   State_Id 
   State_Name
  and following records,
  S001  Madhya Pradesh
  S002  Uttar Pradesh
 using Replace function insert following entry into state table
  S001 Madhya Pradesh*/
use test;
create table States(
State_Id varchar(10) primary key,
State_Name varchar(20)
);

insert into States values 
('S001','Madhya Pradesh'),
('S002','Uttar Pradesh');

replace into States values
('S001','Madhya Pradesh');

/*5. Create a table student with following columns,
   Student_roll_no
   Student_name
   fees
 Update student fees using replace function*/
 use test;
 create table student(
 Student_roll_no int,
 Student_name varchar(40),
 fees double
 );
 
 insert into student values
 (101,'Kinshuk Jain',25210.2),
 (102,'Ash',2342.21),
 (103,'awe',34321);
 
 replace into student 
 values (102,'Ash',2300);
 
 
 