create table if not exists Dept (
    DeptID varchar(5) primary key,
    DeptName text not null,
    DeptAddress text not null,
    DeptPhone int not null
);
-- ok
Create table if not exists Account (
    NetID varchar(20) primary key,
    FirstName TEXT,
    LastName TEXT,
    DeptID varchar(5),
    FOREIGN KEY (DeptID) REFERENCES Dept(DeptID)
);
-- ok
drop table if exists DeptHead;
create table DeptHead(
    HeadID varchar(20) primary key,
    ForDeptID varchar(5),
    FOREIGN KEY (HeadID) REFERENCES Account(NetID),
    FOREIGN KEY (ForDeptID) REFERENCES Dept(DeptID)
);
-- ok
Create table if not exists Course (
    DeptID varchar(5),
    CourseID INT,
    CourseName TEXT,
    Quota INT,
    Remarks TEXT,
    
    FOREIGN KEY (DeptID) REFERENCES Dept(DeptID),
    PRIMARY KEY (DeptID, CourseID)
);
-- ok

-- not ok
create table Teach(
TeacherID varchar(20) not null,
DeptID varchar(5) not null,
CourseID INT not null,

FOREIGN KEY (TeacherID) REFERENCES Account(NetID), -- ok
FOREIGN KEY (DeptID,CourseID) REFERENCES Course(DeptID,CourseID), -- ok
PRIMARY KEY (DeptID, CourseID)
); --ok

create table Enroll(
StudentID varchar(20) not null,
DeptID varchar(5) not null,
CourseID INT not null,

FOREIGN KEY (StudentID) REFERENCES Account(NetID), -- ok
FOREIGN KEY (DeptID,CourseID) REFERENCES Course(DeptID,CourseID), -- ok
PRIMARY KEY (DeptID, CourseID)
); --ok