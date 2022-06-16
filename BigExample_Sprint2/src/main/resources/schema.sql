

USE system_db;

create TABLE `criminalcase` (
  `id` int NOT NULL,
  `version` int ,
  `createdAt` TIMESTAMP ,
  `modifiedAt` TIMESTAMP ,
  `number` varchar(100) UNIQUE ,
  `type` varchar(100) ,
  `shortDescription` varchar(500),
  `detailedDescription` varchar(100),
  `status` varchar(100),
  `note` varchar(500),
  `leadInvestigatorId` int,
  PRIMARY KEY (`id`),
  KEY `lead_investigator` (`leadInvestigatorId`),
  CONSTRAINT `lead_investigator` FOREIGN KEY (`leadInvestigatorId`) REFERENCES `detective` (`id`));

  create TABLE `detective` (
  `id` int,
  `version` int,
  `createdAt` TIMESTAMP,
  `modifiedAt` TIMESTAMP,
  `username` varchar(100),
  `firstName` varchar(100),
  `lastName` varchar(100),
  `pw` varchar(100),
  `hiringDate` TIMESTAMP,
  `badgeNumber` varchar(50) ,
  `rankOfDetective` varchar(50),
  `armed`boolean,
  `status` varchar(50),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `badgeNumber` (`badgeNumber`));

  create TABLE `evidence` (
  `id` int NOT NULL,
  `version` int ,
  `createdAt` TIMESTAMP,
  `modifiedAt` TIMESTAMP,
  `number` varchar(100) ,
  `itemName` varchar(100) ,
  `note` varchar(500),
  `archived` boolean,
  `criminalCaseId` int,
  `storageId` int,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  KEY `cc_fk` (`criminalCaseId`),
  KEY `s_fk` (`storageId`),
  CONSTRAINT `cc_fk` FOREIGN KEY (`criminalCaseId`) REFERENCES `criminalcase` (`id`),
  CONSTRAINT `s_fk` FOREIGN KEY (`storageId`) REFERENCES `storage` (`id`)
);

create TABLE `storage` (
  `id` int NOT NULL,
  `version` int ,
  `createdAt` TIMESTAMP,
  `modifiedAt` TIMESTAMP,
  `name` varchar(100) ,
  `location` varchar(500) ,
  PRIMARY KEY (`id`)
);

create TABLE `trackentry` (
  `id` int NOT NULL,
  `version` int ,
  `createdAt` TIMESTAMP,
  `modifiedAt`TIMESTAMP,
  `trackDate` TIMESTAMP,
  `action` varchar(50),
  `reason` varchar(100) ,
  `detectiveId` int ,
  `evidenceId` int ,
  PRIMARY KEY (`id`),
  KEY `d_fk` (`detectiveId`),
  KEY `e_fk` (`evidenceId`),
  CONSTRAINT `d_fk` FOREIGN KEY (`detectiveId`) REFERENCES `detective` (`id`),
  CONSTRAINT `e_fk` FOREIGN KEY (`evidenceId`) REFERENCES `evidence` (`id`)
);

create TABLE `working_detective_case` (
  `workingId` int NOT NULL,
  `detectiveId` int ,
  `criminalCaseId` int,
  PRIMARY KEY (`workingId`),
  KEY `detective_fk` (`detectiveId`),
  KEY `case_fk` (`criminalCaseId`),
  CONSTRAINT `case_fk` FOREIGN KEY (`criminalCaseId`) REFERENCES `criminalcase` (`id`),
  CONSTRAINT `detective_fk` FOREIGN KEY (`detectiveId`) REFERENCES `detective` (`id`)
);


