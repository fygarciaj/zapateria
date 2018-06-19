-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.19 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5278
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para zapateria
DROP DATABASE IF EXISTS `zapateria`;
CREATE DATABASE IF NOT EXISTS `zapateria` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */;
USE `zapateria`;

-- Volcando estructura para tabla zapateria.clientes
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_completo` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.clientes: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id`, `identificacion`, `nombre_completo`, `fecha_nacimiento`, `telefono`, `direccion`) VALUES
	(1, '77171435', 'Fabian Garcia', '1972-12-18', '3166579426', 'MZ I C 19 U LA CEIBA'),
	(2, '49787787', 'Lisbeth Bolaño', '1975-12-10', '3166579426', 'MZ I C 19 U LA CEIBA'),
	(22, '1234123', 'Maria la loca', '2018-06-12', 'adfad', 'fadf'),
	(23, '2345', 'Dayana Garcia Jurado', '1900-01-01', 'fadf ads', 'sfad df ad'),
	(26, '49787878', 'Claudia Maria', '2018-06-04', 'Alla', 'Aqui'),
	(27, '23424234', 'MARIA JIMENEZ', '2018-06-13', '3166572426', 'MZ I C 19'),
	(28, '49747452', 'TUROR PROGRAMACION JAVA', '1900-01-01', '5710090', 'MZ 9 C 13');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.permisos
DROP TABLE IF EXISTS `permisos`;
CREATE TABLE IF NOT EXISTS `permisos` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL DEFAULT '0',
  `descripcion` varchar(50) COLLATE utf8_spanish2_ci DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.permisos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.permisos_roles
DROP TABLE IF EXISTS `permisos_roles`;
CREATE TABLE IF NOT EXISTS `permisos_roles` (
  `permisos_id` int(11) unsigned NOT NULL,
  `roles_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`permisos_id`,`roles_id`),
  KEY `roles_id` (`roles_id`),
  CONSTRAINT `FK_permisos_roles_permisos` FOREIGN KEY (`permisos_id`) REFERENCES `permisos` (`Id`),
  CONSTRAINT `FK_permisos_roles_roles` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.permisos_roles: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `permisos_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos_roles` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.reparaciones
DROP TABLE IF EXISTS `reparaciones`;
CREATE TABLE IF NOT EXISTS `reparaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_reparacion` text COLLATE utf8_spanish2_ci,
  `valor` decimal(15,0) DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  `usuarios_id` int(11) NOT NULL,
  `tipos_calzados_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_reparaciones_clientes1_idx` (`clientes_id`),
  KEY `fk_reparaciones_usuarios1_idx` (`usuarios_id`),
  KEY `fk_reparaciones_tipos_calzados1_idx` (`tipos_calzados_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.reparaciones: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` (`id`, `descripcion_reparacion`, `valor`, `clientes_id`, `usuarios_id`, `tipos_calzados_id`) VALUES
	(1, 'Arreglo de zapatos tenis', 20000, 1, 1, 1),
	(2, 'Arreglo sandalias', 30000, 2, 1, 1);
/*!40000 ALTER TABLE `reparaciones` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `rol` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.roles: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.roles_usuarios
DROP TABLE IF EXISTS `roles_usuarios`;
CREATE TABLE IF NOT EXISTS `roles_usuarios` (
  `roles_id` int(11) unsigned NOT NULL,
  `usuarios_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`roles_id`,`usuarios_id`),
  KEY `roles_id` (`roles_id`),
  CONSTRAINT `FK_roles_usuarios_roles` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.roles_usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `roles_usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles_usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.tickets
DROP TABLE IF EXISTS `tickets`;
CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `valor_total` decimal(15,0) DEFAULT NULL,
  `usuarios_id` int(11) NOT NULL,
  `clientes_id` int(11) NOT NULL,
  `reparaciones_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tickets_usuarios1_idx` (`usuarios_id`),
  KEY `fk_tickets_clientes1_idx` (`clientes_id`),
  KEY `fk_tickets_reparaciones1_idx` (`reparaciones_id`),
  CONSTRAINT `fk_tickets_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_reparaciones1` FOREIGN KEY (`reparaciones_id`) REFERENCES `reparaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.tickets: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.tickets_detalles
DROP TABLE IF EXISTS `tickets_detalles`;
CREATE TABLE IF NOT EXISTS `tickets_detalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor_unitario` decimal(15,0) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` decimal(15,0) NOT NULL,
  `tickets_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tickets_detalles_tickets1_idx` (`tickets_id`),
  CONSTRAINT `fk_tickets_detalles_tickets1` FOREIGN KEY (`tickets_id`) REFERENCES `tickets` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.tickets_detalles: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tickets_detalles` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets_detalles` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.tipos_calzados
DROP TABLE IF EXISTS `tipos_calzados`;
CREATE TABLE IF NOT EXISTS `tipos_calzados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_calzado` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.tipos_calzados: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_calzados` DISABLE KEYS */;
INSERT INTO `tipos_calzados` (`id`, `nombre_calzado`) VALUES
	(1, 'Zapatos Tenis'),
	(2, 'Zapatos Cuero'),
	(3, 'Zapatos Tela'),
	(4, 'Chancletas');
/*!40000 ALTER TABLE `tipos_calzados` ENABLE KEYS */;

-- Volcando estructura para tabla zapateria.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(16) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_completo` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `telefono` varchar(12) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre_usuario` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla zapateria.usuarios: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `identificacion`, `nombre_completo`, `edad`, `direccion`, `telefono`, `nombre_usuario`, `password`) VALUES
	(1, '77171435', 'Fabian Garcia Jurado', 45, 'MZ I CA 19 U LA CEIBA', '231255222', 'fygarciaj', '$2a$10$/MpDQSbOGrcPwkAwefOXRuQos3gwVjo4nPkhokZIVyL9sYx6nI9Ba'),
	(2, '49787878', 'LISBETH R BOLAÑO', 38, 'XXXXX', 'XXXX', 'lisbeth', '$2a$10$7pYoiUFBZ0HNVX0bQlDWiOTp/Wyxjn3n0nhCBAE4h9B/4zP/LuhC2');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
