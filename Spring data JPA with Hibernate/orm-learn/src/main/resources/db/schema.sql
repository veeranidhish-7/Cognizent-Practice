-- Run this manually against the 'ormlearn' MySQL schema before starting the
-- application (spring.jpa.hibernate.ddl-auto=validate expects the table to
-- already exist).

create schema if not exists ormlearn;

use ormlearn;

create table if not exists country (
    co_code varchar(2) primary key,
    co_name varchar(50)
);
