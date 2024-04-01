# **Databases**

## **SQL**

SQL, which stands for Structured Query Language, is a domain-specific programming language used for managing and manipulating relational databases. It provides a standardized way to interact with relational database management systems (RDBMS) to perform tasks such as querying data, updating data, inserting data, and managing database structures.

## **SQL v/s NoSQL**

#### SQL
- SQL databases are relational databases.
- Data is structured in tables with fixed schema.
- Vertical Scaling is often achieved by upgrading hardware (adding more power to existing machines)..
- SQL is used to query relational databases.
- Well-suited for applications with complex queries and transactions.
- Commonly used in traditional business applications, financial systems, and systems where data relationships are well-defined.

#### NoSQL
- NoSQL databases are non-relational or distributed databases.
- NoSQL databases are schema-less or have a dynamic schema.
- Horizontal scalability is common (adding more servers to a database).
- Well-suited for applications with evolving data requirements, large amounts of unstructured data, and scalability needs.
- Commonly used in web applications, real-time big data, and systems with dynamic or flexible schemas.

## **Primary key v/s Unique key v/s Foreign key v/s Composite key**

#### Primary key

- A primary key is a column or a set of columns in a database table that uniquely identifies each row (record) in the table.
- It ensures that each row in the table is distinct, and there are no duplicate entries for the primary key values.
- Enforces the uniqueness and non-null property of the primary key columns.
  Eg: id in StudentTable

#### Unique key

- A unique key, often referred to as a unique constraint, is a set of one or more columns in a database table that must contain unique values within the table.
- Unique key does not necessarily need to be used to identify individual rows. It's primarily used to ensure that certain columns or combinations of columns have distinct values.
  eg: email in StudentTable

#### Foreign key

- A foreign key is a column or a set of columns in a table that establishes a link between data in two tables.
- Foreign keys are used to create relationships between tables, allowing you to retrieve related data from different tables through JOIN operations.
- Foreign key in a child table typically references the primary key in the parent table, it helps maintain data consistency and prevent orphaned data.
  Eg: studentId in DepartmentTable

#### Composite key

 - Composite key is a combination of two or more columns that uniquely identifies each row in a database table. 
 - They are unlike a single-column primary key, which consists of only one column, a composite key involves multiple columns.
 Eg: studentId and DepartmentId in SchoolTable

## Indexing 

- An index is a database object that improves the speed of data retrieval operations on a database table. Indexes can be created on one or more columns of a table, and they provide a quick lookup mechanism to find rows that match a certain condition.

- Single Column Index
```sql
CREATE INDEX idx_column_name ON table_name(column_name);
```

- Composite Index
```sql
CREATE INDEX idx_multi_columns ON table_name(column1, column2);
```
## **JOIN Queries**
#### INNER JOIN
- Returns records that have matching values in both tables.
- We can use `INNER JOIN` or `JOIN`.

```sql
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

#### LEFT JOIN (or LEFT OUTER JOIN)
- Returns all records from the left table (table1) and the matched records from the right table (table2). The result is NULL from the right side if there is no match.

```sql
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
LEFT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

#### RIGHT JOIN (or RIGHT OUTER JOIN)
- Returns all records from the right table (table2) and the matched records from the left table (table1). The result is NULL from the left side if there is no match.

```sql
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
RIGHT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

#### FULL JOIN (or FULL OUTER JOIN)
- Returns all records when there is a match in either left (table1) or right (table2) table.

```sql
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
FULL JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

## **GROUP BY**

- `GROUP BY` clause is used to group rows that have the same values in specified columns into summary rows.
- Data Aggregation

```sql
SELECT product_category, SUM(sales_amount) as total_sales
FROM sales
GROUP BY product_category;
```

- Data Summarization

```sql
SELECT DATE(order_date), SUM(order_total) as daily_total
FROM orders
GROUP BY DATE(order_date);
```

- Data Cleansing

```sql
SELECT email, COUNT(*) as count
FROM customers
GROUP BY email
HAVING count > 1;
```

- Data Segmentation

```sql
SELECT CASE
          WHEN total_purchases >= 10 THEN 'Frequent Buyer'
          ELSE 'Occasional Buyer'
       END as buyer_segment,
       COUNT(*) as customer_count
FROM customers
GROUP BY buyer_segment;
```

- Statistical Analysis

```sql
SELECT FLOOR(value/10)*10 as bin, COUNT(*) as frequency
FROM data_values
GROUP BY bin;
```

## **SQL query to fetch second highest value**

```sql
SELECT MAX(column_name) AS second_highest
FROM table_name
WHERE column_name < (SELECT MAX(column_name) FROM table_name);
```
```sql
SELECT column_name AS second_highest
FROM table_name
ORDER BY column_name DESC
LIMIT 1 OFFSET 1;
```

## View
- View is a virtual table derived from one or more tables or other views. 
- It represents a set of rows and columns, just like a real table, but its contents are dynamically generated based on the definition of the view. 
- Views do not store data themselves; instead, they retrieve data from the underlying tables or views whenever they are queried.
- Views are a powerful tool for organizing and presenting data in SQL databases, offering flexibility, security, and abstraction capabilities.

```sql
CREATE VIEW EmployeeView AS
SELECT EmployeeID, FirstName, LastName, Department
FROM Employees
WHERE Department = 'IT';

SELECT * FROM EmployeeView;
```
## Procedure
- Procedure is a group of SQL statements that perform a specific task or set of tasks. 
- Procedures are stored in the database and can be executed by invoking their name. 
- They are often used to encapsulate frequently executed sequences of SQL statements, implement business logic, or perform data manipulation tasks.

```sql
CREATE PROCEDURE GetEmployeeInfo(IN emp_id INT)
BEGIN
    SELECT * FROM employees WHERE employee_id = emp_id;
END;
```

## Triggers
- Triggers in SQL are special types of stored procedures that automatically execute in response to specific events or actions performed on a database table. 
- These events can include INSERT, UPDATE, or DELETE operations on the table. 
- Triggers are useful for enforcing data integrity constraints, auditing changes, or automating certain tasks based on database events.

```sql
CREATE TRIGGER update_timestamp
AFTER UPDATE ON Employees
FOR EACH ROW
BEGIN
    SET NEW.last_updated = CURRENT_TIMESTAMP;
END;
```

## Functions
- Functions are named, reusable code blocks that perform a specific task or computation and return a single value. 
- Functions can accept parameters, perform calculations or manipulations on data, and return a result. 
- They are commonly used to encapsulate logic that needs to be executed repeatedly within SQL queries or statements.
```sql
SELECT SQUARE(5);
```

## **One-Many Relationship**
- In a one-to-many relationship, one record in the first table (parent table) can be associated with multiple records in the second table (child table), but each record in the second table is associated with only one record in the first table.

```sql
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(255)
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);
```
- The department table stores information about departments.
- The employee table stores information about employees.
- The employee table has a foreign key (department_id) that references the primary key of the department table.
- An employee belongs to one department, but a department can have multiple employees.

## **Many-to-One Relationship**
- A many-to-one relationship is essentially the reverse of a one-to-many relationship. In a many-to-one relationship, many records in the first table can be associated with one record in the second table.

```sql
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(255)
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);
```
- The department table stores information about departments.
- The employee table stores information about employees.
- The employee table has a foreign key (department_id) that references the primary key of the department table.
- Many employees can belong to the same department, but each employee belongs to only one department.

## **Many-Many Relationship**

In a relational database, the relationship between the "author" and "book" tables is typically modeled using a foreign key. There are different types of relationships, and in this case, it sounds like a many-to-many relationship because one author can write many books, and one book can have multiple authors.

To represent a many-to-many relationship between the "author" and "book" tables, you need a third table, often called a junction or linking table. This table serves to link authors to books, indicating which authors are associated with which books. Here's a basic schema for such a setup:

```sql
CREATE TABLE author (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(255)
);

CREATE TABLE book (
    book_id INT PRIMARY KEY,
    book_title VARCHAR(255)
);

CREATE TABLE author_book (
    author_id INT,
    book_id INT,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author(author_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);
```
- The author table stores information about authors.
- The book table stores information about books.
- The author_book table is the junction table that establishes the many-to-many relationship. It contains foreign keys referencing the primary keys of the author and book tables. The combination of author_id and book_id forms a composite primary key for this table.
- One author can be associated with multiple books.
- One book can have multiple authors.
- The author_book table keeps track of these associations.

```sql
-- Insert authors
INSERT INTO author (author_id, author_name) VALUES
(1, 'Author A'),
(2, 'Author B'),
(3, 'Author C');

-- Insert books
INSERT INTO book (book_id, book_title) VALUES
(101, 'Book X'),
(102, 'Book Y'),
(103, 'Book Z');

-- Associate authors with books
INSERT INTO author_book (author_id, book_id) VALUES
(1, 101),  -- Author A wrote Book X
(1, 102),  -- Author A also wrote Book Y
(2, 101),  -- Author B wrote Book X as well
(3, 103);  -- Author C wrote Book Z
```

## **Design the DB for a Pencil Factory**
### Entities and Attributes:
- Product: Represents a type of pencil.
Attributes: Product ID (Primary Key), Name, Description, Price, Quantity in Stock, Production Date, Expiry Date, Category.
- Supplier: Represents a supplier of raw materials.
Attributes: Supplier ID (Primary Key), Name, Contact Information, Address.
- Employee: Represents an employee working in the factory.
Attributes: Employee ID (Primary Key), Name, Position, Contact Information, Salary.
- Order: Represents a purchase order for raw materials or equipment.
Attributes: Order ID (Primary Key), Supplier ID (Foreign Key), Date, Total Cost, Status.
- Production Batch: Represents a batch of pencils produced.
Attributes: Batch ID (Primary Key), Product ID (Foreign Key), Quantity Produced, Production Date, Supervisor ID (Foreign Key).
- Customer: Represents a customer purchasing pencils.
Attributes: Customer ID (Primary Key), Name, Contact Information, Address.
### Relationships:
- One Supplier can supply many Orders (One-to-Many relationship).
- One Employee can supervise many Production Batches (One-to-Many relationship).
- One Product can belong to many Production Batches (One-to-Many relationship).
- One Customer can place many Orders (One-to-Many relationship).
### Database Tables:
- Product Table:
Columns: ProductID, Name, Description, Price, QuantityInStock, ProductionDate, ExpiryDate, Category.
- Supplier Table:
Columns: SupplierID, Name, ContactInfo, Address.
- Employee Table:
Columns: EmployeeID, Name, Position, ContactInfo, Salary.
- Order Table:
Columns: OrderID, SupplierID, Date, TotalCost, Status.
- Production Batch Table:
Columns: BatchID, ProductID, QuantityProduced, ProductionDate, SupervisorID.
- Customer Table:
Columns: CustomerID, Name, ContactInfo, Address.
### Foreign Keys:
- SupplierID in Order Table references Supplier Table.
- ProductID in Production Batch Table references Product Table.
- SupervisorID in Production Batch Table references Employee Table.
- CustomerID in Order Table references Customer Table.