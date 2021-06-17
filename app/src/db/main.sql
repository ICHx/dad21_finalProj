use college;
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists Dept;
create table if not exists Dept (
    DeptID varchar(5) primary key,
    DeptName text not null,
    DeptAddress text not null,
    DeptPhone int not null
);
-- assume deptphone == landline, max=8digits
-- ok
drop table if exists Account;
Create table if not exists Account (
    NetID varchar(20) primary key,
    FirstName TEXT NOT NULL,
    LastName TEXT NOT NULL,
    DeptID varchar(5) NOT NULL,
    Gender VARCHAR(1) NOT NULL,
    Phone varchar(20) NULL,
    FOREIGN KEY (DeptID) REFERENCES Dept (DeptID)
);
-- assume user phone is 8-11 digits or more.
-- ok
drop table if exists DeptHead;
create table DeptHead (
    ForDeptID varchar(5) primary key,
    HeadID varchar(20) null UNIQUE,
    FOREIGN KEY (HeadID) REFERENCES Account (NetID),
    FOREIGN KEY (ForDeptID) REFERENCES Dept (DeptID)
);
-- ok
drop table if exists Course;
Create table Course (
    DeptID varchar(5),
    CourseID INT NOT NULL,
    CourseName TEXT NOT NULL,
    Remarks TEXT NULL,
    FOREIGN KEY (DeptID) REFERENCES Dept (DeptID),
    PRIMARY KEY (DeptID, CourseID)
);
-- ok
drop table if exists Teach;
create table Teach (
    TeacherID varchar(20) not null,
    DeptID varchar(5) not null,
    CourseID INT not null,
    FOREIGN KEY (TeacherID) REFERENCES Account (NetID),
    FOREIGN KEY (DeptID, CourseID) REFERENCES Course (DeptID, CourseID),
    PRIMARY KEY (DeptID, CourseID) -- one course entry one teacher
);
-- ok
drop table if exists Enroll;
create table Enroll (
    StudentID varchar(20) not null,
    DeptID varchar(5) not null,
    CourseID INT not null,
    FOREIGN KEY (StudentID) REFERENCES Account (NetID),
    FOREIGN KEY (DeptID, CourseID) REFERENCES Course (DeptID, CourseID),
    PRIMARY KEY (StudentID, DeptID, CourseID)
);
-- one student and one course = one entry, many entries allowed
-- ok
create table if not exists Password(
    NetID varchar(20) primary key,
    PIN TEXT NOT NULL,
    FOREIGN KEY (NetID) REFERENCES Account(NetID)
);