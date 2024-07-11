
create database btl_spring_mvc_02
go
use btl_spring_mvc_02
go
CREATE TABLE Category (
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
    FOREIGN KEY (CatId) REFERENCES Category(CatId), 
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
CREATE TABLE Customers (
    CusId INT identity PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Phone VARCHAR(20),
    Address NVARCHAR(255)
)
go
CREATE TABLE Invoices (
    InId INT identity PRIMARY KEY,
    CuIid INT,
    Invoice_date DATE,
    Total_amount DECIMAL(10, 2),
    FOREIGN KEY (CuIid) REFERENCES Customers(CusId)
);
go
CREATE TABLE Invoice_details (
    Deid INT identity PRIMARY KEY,
    InId INT,
    ProId INT,
    Quantity INT,
    Unit_price DECIMAL(10, 2),
    Total_price DECIMAL(10, 2),
    FOREIGN KEY (InId) REFERENCES Invoices(InId),
    FOREIGN KEY (ProId) REFERENCES Product(ProId)
);
go
insert into Users values 
(N'hồ sỹ quân', 'admin@gmail.com', 0, '0389225794','','123456')
go
insert into Category values
(N'áo'),
(N'quần'),
(N'dày')