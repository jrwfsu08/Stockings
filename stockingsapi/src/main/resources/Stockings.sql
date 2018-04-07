USE Stockings;

DROP TABLE IF EXISTS Stockings;
DROP TABLE IF EXISTS StockData;
DROP TABLE IF EXISTS UserGeneral;

CREATE TABLE UserGeneral(
	Id int auto_increment,
    UserName varchar(20) UNIQUE,
    PasswordHash varbinary(64) NOT NULL,
    email varchar(30) NOT NULL,
    phone varchar(11) default 9999999999,
    isEmail bool,
    isText bool,
    constraint PK_UserGeneral_Id Primary Key Clustered (Id Asc),
    index(UserName, PasswordHash)
    );

Create Table StockData(
	Ticker varchar(4) not null,
    Price decimal not null default 0.00,

    primary key(Ticker)
    );

Create Table Stockings(
	UserGeneral_Id int not null,
    Stock_Ticker varchar(4) not null,
    Purch_Price decimal,
    Chang_Pct decimal default 5.00,
    Create_TS timestamp,
    Last_Update_TS timestamp,

    index(UserGeneral_Id),
    index(UserGeneral_Id, Stock_Ticker),

    foreign key(UserGeneral_id)
    references UserGeneral(Id)
    on update cascade
    on delete cascade,

    foreign key(Stock_Ticker)
    references StockData(Ticker)
    );