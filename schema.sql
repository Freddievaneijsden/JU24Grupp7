use demo;

create table country
(
    country_id int not null auto_increment,
    country_name varchar(255) not null,
    country_language varchar(255) not null,
    primary key (country_id),
    unique (country_name)
);

drop table country;

insert into country (country_name, country_language)
values ('Denmark', 'Danish'),
       ('Finland', 'Finnish'),
       ('Iceland', 'Icelandic'),
       ('Norway', 'Norwegian'),
       ('Sweden', 'Swedish'),
       ('United States','English'),
       ('Germany', 'German'),
       ('Spain', 'Spanish'),
       ('Argentina', 'Spanish'),
       ('Chile', 'Spanish'),
       ('Vietname', 'Vietnamese'),
       ('Israel', 'Hebrew'),
       ('El Salvador', 'Salvadorian'),
       ('Brazil', 'Portuguese' ),
       ('Egypt', 'Arabic'),
       ('Korea', 'Korean');


insert into country (country_name, country_language)
values ('Denmark', 'Danish');


