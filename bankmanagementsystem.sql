CREATE DATABASE bankmanagementsystem;

SHOW databases;

USE bankmanagementsystem;

CREATE TABLE signup(
formno VARCHAR(20),
name VARCHAR(50),
father_name VARCHAR(50),
dob VARCHAR(20),
gender VARCHAR(20),
email VARCHAR(100),
marital_status VARCHAR(20),
address VARCHAR(100),
city VARCHAR(30),
state VARCHAR(30),
pin VARCHAR(20)
);



CREATE TABLE signuptwo(
formno VARCHAR(20),
religion VARCHAR(20),
category VARCHAR(20),
income VARCHAR(20),
education_qualification VARCHAR(20),
occupation VARCHAR(20),
pan_number VARCHAR(20),
aadhar_number VARCHAR(20),
senior_citizen VARCHAR(20),
existing_account VARCHAR(20)
);

SELECT * FROM signuptwo;

CREATE TABLE signupthree(
formno VARCHAR(20),
account_type VARCHAR(50),
card_number VARCHAR(20),
pin VARCHAR(20),
facilities VARCHAR(100)
);

SELECT * FROM signupthree;

CREATE TABLE login(
formno VARCHAR(20),
card_number VARCHAR(20),
pin VARCHAR(20)
);

Select * from login;



create table bank(
accountNo varchar(20),
date varchar(50),
type varchar(20),
amount varchar(20)
);

drop table bank;
truncate table bank;

select * from bank;


