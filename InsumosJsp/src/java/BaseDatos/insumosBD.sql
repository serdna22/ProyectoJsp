-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema insumos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema insumos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `insumos` DEFAULT CHARACTER SET utf8 ;
USE `insumos` ;

-- -----------------------------------------------------
-- Table `insumos`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`marca` (
  `idMarca` INT NOT NULL AUTO_INCREMENT,
  `marcaNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE INDEX `marcaNombre_UNIQUE` (`marcaNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`presentacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`presentacion` (
  `idPresentacion` INT NOT NULL AUTO_INCREMENT,
  `presentacionNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPresentacion`),
  UNIQUE INDEX `presentacionNombre_UNIQUE` (`presentacionNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`riesgo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`riesgo` (
  `idRiesgo` INT NOT NULL AUTO_INCREMENT,
  `riesgoClasificacion` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idRiesgo`),
  UNIQUE INDEX `riesoClasificacion_UNIQUE` (`riesgoClasificacion` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`temperatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`temperatura` (
  `idTemperatura` INT NOT NULL AUTO_INCREMENT,
  `temperaturaNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTemperatura`),
  UNIQUE INDEX `temperaturaNombre_UNIQUE` (`temperaturaNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`insumo` (
  `codigoInsumo` VARCHAR(11) NOT NULL,
  `insumoNombre` VARCHAR(45) NOT NULL,
  `insumoMarcaFK` INT NOT NULL,
  `insumoRiesgoFK` INT NOT NULL,
  `insumoPresentacionFK` INT NOT NULL,
  `insumoObservacion` VARCHAR(100) NOT NULL,
  `insumoExistencia` INT UNSIGNED NOT NULL,
  `insumoTemperaturaFK` INT NOT NULL,
  `insumoRuta` VARCHAR(45) NOT NULL,
  `insumoInvima` VARCHAR(50) NULL DEFAULT NULL,
  `insumoLote` VARCHAR(45) NULL DEFAULT NULL,
  `insumoVence` DATE NULL DEFAULT NULL,
  `insumoFichaTecnica` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoInsumo`),
  UNIQUE INDEX `insumoRuta_UNIQUE` (`insumoRuta` ASC) VISIBLE,
  INDEX `IDX-insumoMarca` (`insumoMarcaFK` ASC) VISIBLE,
  INDEX `IDX-insumoPresentacion` (`insumoPresentacionFK` ASC) VISIBLE,
  INDEX `IDX-insumoRiesgo` (`insumoRiesgoFK` ASC) VISIBLE,
  INDEX `FKinsumoTemperatura_idx` (`insumoTemperaturaFK` ASC) VISIBLE,
  CONSTRAINT `FKinsumoMarca`
    FOREIGN KEY (`insumoMarcaFK`)
    REFERENCES `insumos`.`marca` (`idMarca`),
  CONSTRAINT `FKinsumoPresentacion`
    FOREIGN KEY (`insumoPresentacionFK`)
    REFERENCES `insumos`.`presentacion` (`idPresentacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKinsumoRiesgo`
    FOREIGN KEY (`insumoRiesgoFK`)
    REFERENCES `insumos`.`riesgo` (`idRiesgo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKinsumoTemperatura`
    FOREIGN KEY (`insumoTemperaturaFK`)
    REFERENCES `insumos`.`temperatura` (`idTemperatura`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`alerta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`alerta` (
  `idAlerta` VARCHAR(11) NOT NULL,
  `alertaNombre` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`idAlerta`),
  CONSTRAINT `FKbajasInsumo`
    FOREIGN KEY (`idAlerta`)
    REFERENCES `insumos`.`insumo` (`codigoInsumo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoriaNombre` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `categoriaNombre_UNIQUE` (`categoriaNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`consultorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`consultorio` (
  `idConsultorio` INT NOT NULL AUTO_INCREMENT,
  `consultorioNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idConsultorio`),
  UNIQUE INDEX `consultorioNombre_UNIQUE` (`consultorioNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`proveedor` (
  `nitProveedor` VARCHAR(20) NOT NULL,
  `proveedorNombre` VARCHAR(45) NOT NULL,
  `proveedorDireccion` VARCHAR(45) NOT NULL,
  `proveedorTelefono` VARCHAR(30) NULL DEFAULT NULL,
  `proveedorCelular` VARCHAR(30) NOT NULL,
  `proveedorFecha` DATE NOT NULL,
  `proveedorCiudad` VARCHAR(45) NOT NULL,
  `proveedorCorreo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nitProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`tipodocumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`tipodocumento` (
  `idTipoDoc` INT NOT NULL AUTO_INCREMENT,
  `tipoDocNombre` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idTipoDoc`),
  UNIQUE INDEX `tipoIdeNombre_UNIQUE` (`tipoDocNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`usuarios` (
  `usuarioTipoIdenFK` INT NOT NULL,
  `usuarioDocumento` VARCHAR(12) NOT NULL,
  `usuarioNombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `usuarioCelular` VARCHAR(12) NOT NULL,
  `usuarioPrivilegio` TINYINT(1) NOT NULL,
  PRIMARY KEY (`usuarioDocumento`),
  INDEX `IDX-usuarioTipoIdenFK` (`usuarioTipoIdenFK` ASC) VISIBLE,
  CONSTRAINT `FKusuarioTipoIdenFK`
    FOREIGN KEY (`usuarioTipoIdenFK`)
    REFERENCES `insumos`.`tipodocumento` (`idTipoDoc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`factura` (
  `idFactura` VARCHAR(11) NOT NULL,
  `facturaProveedorFK` VARCHAR(20) NOT NULL,
  `facturaIvaTotal` DOUBLE UNSIGNED NOT NULL,
  `facturaDescuento` DOUBLE UNSIGNED NOT NULL,
  `facturaFecha` DATE NULL DEFAULT NULL,
  `facturaUsuario` VARCHAR(12) NULL DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `IDX-facturaProveedorFK` (`facturaProveedorFK` ASC) VISIBLE,
  INDEX `FKfacturaUsuario_idx` (`facturaUsuario` ASC) VISIBLE,
  CONSTRAINT `FKfacturaProveedor`
    FOREIGN KEY (`facturaProveedorFK`)
    REFERENCES `insumos`.`proveedor` (`nitProveedor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKfacturaUsuario`
    FOREIGN KEY (`facturaUsuario`)
    REFERENCES `insumos`.`usuarios` (`usuarioDocumento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`detallefactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`detallefactura` (
  `idDetalleFactura` INT NOT NULL AUTO_INCREMENT,
  `DFfacturaFK` VARCHAR(11) NOT NULL,
  `DFinsumoFK` VARCHAR(11) NOT NULL,
  `DFcantidadInsumo` INT UNSIGNED NOT NULL,
  `DFlote` VARCHAR(45) NOT NULL,
  `DFfechaVence` DATE NOT NULL,
  `DFinvima` VARCHAR(45) NOT NULL,
  `DFiva` FLOAT UNSIGNED NULL DEFAULT NULL,
  `DFvalorUnitario` DOUBLE UNSIGNED NOT NULL,
  `DFvalorTotal` DOUBLE UNSIGNED NOT NULL,
  PRIMARY KEY (`idDetalleFactura`),
  INDEX `IDX-DFfacturaFK` (`DFfacturaFK` ASC) VISIBLE,
  CONSTRAINT `FKDFidFactura`
    FOREIGN KEY (`DFfacturaFK`)
    REFERENCES `insumos`.`factura` (`idFactura`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`procedimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`procedimiento` (
  `idProcedimiento` INT NOT NULL AUTO_INCREMENT,
  `procedimientoNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProcedimiento`),
  UNIQUE INDEX `procedimientoNombre_UNIQUE` (`procedimientoNombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`salida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`salida` (
  `idSalida` VARCHAR(11) NOT NULL,
  `salidaUsuarioFK` VARCHAR(12) NOT NULL,
  `salidaConsultorioFK` INT NOT NULL,
  `salidaProcedimientoFK` INT NOT NULL,
  `salidaSala` VARCHAR(10) NOT NULL,
  `salidaPersonaRecibio` VARCHAR(45) NOT NULL,
  `salidaFecha` DATE NOT NULL,
  PRIMARY KEY (`idSalida`),
  INDEX `IDX-salidaTrabajadorFK` (`salidaUsuarioFK` ASC) VISIBLE,
  INDEX `FKsalidaConsultorio_idx` (`salidaConsultorioFK` ASC) VISIBLE,
  INDEX `FKsalidaProcedimiento_idx` (`salidaProcedimientoFK` ASC) VISIBLE,
  CONSTRAINT `FKsalidaConsultorio`
    FOREIGN KEY (`salidaConsultorioFK`)
    REFERENCES `insumos`.`consultorio` (`idConsultorio`),
  CONSTRAINT `FKsalidaProcedimiento`
    FOREIGN KEY (`salidaProcedimientoFK`)
    REFERENCES `insumos`.`procedimiento` (`idProcedimiento`),
  CONSTRAINT `FKsalidaTrabajador`
    FOREIGN KEY (`salidaUsuarioFK`)
    REFERENCES `insumos`.`usuarios` (`usuarioDocumento`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`detallesalida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`detallesalida` (
  `idDetalleSalida` INT NOT NULL AUTO_INCREMENT,
  `DSidSalidaFK` VARCHAR(11) NOT NULL,
  `DScodigoInsumoFK` VARCHAR(11) NOT NULL,
  `DScantidad` INT UNSIGNED NOT NULL,
  `DSinvima` VARCHAR(45) NOT NULL,
  `DSlote` VARCHAR(45) NOT NULL,
  `DSfechaVence` DATE NOT NULL,
  PRIMARY KEY (`idDetalleSalida`),
  INDEX `FK-DSidSalida_idx` (`DSidSalidaFK` ASC) VISIBLE,
  CONSTRAINT `FK-DSidSalida`
    FOREIGN KEY (`DSidSalidaFK`)
    REFERENCES `insumos`.`salida` (`idSalida`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`elemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`elemento` (
  `idElemento` VARCHAR(11) NOT NULL,
  `elementoNombre` VARCHAR(45) NOT NULL,
  `elementoPresentacion` INT NOT NULL,
  `elementoCategoria` INT NOT NULL,
  `elementoCantidad` INT UNSIGNED NOT NULL,
  `elementoRuta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idElemento`),
  UNIQUE INDEX `elementoNombre_UNIQUE` (`elementoNombre` ASC) VISIBLE,
  UNIQUE INDEX `elementoRuta_UNIQUE` (`elementoRuta` ASC) VISIBLE,
  INDEX `FKpresetacion_idx` (`elementoPresentacion` ASC) VISIBLE,
  INDEX `FKcategoria_idx` (`elementoCategoria` ASC) VISIBLE,
  CONSTRAINT `FKcategoria`
    FOREIGN KEY (`elementoCategoria`)
    REFERENCES `insumos`.`categoria` (`idCategoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKpresetacion`
    FOREIGN KEY (`elementoPresentacion`)
    REFERENCES `insumos`.`presentacion` (`idPresentacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `insumos`.`movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insumos`.`movimiento` (
  `idMovimiento` INT NOT NULL,
  `movimientoFecha` DATE NOT NULL,
  `movimientoHora` TIME NULL DEFAULT NULL,
  `movimientoTipo` VARCHAR(45) NULL DEFAULT NULL,
  `movimientoEntidad` VARCHAR(45) NULL DEFAULT NULL,
  `movimientoUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `movimientoDato` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`, `movimientoFecha`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

USE `insumos`;

DELIMITER $$
USE `insumos`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `insumos`.`sumarInsumos`
AFTER INSERT ON `insumos`.`detallefactura`
FOR EACH ROW
BEGIN
IF (new.DFlote="N/A" and new.DFinvima="N/A") then
update elemento set elementoCantidad=elementoCantidad+new.DFcantidadInsumo
where idElemento=new.DFinsumoFK;
else
update insumo set insumoExistencia=insumoExistencia+new.DFcantidadInsumo,
insumoInvima=new.DFinvima,
insumoLote=new.DFlote,
insumoVence=new.DFfechaVence
where codigoInsumo=new.DFinsumoFK;
end if;
END$$

USE `insumos`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `insumos`.`restarInsumos`
AFTER INSERT ON `insumos`.`detallesalida`
FOR EACH ROW
BEGIN
IF (new.DSinvima="N/A" and new.DSlote="N/A") then
update elemento set elementoCantidad=elementoCantidad-new.DScantidad
where idElemento=new.DScodigoInsumoFK;
else
update insumo set insumoExistencia=insumoExistencia-new.DScantidad,
insumoInvima=new.DSinvima,
insumoLote=new.DSlote,
insumoVence=new.DSfechaVence
where codigoInsumo=new.DScodigoInsumoFK;
end if;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `insumos`.`tipodocumento`
-- -----------------------------------------------------
START TRANSACTION;
USE `insumos`;
INSERT INTO `insumos`.`tipodocumento` (`idTipoDoc`, `tipoDocNombre`) VALUES (1, ' Cedula de Ciudadania');
INSERT INTO `insumos`.`tipodocumento` (`idTipoDoc`, `tipoDocNombre`) VALUES (4, 'NIT');
INSERT INTO `insumos`.`tipodocumento` (`idTipoDoc`, `tipoDocNombre`) VALUES (5, 'Pasaporte');
INSERT INTO `insumos`.`tipodocumento` (`idTipoDoc`, `tipoDocNombre`) VALUES (3, 'Tarjeta de Extranjeria');
INSERT INTO `insumos`.`tipodocumento` (`idTipoDoc`, `tipoDocNombre`) VALUES (2, 'Tarjeta de Identidad');

COMMIT;

