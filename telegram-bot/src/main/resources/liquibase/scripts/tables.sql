-- liquibase formatted sql

-- changeset d1m_k0:1

create table pets (
    id serial primary key ,
    name varchar,
    age integer check ( age > 0 ),
    petType varchar not null ,
    breed varchar,
    isHealthy boolean
);

create table users (
    chatId serial primary key,
    name varchar,
    petId bigint references pets(id),
    phoneNumber varchar,
    mail varchar
);

create table volunteers (
    id serial primary key,
    chatId bigint,
    name varchar
)
