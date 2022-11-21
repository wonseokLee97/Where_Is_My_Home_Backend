-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongcode` VARCHAR(10) NOT NULL,
  `sidoname` VARCHAR(30) NULL DEFAULT NULL,
  `gugunname` VARCHAR(30) NULL DEFAULT NULL,
  `dongname` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `sidoname` VARCHAR(30) NULL DEFAULT NULL,
  `gugunname` VARCHAR(30) NULL DEFAULT NULL,
  `dongname` VARCHAR(30) NULL DEFAULT NULL,
  `dongcode` VARCHAR(10) NULL DEFAULT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `dongCode` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `baseaddress_ibfk_1`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`member` (
  `userid` VARCHAR(15) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(30) NOT NULL,
  `emailid` VARCHAR(20) NOT NULL,
  `emaildomain` VARCHAR(20) NOT NULL,
  `joindate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grade` VARCHAR(10) NOT NULL,
  `token` VARCHAR(1000) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`board` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT '0',
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  CONSTRAINT `board_to_member_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`member` (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`comment` (
  `commentno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `content` VARCHAR(500) NULL DEFAULT NULL,
  `regtime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `articleno` INT NOT NULL,
  PRIMARY KEY (`commentno`),
  INDEX `fk_comment_board1_idx` (`articleno` ASC) VISIBLE,
  INDEX `fk_comment_member_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_comment_board`
    FOREIGN KEY (`articleno`)
    REFERENCES `happyhouse`.`board` (`articleno`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_comment_member`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`member` (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`coronatest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`coronatest` (
  `coronatestno` INT NOT NULL AUTO_INCREMENT,
  `sidoname` VARCHAR(45) NULL DEFAULT NULL,
  `gugunname` VARCHAR(45) NULL DEFAULT NULL,
  `coronatestname` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `tel` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`coronatestno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`favorite` (
  `userid` VARCHAR(15) NOT NULL,
  `dongcode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`userid`, `dongcode`),
  INDEX `favorite_dongcode_fk_dongCode_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `favorite_dongcode_fk_dongCode`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`),
  CONSTRAINT `favorite_member_fk_userId`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`member` (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `guguncode` VARCHAR(10) NOT NULL,
  `gugunname` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`guguncode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `hospitalno` INT NOT NULL AUTO_INCREMENT,
  `sidoname` VARCHAR(45) NULL DEFAULT NULL,
  `gugunname` VARCHAR(45) NULL DEFAULT NULL,
  `hospitalname` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `tel` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`hospitalno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `aptcode` BIGINT NOT NULL,
  `buildyear` INT NULL DEFAULT NULL,
  `roadname` VARCHAR(40) NULL DEFAULT NULL,
  `roadnamebonbun` VARCHAR(5) NULL DEFAULT NULL,
  `roadnamebubun` VARCHAR(5) NULL DEFAULT NULL,
  `roadnameseq` VARCHAR(2) NULL DEFAULT NULL,
  `roadnamebasementcode` VARCHAR(1) NULL DEFAULT NULL,
  `roadnamecode` VARCHAR(7) NULL DEFAULT NULL,
  `dong` VARCHAR(40) NULL DEFAULT NULL,
  `bonbun` VARCHAR(4) NULL DEFAULT NULL,
  `bubun` VARCHAR(4) NULL DEFAULT NULL,
  `sigungucode` VARCHAR(5) NULL DEFAULT NULL,
  `eubmyundongcode` VARCHAR(5) NULL DEFAULT NULL,
  `dongcode` VARCHAR(10) NULL DEFAULT NULL,
  `landcode` VARCHAR(1) NULL DEFAULT NULL,
  `apartmentname` VARCHAR(40) NULL DEFAULT NULL,
  `jibun` VARCHAR(10) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`aptcode`),
  UNIQUE INDEX `UNIQUE` (`buildyear` ASC, `apartmentname` ASC, `jibun` ASC, `sigungucode` ASC, `eubmyundongcode` ASC) INVISIBLE,
  INDEX `houseinfo_dongCode_dongcode_dongCode_fk_idx` (`dongcode` ASC) INVISIBLE,
  CONSTRAINT `houseinfo_dongCode_dongcode_dongCode_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` BIGINT NOT NULL,
  `dealamount` VARCHAR(20) NULL DEFAULT NULL,
  `dealyear` INT NULL DEFAULT NULL,
  `dealmonth` INT NULL DEFAULT NULL,
  `dealday` INT NULL DEFAULT NULL,
  `area` VARCHAR(20) NULL DEFAULT NULL,
  `floor` VARCHAR(4) NULL DEFAULT NULL,
  `canceldealtype` VARCHAR(1) NULL DEFAULT NULL,
  `aptcode` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `housedeal_aptCode_houseinfo_aptCode_fk_idx` (`aptcode` ASC) VISIBLE,
  CONSTRAINT `housedeal_aptCode_houseinfo_aptCode_fk`
    FOREIGN KEY (`aptcode`)
    REFERENCES `happyhouse`.`houseinfo` (`aptcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`pollution`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`pollution` (
  `pollno` INT NOT NULL AUTO_INCREMENT,
  `pollname` VARCHAR(45) NULL DEFAULT NULL,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`pollno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sidocode` VARCHAR(10) NOT NULL,
  `sidoname` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sidocode`),
  UNIQUE INDEX `sidoName` (`sidoname` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`store` (
  `storeno` BIGINT NOT NULL,
  `storename` VARCHAR(45) NULL DEFAULT NULL,
  `branch` VARCHAR(45) NULL DEFAULT NULL,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `dongcode` VARCHAR(10) NOT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `floor` VARCHAR(4) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`storeno`),
  INDEX `store_dongcode_fk_dongcode_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `store_dongcode_fk_dongcode`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;