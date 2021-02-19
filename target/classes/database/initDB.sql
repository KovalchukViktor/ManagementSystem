DROP TABLE IF EXISTS employee, department;

CREATE TABLE IF NOT EXISTS department
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    description VARCHAR(254) NOT NULL ,
    phone_number_department VARCHAR(50)  NOT NULL,
    date_of_formation DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS employee
(
    id    INTEGER PRIMARY KEY ,
    full_name  VARCHAR(200) NOT NULL ,
    date_of_birth DATE NOT NULL ,
    phone_number VARCHAR(50)  NOT NULL,
    email VARCHAR(254) NOT NULL ,
    position  VARCHAR(200) NOT NULL ,
    date_of_employment DATE NOT NULL,
    department_id  INTEGER DEFAULT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id)
);
--CREATE SEQUENCE employees_id_seq START WITH 5 INCREMENT BY 1;

