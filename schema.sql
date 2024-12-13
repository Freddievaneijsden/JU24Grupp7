use demo;

create table country
(
    country_id int not null auto_increment,
    country_name varchar(255) not null,
    country_language varchar(255) not null,
    primary key (country_id)
);

drop table country;

insert into country (country_name, country_language)
values ('Denmark', 'Danish'),
       ('Finland', 'Finnish'),
       ('Iceland', 'Icelandic'),
       ('Norway', 'Norwegian'),
       ('Sweden', 'Swedish');