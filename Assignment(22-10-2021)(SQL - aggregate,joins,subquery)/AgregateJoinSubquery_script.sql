/*1. Display department_id's of all departments which 
have number of employees greater than 5.*/
SELECT 
    department_id, COUNT(*) AS 'Employee Count'
FROM
    employees
GROUP BY department_id;

/*2. display department ids whose employees salary average is greater than 20000*/
SELECT 
    department_id, AVG(salary)
FROM
    employees
GROUP BY department_id
HAVING AVG(salary) > 20000;

/*3. Display details of  5 employees who are earning highest salary*/
SELECT 
    *
FROM
    employees
ORDER BY salary DESC
LIMIT 5;

/*4. Retrieve department name,city,country name and region name 
to which employees belong to.*/
SELECT 
    CONCAT(first_name, ' ', last_name) AS 'Employee Name',
    department_name,
    city,
    country_name,
    region_name
FROM
    employees e
        JOIN
    departments d ON e.department_id = d.department_id
        JOIN
    locations l ON d.location_id = l.location_id
        JOIN
    countries c ON l.country_id = c.country_id
        JOIN
    regions r ON c.region_id = r.region_id;

/*5. Retrieve details of all employees whose commission_pct is greater than 
commission_pct of employee with last name De Haan.*/
SELECT 
    *
FROM
    employees
WHERE
    ifnull(commission_pct,0) > (SELECT 
            ifnull(commission_pct,0)
        FROM
            employees
        WHERE
            last_name = 'De Haan'); 
