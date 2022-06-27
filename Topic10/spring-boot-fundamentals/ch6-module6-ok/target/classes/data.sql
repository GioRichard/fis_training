drop table if exists application CASCADE;
drop table if exists release CASCADE;
drop table if exists ticket CASCADE;
drop table if exists ticket_release CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table application (
   application_id bigint not null,
    description varchar(2000),
    app_name varchar(255) not null,
    owner varchar(255),
    primary key (application_id)
);
create table release (
   id integer not null,
    description varchar(255),
    release_date varchar(255),
    primary key (id)
);
create table ticket (
   id integer not null,
    description varchar(255),
    status varchar(255),
    title varchar(255),
    application_id bigint,
    primary key (id)
);
create table ticket_release (
   release_fk integer,
    ticket_fk integer not null,
    primary key (ticket_fk)
);
alter table ticket
   add constraint FKgv5fplg8dc0lh89twb0w792ei
   foreign key (application_id)
   references application;
alter table ticket_release
   add constraint FKro1kgo8c2e3tymf0chqwq846n
   foreign key (release_fk)
   references release;
alter table ticket_release
   add constraint FK4frx8ynymwvvix64ps2o4ocds
   foreign key (ticket_fk)
   references ticket;

INSERT INTO application (application_id, app_name, description, owner) VALUES (1, 'Trackzilla','A bug tracking application', 'Kesha Williams');
INSERT INTO application (application_id, app_name, description, owner) VALUES (2, 'Expenses','An application used to submit expenses', 'Jane Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (3, 'Bookings','An application used to book tickets', 'John Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (4, 'Invoice Search','An application used to search invoices ', 'Mary Richards');
INSERT INTO application (application_id, app_name, description, owner) VALUES (5, 'Audits','An application used for auditing purposes.', 'Tiffany Stewart');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (1, 'Sort Feature','Add the ability to sort tickets by severity',1,'OPEN');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (2, 'Search Feature','Add the ability to search by invoice date',4,'IN PROGRESS');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (3, 'Audit','Add the ability to audit by year',5,'CLOSED');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (4, 'Booking Feature','Add the ability to book tickets online',3,'OPEN');
INSERT INTO release (id, description, release_date) VALUES (1,'Q1 Release Containing High Priority Bugs', '2030-02-14');
INSERT INTO release (id, description, release_date) VALUES (2,'Q2 Release Containing High Priority Enhancements', '2030-05-27');
INSERT INTO release (id, description, release_date) VALUES (3,'Q3 Release Containing Bugs', '2030-09-14');
INSERT INTO release (id, description, release_date) VALUES (4,'Q4 Release Containing Enhancements', '2030-12-10');
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (1,3);
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (2,1);
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (2,4);
