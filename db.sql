CREATE TABLE `cic`.`cic` (
  `cicid` INT NOT NULL AUTO_INCREMENT,
  `cicType` VARCHAR(45) NULL,
  `subject` VARCHAR(45) NULL,
  `body` TEXT NULL,
  `sourceSystem` VARCHAR(45) NULL,
  `cicTimestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cicid`));

CREATE TABLE `cic`.`entity` (
  `entityId` INT NOT NULL AUTO_INCREMENT,
  `entityName` VARCHAR(255) NOT NULL,
  `emailAddress` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`entityId`));

CREATE TABLE `cic`.`cic_entity` (
  `entityid` INT NOT NULL,
  `cicid` INT NOT NULL,
  PRIMARY KEY (`entityid`, `cicid`));

ALTER TABLE `cic`.`cic_entity` 
ADD INDEX `fk_cic_entity_cid_idx` (`cicid` ASC);
ALTER TABLE `cic`.`cic_entity` 
ADD CONSTRAINT `fk_cic_entity_eid`
  FOREIGN KEY (`entityid`)
  REFERENCES `cic`.`entity` (`entityId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_cic_entity_cid`
  FOREIGN KEY (`cicid`)
  REFERENCES `cic`.`cic` (`cicid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
