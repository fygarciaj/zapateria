-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zapateria
-- -----------------------------------------------------
-- Base de Datos de la zapateria calzaditos.
-- Author: Fabian Garcia
-- Universidad Nacional Abierta y a Distancia, Colombia - 2018

-- -----------------------------------------------------
-- Schema zapateria
--
-- Base de Datos de la zapateria calzaditos.
-- Author: Fabian Garcia
-- Universidad Nacional Abierta y a Distancia, Colombia - 2018
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zapateria` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `zapateria` ;

-- -----------------------------------------------------
-- Table `zapateria`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificacion` VARCHAR(20) NOT NULL,
  `nombre_completo` VARCHAR(100) NULL,
  `fecha_nacimiento` DATE NULL,
  `telefono` VARCHAR(20) NULL,
  `direccion` VARCHAR(100) NULL,
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificacion` VARCHAR(16) NOT NULL,
  `nombre_completo` VARCHAR(100) NULL,
  `edad` INT NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` VARCHAR(12) NULL,
  `roles_id` INT NOT NULL,
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_usuarios_roles_idx` (`roles_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_usuarios_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `zapateria`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`tipos_calzados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`tipos_calzados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_calzado` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`reparaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`reparaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion_reparacion` TEXT NULL,
  `valor` DECIMAL(15,0) NULL,
  `clientes_id` INT NOT NULL,
  `usuarios_id` INT NOT NULL,
  `tipos_calzados_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_reparaciones_clientes1_idx` (`clientes_id` ASC),
  INDEX `fk_reparaciones_usuarios1_idx` (`usuarios_id` ASC),
  INDEX `fk_reparaciones_tipos_calzados1_idx` (`tipos_calzados_id` ASC),
  CONSTRAINT `fk_reparaciones_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `zapateria`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reparaciones_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `zapateria`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reparaciones_tipos_calzados1`
    FOREIGN KEY (`tipos_calzados_id`)
    REFERENCES `zapateria`.`tipos_calzados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `valor_total` DECIMAL(15,0) NULL,
  `usuarios_id` INT NOT NULL,
  `clientes_id` INT NOT NULL,
  `reparaciones_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_tickets_usuarios1_idx` (`usuarios_id` ASC),
  INDEX `fk_tickets_clientes1_idx` (`clientes_id` ASC),
  INDEX `fk_tickets_reparaciones1_idx` (`reparaciones_id` ASC),
  CONSTRAINT `fk_tickets_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `zapateria`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `zapateria`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_reparaciones1`
    FOREIGN KEY (`reparaciones_id`)
    REFERENCES `zapateria`.`reparaciones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateria`.`tickets_detalles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateria`.`tickets_detalles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor_unitario` DECIMAL(15,0) NOT NULL,
  `cantidad` INT NOT NULL,
  `subtotal` DECIMAL(15,0) NOT NULL,
  `tickets_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_tickets_detalles_tickets1_idx` (`tickets_id` ASC),
  CONSTRAINT `fk_tickets_detalles_tickets1`
    FOREIGN KEY (`tickets_id`)
    REFERENCES `zapateria`.`tickets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
