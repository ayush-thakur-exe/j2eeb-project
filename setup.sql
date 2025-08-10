create database if not exists bienvenu;
use bienvenu;

DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Ticket_Links;
DROP TABLE IF EXISTS Management;
DROP TABLE IF EXISTS Interested;

-- Create User table
CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    password VARCHAR(255),
    phone VARCHAR(20)
);

-- Create Event table
CREATE TABLE Event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    place VARCHAR(255),
    datetime TIMESTAMP,
    longitude FLOAT,
    latitude FLOAT,
    total_interest BIGINT default 0
);

-- Create Ticket_Links table
CREATE TABLE Ticket_Links (
	id BIGINT auto_increment primary key,
    event_id BIGINT,
    link TEXT,
    platform VARCHAR(100),
    FOREIGN KEY (event_id) REFERENCES Event(id)
);

-- Create Management table (many-to-many between User and Event)
CREATE TABLE Management (
    user_id BIGINT,
    event_id BIGINT,
    role VARCHAR(100),
    PRIMARY KEY (user_id, event_id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (event_id) REFERENCES Event(id)
);

-- Create Interested table (many-to-many between User and Event)
CREATE TABLE Interested (
    user_id BIGINT,
    event_id BIGINT,
    PRIMARY KEY (user_id, event_id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (event_id) REFERENCES Event(id)
);

-- Management -> Event
ALTER TABLE management DROP FOREIGN KEY management_ibfk_2;
ALTER TABLE management
  ADD CONSTRAINT management_ibfk_2
  FOREIGN KEY (event_id) REFERENCES event(id)
  ON DELETE CASCADE;

-- Interested -> Event
ALTER TABLE interested DROP FOREIGN KEY interested_ibfk_2;
ALTER TABLE interested
  ADD CONSTRAINT interested_ibfk_2
  FOREIGN KEY (event_id) REFERENCES event(id)
  ON DELETE CASCADE;

-- Ticket_Links -> Event
ALTER TABLE ticket_links DROP FOREIGN KEY ticket_links_ibfk_1;
ALTER TABLE ticket_links
  ADD CONSTRAINT ticket_links_ibfk_1
  FOREIGN KEY (event_id) REFERENCES event(id)
  ON DELETE CASCADE;

-- Playground
insert into event(title, description, place, datetime, longitude, latitude, total_interest)
values ('Movie night', 'Gather around with popcorn and snacks to enjoy the free movie night hosted by ignite!', 'Toronto, ON', now(), 43.121312, 75.923421, 12);
update event set longitude=-79.87796533116581, latitude=43.249225741393346 where id=3;
update event set total_interest=1 where id=8;

select * from Interested;
select * from Ticket_Links;
select * from Management;
select * from Event;
select * from User;

-- DO NOT RUN
delete from Interested;
delete from Ticket_Links;
delete from Management;
delete from Event;
delete from User;
