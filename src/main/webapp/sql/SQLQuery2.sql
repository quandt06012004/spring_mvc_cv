create database btl_spring_mvc_02
go
use btl_spring_mvc_02
go
CREATE TABLE Categories (
    CatId INT PRIMARY KEY identity,
    Name NVARCHAR(255)
)
go
CREATE TABLE Product (
    ProId INT PRIMARY KEY identity,
    Name NVARCHAR(255),
    CatId INT,
    Price DECIMAL(18,2),
    Quantity INT,
	Credate date,
	Imgage varchar(100),
	describe nvarchar(500),
    FOREIGN KEY (CatId) REFERENCES Categories(CatId), 
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
	Avatar nvarchar(200),
	UserPassWord varchar(100) 
)
go
insert into Users values 
(N'hồ sỹ quân', 'admin@gmail.com', 0, '0389225794','','123456')
go
select * from Users