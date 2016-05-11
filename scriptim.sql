-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ctis252
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ctis252
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ctis252` DEFAULT CHARACTER SET utf8 ;
USE `ctis252` ;

-- -----------------------------------------------------
-- Table `ctis252`.`kasa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`kasa` (
  `date` INT(11) NOT NULL,
  `total` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ctis252`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `time` INT(11) NULL DEFAULT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ctis252`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tableno` INT(11) NULL DEFAULT NULL,
  `bill` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `menuid` INT(11) NULL DEFAULT NULL,
  `notlar` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ctis252`.`personel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`personel` (
  `id` INT(11) NOT NULL,
  `statu` VARCHAR(45) NULL DEFAULT NULL,
  `isim` VARCHAR(45) NULL DEFAULT NULL,
  `soyisim` VARCHAR(45) NULL DEFAULT NULL,
  `maas` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ctis252`.`restinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`restinfo` (
  `id` INT(11) NOT NULL,
  `adi` VARCHAR(45) NULL DEFAULT NULL,
  `slogani` VARCHAR(45) NULL DEFAULT NULL,
  `adresi` VARCHAR(45) NULL DEFAULT NULL,
  `telefon` VARCHAR(45) NULL DEFAULT NULL,
  `site` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ctis252`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctis252`.`user` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `pass` VARCHAR(45) NULL DEFAULT NULL,
  `type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
