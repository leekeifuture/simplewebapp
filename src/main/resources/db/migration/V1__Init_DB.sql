CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;
CREATE SEQUENCE employee_id_seq;

CREATE TABLE employee (
    employee_id int8 NOT NULL DEFAULT NEXTVAL('employee_id_seq'),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    department_id int8 NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    date_of_birth VARCHAR(255) NOT NULL,
    PRIMARY KEY (employee_id)
);
