DROP DATABASE IF EXISTS superheroSightings;
CREATE DATABASE superheroSightings;

USE superheroSightings;

CREATE TABLE superhero (
	superhero_id int auto_increment,
	name varchar(50) not null,
	description varchar(255),
	superpower varchar(50),
	constraint pk_superhero
		primary key (superhero_id)
);

CREATE TABLE location (
	location_id int auto_increment,
    name varchar(50),
    description varchar(255),
    address varchar(255),
    latitude decimal(10,6),
    longitude decimal(10,6),
    constraint pk_location
		primary key (location_id)
);

CREATE TABLE organisation (
	organisation_id int auto_increment,
    name varchar(50),
    description varchar(255),
    address varchar(255),
    contact varchar(50),
    constraint pk_organisation
		primary key (organisation_id)
);

CREATE TABLE superhero_orgaisation (
	superhero_id int,
    organisation_id int,
    constraint pk_superhero_organisation
		primary key (superhero_id, organisation_id),
	constraint fk_superhero_organisation_superhero
		foreign key (superhero_id)
        references superhero(superhero_id),
	constraint fk_superhero_organisation_organisation
		foreign key (organisation_id)
        references organisation(organisation_id)
);

CREATE TABLE sighting (
	sighting_id int auto_increment,
	superhero_id int,
    location_id int,
    date date,
    constraint pk_sighting
		primary key (sighting_id),
	constraint fk_sighting_superhero
		foreign key (superhero_id)
        references superhero(superhero_id),
	constraint fk_sighting_location
		foreign key (location_id)
        references location(location_id)
);

