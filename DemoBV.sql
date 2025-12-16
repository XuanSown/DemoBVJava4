create database DemoBVJava4

use DemoBVJava4

create table Users(
	Id nvarchar(20) primary key not null,
	Password nvarchar(50) not null,
	Fullname nvarchar(50) not null,
	Email nvarchar(50) not null,
	Admin bit not null
)

insert into Users(Id, Password, Fullname, Email, Admin) values
(N'admin', N'123456', N'Quản Trị Viên', N'admin@fpt.edu.vn', 1),
(N'teonv', N'123', N'Nguyễn Văn Tèo', N'teonv@fpt.edu.vn', 0);

select * from Users