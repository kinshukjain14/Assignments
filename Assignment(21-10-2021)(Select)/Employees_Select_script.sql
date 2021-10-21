/*1. Retrieve the contact details about employees who belong to department id 10.*/
SELECT CONCAT(first_name," ",last_name) AS "Name", phone_Number AS "Contact No"
FROM employees
WHERE department_id = 10;

/*2. Retrieve details of all employees who are earning more than 10000 and whose commission_pct is greater than 0.2*/
SELECT * 
FROM employees
WHERE salary>10000 
AND 
commission_pct > 0.2;

/*3. Retrieve details of all employees who belong to department id either 10 or 20 or 50*/
SELECT * 
FROM employees
WHERE department_id = 10 
OR
department_id = 20
OR
department_id = 50; 

/*4. Search for employees whose name starts with K and ends with n.*/
SELECT *
FROM employees
HAVING first_name LIKE "K%"
AND last_name LIKE "%n";

/* 5. Search for employees whose last name contains 'oc'*/
SELECT *
FROM employees
HAVING last_name 
LIKE "%oc%";

/*6. Search for employees who are not earning commission_pct*/
SELECT * 
FROM employees
WHERE commission_pct IS NULL;

/*7. Retrieve all non duplicate manager ids from employees table*/
SELECT DISTINCT manager_id
FROM employees;

/*8. Sort the employees record in descending order based on salary. If two employees have same salary 
sorting should be done in ascending order based on last name.*/
 SELECT * 
 FROM employees
 ORDER BY salary DESC,
 last_name ASC;
 
 /*9. get all employees who belong  to department 50 and salary is greater than 5000*/
 SELECT * 
 FROM employees
 WHERE department_id=50
 AND salary > 5000; 

/*10.Get details of all employees who has job id either as SA_REP or SA_MAN*/
SELECT * 
FROM employees
WHERE job_id = "SA_REP"
OR job_id = "SA_MAN";