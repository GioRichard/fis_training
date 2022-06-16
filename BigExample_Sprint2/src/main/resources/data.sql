-- storage
INSERT INTO `system_db`.`storage` (`id`, `version`, `createdAt`, `modifiedAt`, `name`, `location`) VALUES ('1', '1', '2022-06-18 00:04', '2000-07-18 00:04', 'name1', 'location1');
INSERT INTO `system_db`.`storage` (`id`, `version`, `createdAt`, `modifiedAt`, `name`, `location`) VALUES ('2', '2', '2022-06-16 00:04', '2000-07-20 00:04', 'name2', 'location2');

--detective
INSERT INTO `system_db`.`detective` (`id`, `version`, `createdAt`, `modifiedAt`, `username`, `firstName`, `lastName`, `pw`, `hiringDate`, `badgeNumber`, `rankOfDetective`, `armed`, `status`) VALUES ('1', '1', '2022-06-18 00:04', '2000-07-18 00:04', 'phong', 'ha', 'quoc', '123', '2000-07-18 00:04', '1', 'tranee', 1, 'cold');
INSERT INTO `system_db`.`detective` (`id`, `version`, `createdAt`, `modifiedAt`, `username`, `firstName`, `lastName`, `pw`, `hiringDate`, `badgeNumber`, `rankOfDetective`, `armed`, `status`) VALUES ('2', '2', '2000-07-18 00:04', '2000-07-18 00:04', 'nguyen', 'tran', 'tinh', '345', '2000-07-18 00:04', '2', 'junior', 1, 'cold');

--criminalcase
INSERT INTO `system_db`.`criminalcase` (`id`, `version`, `createdAt`, `modifiedAt`, `number`, `type`, `shortDescription`, `detailedDescription`, `status`, `note`, `leadInvestigatorId`) VALUES ('1', '1', '2022-06-18 00:042022-06-18 00:04', '2022-06-18 00:04', '1', 'FELONLY', 'short1', 'detail1', 'active', 'note1', '1');
INSERT INTO `system_db`.`criminalcase` (`id`, `version`, `createdAt`, `modifiedAt`, `number`, `type`, `shortDescription`, `detailedDescription`, `status`, `note`, `leadInvestigatorId`) VALUES ('2', '2', '2022-06-18 00:042022-06-18 00:04', '2022-06-18 00:042022-06-18 00:04', '2', 'FELONLY', 'short2', 'detail2', 'active', 'note2', '2');

--evidence
INSERT INTO `system_db`.`evidence` (`id`, `version`, `createdAt`, `modifiedAt`, `number`, `itemName`, `note`, `archived`, `criminalCaseId`, `storageId`) VALUES ('1', '1', '2000-07-18 00:04:00', '2000-07-18 00:04:00', '1', 'item1', 'note1', '1', '1', '1');

--trackentry
INSERT INTO `system_db`.`trackentry` (`id`, `version`, `createdAt`, `modifiedAt`, `trackDate`, `action`, `reason`, `detectiveId`, `evidenceId`) VALUES ('1', '1', '2000-07-18 00:04:00', '2000-07-18 00:04:00', '2000-07-18 00:04:00', 'submitted', 'resion1', '1', '1');

--working_detective_case
INSERT INTO `system_db`.`working_detective_case` (`workingId`, `detectiveId`, `criminalCaseId`) VALUES ('1', '1', '1');
