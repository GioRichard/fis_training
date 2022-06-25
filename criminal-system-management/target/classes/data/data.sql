 create table criminalcase (
       id bigint not null auto_increment,
        createdAt datetime(6),
        modifiedAt datetime(6),
        version integer not null,
        detailedDescription varchar(255),
        notes varchar(255),
        number varchar(255),
        shortDescription varchar(255),
        status integer,
        type integer,
        criminalCase bigint,
        primary key (id)
    )

    create table detective (
       id bigint not null auto_increment,
        createdAt datetime(6),
        modifiedAt datetime(6),
        version integer not null,
        armed bit,
        badgeNumber varchar(255),
        firstName varchar(255),
        hiringDate datetime(6),
        lastName varchar(255),
        password varchar(255),
        `rank` integer,
        status integer,
        username varchar(255),
        leadInvestigator bigint,
        primary key (id)
    )

    create table evidence (
       id bigint not null auto_increment,
        createdAt datetime(6),
        modifiedAt datetime(6),
        version integer not null,
        archived bit,
        itemName varchar(255),
        notes varchar(255),
        number varchar(255),
        criminalCaseId bigint,
        storageId bigint,
        primary key (id)
    )

    create table storage (
       id bigint not null auto_increment,
        createdAt datetime(6),
        modifiedAt datetime(6),
        version integer not null,
        location varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table trackentry (
       id bigint not null auto_increment,
        createdAt datetime(6),
        modifiedAt datetime(6),
        version integer not null,
        action integer,
        trackDate datetime(6),
        reason varchar(255),
        detectiveId bigint,
        evidenceId bigint,
        primary key (id)
    )

    create table working_detective_case (
       detectiveId bigint not null,
        criminalCaseId bigint not null,
        primary key (detectiveId, criminalCaseId)
    )