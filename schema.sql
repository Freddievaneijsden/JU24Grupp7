use demo;

-- CREATE TABLE
create table country
(
    country_id int not null auto_increment,
    country_name varchar(255) not null,
    country_language varchar(255) not null,
    primary key (country_id),
    unique (country_name)
);

create table celebrity
(
    celebrity_id int not null auto_increment,
    celebrity_name varchar(255) not null,
    celebrity_country_id int not null,
    primary key (celebrity_id),
    foreign key (celebrity_country_id) references country (country_id),
    unique (celebrity_name)
);

create table dish
(
    dish_id int not null auto_increment,
    dish_name varchar(255) not null,
    dish_country_id int not null,
    primary key (dish_id),
    foreign key (dish_country_id) references country (country_id),
    unique (dish_name)
);

create table animal
(
    animal_id int not null auto_increment,
    animal_name varchar(255) not null,
    animal_quiz varchar(225),
    animal_country_id int,
    primary key (animal_id),
    foreign key (animal_country_id) references country (country_id),
    unique (animal_name)

);

create table leaderboard (
    leaderboard_id int not null auto_increment,
    leaderboard_player varchar(255) not null,
    leaderboard_score int not null,
    leaderboard_quizType_id int not null,
    primary key (leaderboard_id),
    foreign key (leaderboard_quizType_id) references quizType (quizType_id)
);

create table quizType
(
    quizType_id int not null auto_increment,
    quizType_name varchar(255) not null,
    primary key (quizType_id),
    unique (quizType_name)
);

-- INSERT INTO
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
       ('Vietnam', 'Vietnamese'),
       ('Israel', 'Hebrew'),
       ('El Salvador', 'Salvadorian'),
       ('Brazil', 'Portuguese' ),
       ('Egypt', 'Arabic'),
       ('Korea', 'Korean'),
       ('France', 'French');


insert into celebrity (celebrity_name, celebrity_country_id)
values ('Henrik Ibsen', 4),
       ('Viggo Mortensen', 1),
       ('Peter Stormare', 5),
       ('Cameron Diaz', 6),
       ('Heidi Klum', 7),
       ('Javier Bardem',8 ),
       ('Pedro Pascal', 10),
       ('Hô Chi Minh', 11),
       ('Ronaldo', 14),
       ('Tutankhamun', 15),
       ('Park Seo-joon', 16),
       ('Napoleon Bonaparte', 17 ),
       ('Donald Trump', 6);


insert into dish (dish_name, dish_country_id)
values ('Smørrebrød', 1),
       ('Karjalanpiirakka', 2),
       ('Hákarl', 3),
       ('Rakfisk', 4),
       ('Meatballs', 5),
       ('Hamburger', 6),
       ('Sauerbraten', 7),
       ('Paella', 8),
       ('Asado', 9),
       ('Empanadas', 10),
       ('Phở', 11),
       ('Falafel', 12),
       ('Pupusas', 13),
       ('Feijoada', 14),
       ('Koshari', 15),
       ('Kimchi', 16),
       ('Ratatouille', 17),
       ('Black pudding', 5),
       ('Pickled Herring', 5);

insert into animal(animal_name, animal_country_id, animal_quiz)
values ('Mute swan','1',null),
       ('Brown bear','2',null),
       ('Gyrfalcon','3',null),
       ('Eurasian elk','5',null),
       ('Moose','4',null),
       ('Bald eagle','6',null),
       ('American bison','6',null),
       ('Tiger',null,'What is the largest cat animal in the world?'),
       ('Whale',null,'What is the largest mammal in the world?');

insert into quizType (quizType_name)
values ('Country'),
       ('Animal'),
       ('Celebrity'),
       ('Dish');

-- UNIQUE TEST
    insert into dish (dish_name, dish_country_id)
    values ('Asado', 9);

    insert into celebrity (celebrity_name, celebrity_country_id)
    values ('Henrik Ibsen', 4);

    insert into country (country_name, country_language)
    values ('Denmark', 'Danish');

-- DROP TABLE
    drop table country;
    drop table celebrity;
    drop table dish;
    drop table animal;
    drop table leaderboard;
    drop table quizType;

