create database btl_spring_mvc_02
go
use btl_spring_mvc_02
go
CREATE TABLE Categories (
    CatId INT PRIMARY KEY identity,
    Name NVARCHAR(255)
)
go
CREATE TABLE Supplier (
    SupId INT PRIMARY KEY identity,
    Name NVARCHAR(255),
    Address NVARCHAR(255),
    PhoneNumber NVARCHAR(20)
)
go
CREATE TABLE Product (
    ProId INT PRIMARY KEY identity,
    Name NVARCHAR(255),
    CatId INT,
    SupId INT,
    Price DECIMAL(18,2),
    Quantity INT,
    FOREIGN KEY (CatId) REFERENCES Categories(CatId),
	FOREIGN KEY (SupId) REFERENCES Supplier(SupId)   
)
go


CREATE TABLE Invoices (
    INId INT PRIMARY KEY identity,
    InvoiceDate DATE,
    InvoiceType NVARCHAR(50)
)
go
create table Users (
	UseId INT PRIMARY KEY identity,
	FullName nvarchar(100) not null unique,
	Email varchar(100) not null,
	Gender bit not null,
	Phone varchar(20) not null,
	UserPassWord varchar(100) 
)
go
insert into Users values 
(N'hồ sỹ quân', 'quan2@gmail.com', 0, '0123777777','helloquan')
go
select * from Users