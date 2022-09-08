DROP DATABASE project_MatthewK;
CREATE DATABASE project_MatthewK;
USE Matthew_K;

CREATE TABLE `Employees` (
	`EmployeeID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
	`Name` varchar(30),
	`Address` varchar(50),
	`NIN` char(9) UNIQUE,
	`BankNum` char(17) UNIQUE,
	`Salary` decimal(10,2),
	`Department` varchar(20),
	`GrossPay` decimal(11,2),
    PRIMARY KEY (`EmployeeID`)
);

CREATE TABLE `SalesEmployees` (
   	`EmployeeID` smallint NOT NULL,
   	`Commission` decimal(10,2),
   	`TotalSales` decimal(10, 2),
	FOREIGN KEY (`EmployeeID`) REFERENCES Employees(`EmployeeID`)
);

CREATE TABLE `Projects` (
	`ProjectID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
	`ProjectName` varchar(30),
	`LeaderID` smallint NOT NULL,
	`EmployeeID` smallint NOT NULL,
	PRIMARY KEY (ProjectID),
	FOREIGN KEY (`EmployeeID`) REFERENCES Employees(`EmployeeID`)
);
