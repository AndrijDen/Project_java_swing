-- MySQL Script generated by MySQL Workbench
-- Sun Feb  4 19:49:35 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema projects
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `projects` ;

-- -----------------------------------------------------
-- Schema projects
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projects` DEFAULT CHARACTER SET utf8 ;
USE `projects` ;

-- -----------------------------------------------------
-- Table `projects`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Department` ;

CREATE TABLE IF NOT EXISTS `projects`.`Department` (
  `idDepartment` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNum` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartment`))
ENGINE = InnoDB;

insert into Department (Name, PhoneNum) values ("Business Solutions Development department", "093232323234");
insert into Department (Name, PhoneNum) values ("Banking Solutions Development department", "0931104009");
insert into Department (Name, PhoneNum) values ("Quality Assurance department", "0974454697");
insert into Department (Name, PhoneNum) values ("Design department", "0965456102");
insert into Department (Name, PhoneNum) values ("Management department", "0938543207");


-- -----------------------------------------------------
-- Table `projects`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Project` ;

CREATE TABLE IF NOT EXISTS `projects`.`Project` (
  `idProject` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Client` VARCHAR(45) NOT NULL,
  `Beginning` DATE NOT NULL,
  `EndingPlanned` DATE NOT NULL,
  `EndingFact` DATE NULL,
  `Cost` DECIMAL(15,2) NOT NULL,
  `Spending` DECIMAL(15,2) NOT NULL,
  `Rate` VARCHAR(45) NULL,
  `idDepartment` INT NULL,
  PRIMARY KEY (`idProject`),
  INDEX `Project_idDepartment_idx` (`idDepartment` ASC),
  CONSTRAINT `Project_idDepartment`
    FOREIGN KEY (`idDepartment`)
    REFERENCES `projects`.`Department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into Project (Name, idDepartment, Client, Beginning, EndingPlanned, EndingFact, Cost, Spending, Rate) values ("Rozetka mobile app", 1, "Rozetka", '2017-12-25', '2018-03-21', '2018-03-21', 90000, 90000, "done");
insert into Project (Name, idDepartment, Client, Beginning, EndingPlanned, Cost, Spending, Rate) values ("Scheduler", 1, "BBC Ukraine", '2018-02-25', '2018-05-25', 25000, 11000, "in progress");

insert into Project (Name, idDepartment, Client, Beginning, EndingPlanned, EndingFact, Cost, Spending, Rate) values ("Oshchad official web site", 2, "Oshchad bank", '2017-09-11', '2017-11-01', '2017-11-01', 55000, 55000, "done");
insert into Project (Name, idDepartment, Client, Beginning, EndingPlanned, Cost, Spending, Rate) values ("Privat24 mobile app", 2, "Privat bank", '2017-10-05', '2018-01-24', 70000, 20000, "failed");

insert into Project (Name, idDepartment, Client, Beginning, EndingPlanned, EndingFact, Cost, Spending, Rate) values ("Nova poshta rebranding", 4, "Nova poshta", '2017-03-23', '2017-05-11', '2017-05-11', 10000, 5000, "done");



-- -----------------------------------------------------
-- Table `projects`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Staff` ;

CREATE TABLE IF NOT EXISTS `projects`.`Staff` (
  `idStaff` INT NOT NULL AUTO_INCREMENT,
  `Surname` VARCHAR(45) NOT NULL,
  `Sex` VARCHAR(10) NOT NULL,
  `BirthDate` DATE NOT NULL,
  PRIMARY KEY (`idStaff`))
ENGINE = InnoDB;

insert into Staff (Surname, Sex, BirthDate) values ("Brunets", "male", '1997-08-03');
insert into Staff (Surname, Sex, BirthDate) values ("Denysenko", "male", '1997-03-03');
insert into Staff (Surname, Sex, BirthDate) values ("Andreeva", "female", '1997-11-21');
insert into Staff (Surname, Sex, BirthDate) values ("Zacheshygryva", "female", '1997-11-11');
insert into Staff (Surname, Sex, BirthDate) values ("Ivanenko", "male", '1994-08-03');
insert into Staff (Surname, Sex, BirthDate) values ("Kostenko", "male", '1992-06-15');
insert into Staff (Surname, Sex, BirthDate) values ("Petrenko", "female", '1996-10-03');
insert into Staff (Surname, Sex, BirthDate) values ("Bolonna", "famale", '1997-06-13');
insert into Staff (Surname, Sex, BirthDate) values ("Biletska", "female", '1993-02-09');
insert into Staff (Surname, Sex, BirthDate) values ("Shevchenko", "male", '1986-01-01');
insert into Staff (Surname, Sex, BirthDate) values ("Jobs", "male", '1995-05-05');

-- -----------------------------------------------------
-- Table `projects`.`Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Position` ;

CREATE TABLE IF NOT EXISTS `projects`.`Position` (
  `idPosition` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Beginning` DATE NOT NULL,
  `Ending` DATE NULL,
  `Pay` DECIMAL(10,2) NOT NULL,
  `idDepartment` INT NULL,
  `idStaff` INT NULL,
  PRIMARY KEY (`idPosition`),
  INDEX `idDepartment_idx` (`idDepartment` ASC),
  INDEX `idStaff_idx` (`idStaff` ASC),
  CONSTRAINT `Position_idDepartment`
    FOREIGN KEY (`idDepartment`)
    REFERENCES `projects`.`Department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Position_idStaff`
    FOREIGN KEY (`idStaff`)
    REFERENCES `projects`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Project manager", '2016-05-03', '2017-05-03', 5000, 5, 1);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Architect", '2016-05-03', '2017-05-03', 4000, 5, 2);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Project manager", '2016-05-03', '2018-05-03', 4000, 5, 3);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Architect", '2016-05-03', '2018-05-03', 4000, 5, 4);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("QA engineer", '2016-05-03', '2018-05-03', 2000, 3, 5);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("UI/UX designer", '2016-05-03', '2018-05-03', 1500, 4, 6);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Senior developer", '2016-05-03', '2018-05-03', 3000, 1, 7);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Senior developer", '2016-05-03', '2017-05-03', 3000, 1, 8);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Senior developer", '2016-05-03', '2018-05-03', 3000, 2, 9);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Middle developer", '2016-05-03', '2018-05-03', 2000, 2, 10);
insert into Position (Title, Beginning, Ending, Pay, idDepartment, idStaff) values ("Junior developer", '2016-05-03', '2018-05-03', 1000, 2, 11);


-- -----------------------------------------------------
-- Table `projects`.`Stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Stage` ;

CREATE TABLE IF NOT EXISTS `projects`.`Stage` (
  `idStage` INT NOT NULL AUTO_INCREMENT,
  `Number` INT NOT NULL,
  `Beginning` DATE NOT NULL,
  `EndingPlanned` DATE NOT NULL,
  `EndingFact` DATE NULL,
  `Cost` DECIMAL(10,2) NOT NULL,
  `Spending` DECIMAL(10,2) NOT NULL,
  `idProject` INT NULL,
  PRIMARY KEY (`idStage`),
  INDEX `Stage_idProject_idx` (`idProject` ASC),
  CONSTRAINT `Stage_idProject`
    FOREIGN KEY (`idProject`)
    REFERENCES `projects`.`Project` (`idProject`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;



insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (1,1,'2017-12-25','2018-01-11','2018-01-11',50000,50000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (2,1,'2018-01-11','2018-02-24','2018-02-24',20000,20000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (3,1,'2018-02-24','2018-03-21','2018-03-21',20000,20000);

insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (1,2,'2018-02-25','2018-03-25','2018-03-25',15000,11000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, Cost, Spending) values (2,2,'2018-03-25','2018-05-25',10000,0);

insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (1,3,'2017-09-11','2017-09-29','2017-09-29',10000,10000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (2,3,'2017-09-29','2017-10-11','2017-10-11',25000,25000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (3,3,'2017-10-11','2017-11-01','2017-11-01',20000,20000);

insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (1,4,'2017-10-05','2017-11-05','2017-11-05',20000,20000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, Cost, Spending) values (2,4,'2017-11-05','2017-12-05',40000,0);
insert into Stage (Number, idProject, Beginning, EndingPlanned, Cost, Spending) values (3,4,'2017-12-05','2018-01-24',10000,0);

insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (1,5,'2017-03-23','2017-04-23','2017-04-23',5000,5000);
insert into Stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values (2,5,'2017-04-23','2017-05-11','2017-05-11',5000,5000);



-- -----------------------------------------------------
-- Table `projects`.`Manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Manager` ;

CREATE TABLE IF NOT EXISTS `projects`.`Manager` (
  `idManager` INT NOT NULL AUTO_INCREMENT,
  `Beginning` DATE NOT NULL,
  `Ending` DATE NULL,
  `Pay` DECIMAL(10,2) NOT NULL,
  `idStaff` INT NULL,
  `idProject` INT NULL,
  PRIMARY KEY (`idManager`),
  INDEX `Manager_idStaff_idx` (`idStaff` ASC),
  INDEX `Manager_idProject_idx` (`idProject` ASC),
  CONSTRAINT `Manager_idStaff`
    FOREIGN KEY (`idStaff`)
    REFERENCES `projects`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Manager_idProject`
    FOREIGN KEY (`idProject`)
    REFERENCES `projects`.`Project` (`idProject`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into Manager (Beginning, Ending, Pay, idStaff, idProject) values ('2017-12-25', '2018-03-21', 1000, 1, 1);
insert into Manager (Beginning, Ending, Pay, idStaff, idProject) values ('2018-02-25', '2018-03-25', 1000, 2, 2);
insert into Manager (Beginning, Ending, Pay, idStaff, idProject) values ('2017-09-11', '2017-11-01', 1000, 3, 3);
insert into Manager (Beginning, Ending, Pay, idStaff, idProject) values ('2017-10-05', '2017-11-05', 1000, 4, 4);
insert into Manager (Beginning, Ending, Pay, idStaff, idProject) values ('2017-03-23', '2017-05-11', 1000, 1, 5);

-- -----------------------------------------------------
-- Table `projects`.`Work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Work` ;

CREATE TABLE IF NOT EXISTS `projects`.`Work` (
  `idWork` INT NOT NULL AUTO_INCREMENT,
  `Beginning` DATE NOT NULL,
  `Ending` DATE NULL,
  `Description` VARCHAR(400) NOT NULL,
  `idStage` INT NULL,
  `idStaff` INT NULL,
  PRIMARY KEY (`idWork`),
  INDEX `Work_idStaff_idx` (`idStaff` ASC),
  INDEX `Work_idStage_idx` (`idStage` ASC),
  CONSTRAINT `Work_idStage`
    FOREIGN KEY (`idStage`)
    REFERENCES `projects`.`Stage` (`idStage`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Work_idStaff`
    FOREIGN KEY (`idStaff`)
    REFERENCES `projects`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-12-25', '2018-01-11', 'creating working plan', 1, 1);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-01-11', '2018-02-24', 'share responsibilities between developers', 2, 1);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-24', '2018-03-21', 'project documentation', 3, 1);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-03-23', '2017-04-23', 'creating working plan', 12, 1);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-04-23', '2017-05-11', 'project documentation', 13, 1);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-25', '2018-03-25', 'creating working plan', 4, 2);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-11', '2017-09-29', 'creating working plan', 6, 3);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-29', '2017-10-11', 'refactoring the code', 7, 3);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-11', '2017-11-01', 'project documentation', 8, 3);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-05', '2017-11-05', 'creating working plan', 9, 4);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-24', '2018-03-21', 'testing the project', 3, 5);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-11', '2017-11-01', 'tesing API', 8, 5);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-03-23', '2017-04-23', 'making wareframes', 12, 6);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-04-23', '2017-05-11', 'making mockups', 13, 6);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-12-25', '2018-01-11', 'making initial architecture', 1, 7);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-01-11', '2018-02-24', 'backend development', 2, 7);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-24', '2018-03-21', 'code debugging', 3, 7);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-12-25', '2018-01-11', 'making initial architecture', 1, 8);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-01-11', '2018-02-24', 'frontend development', 2, 8);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-24', '2018-03-21', 'binding frontend with API', 3, 8);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-25', '2018-03-25', 'making initial architecture', 4, 7);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2018-02-25', '2018-03-25', 'making initial stubs', 4, 8);


insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-11', '2017-09-29', 'making initial architecture', 6, 9);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-29', '2017-10-11', 'API development', 7, 9);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-11', '2017-11-01', 'debugging', 8, 9);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-05', '2017-11-05', 'making stubs', 9, 9);


insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-11', '2017-09-29', 'making stubs', 6, 10);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-29', '2017-10-11', 'frontend development', 7, 10);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-11', '2017-11-01', 'binding with API', 8, 10);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-05', '2017-11-05', 'making initial architecture', 9, 10);

insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-09-29', '2017-10-11', 'API development', 7, 11);
insert into Work (Beginning, Ending, Description, idStage, idStaff) values ('2017-10-11', '2017-11-01', 'debugging', 8, 11);




-- -----------------------------------------------------
-- Table `projects`.`Balance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Balance` ;

CREATE TABLE IF NOT EXISTS `projects`.`Balance` (
  `idBalance` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Spending` DECIMAL(15,2) NOT NULL,
  `Profit` DECIMAL(15,2) NOT NULL,
  `Remainder` DECIMAL(20,2) NOT NULL,
  PRIMARY KEY (`idBalance`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projects`.`Flow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projects`.`Flow` ;

CREATE TABLE IF NOT EXISTS `projects`.`Flow` (
  `idFlow` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Sum` DECIMAL(20,2) NOT NULL,
  `Year` INT NOT NULL,
  `Month` INT NOT NULL,
  `idStaff` INT NULL,
  `idManager` INT NULL,
  `idWork` INT NULL,
  `idStage` INT NULL,
  `idBalance` INT NULL,
  `FlowType` INT NOT NULL,
  PRIMARY KEY (`idFlow`),
  INDEX `Flow_idStaff_idx` (`idStaff` ASC),
  INDEX `Flow_idManager_idx` (`idManager` ASC),
  INDEX `Flow_idWork_idx` (`idWork` ASC),
  INDEX `Flow_idStage_idx` (`idStage` ASC),
  INDEX `Flow_idBalance_idx` (`idBalance` ASC),
  CONSTRAINT `Flow_idStaff`
    FOREIGN KEY (`idStaff`)
    REFERENCES `projects`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Flow_idManager`
    FOREIGN KEY (`idManager`)
    REFERENCES `projects`.`Manager` (`idManager`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Flow_idWork`
    FOREIGN KEY (`idWork`)
    REFERENCES `projects`.`Work` (`idWork`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Flow_idStage`
    FOREIGN KEY (`idStage`)
    REFERENCES `projects`.`Stage` (`idStage`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `Flow_idBalance`
    FOREIGN KEY (`idBalance`)
    REFERENCES `projects`.`Balance` (`idBalance`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (1,'2017-12-25',25000,2017,12,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (1,'2017-12-28',25000,2017,12,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (2,'2018-01-11',20000,2018,1,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (3,'2018-02-24',20000,2018,2,4);

insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (4,'2018-02-25',8000,2018,2,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (4,'2018-02-26',3000,2018,2,4);

insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (6,'2017-09-25',10000,2017,9,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (7,'2017-09-29',20000,2017,9,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (7,'2017-10-02',5000,2017,10,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (8,'2017-10-11',10000,2017,10,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (8,'2017-10-25',10000,2017,10,4);

insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (9,'2017-10-05',20000,2017,10,4);

insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (12,'2017-03-23',5000,2017,3,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (13,'2017-04-25',2000,2017,4,4);
insert into Flow (idStage, Date, Sum, Year, Month, FlowType) values (13,'2017-04-26',3000,2017,4,4);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;