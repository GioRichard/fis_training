CREATE TABLE `account` (
  `Account_Number` bigint(20) PRIMARY KEY NOT NULL,
  `Account_Type` varchar(45) DEFAULT NULL,
  `Person_name` varchar(50) DEFAULT NULL)

  CREATE TABLE `evidence_system`.`storage` (
    `id` INT NOT NULL,
    `version` INT NULL,
    `createdAt` DATETIME NULL,
    `modifiedAt` DATETIME NULL,
    `name` VARCHAR(45) NULL,
    `location` VARCHAR(45) NULL,
    PRIMARY KEY (`id`));

    