create database tracker;

create table rule
(
    id   serial primary key,
    name text
);

create table role
(
    id   serial primary key,
    name text
);

create table role_rule
(
    id      serial primary key,
    role_id integer references role (id),
    rule_id integer references role (id)
);

create table state
(
    id   serial primary key,
    name text
);

create table category
(
    id   serial primary key,
    name text
);

create table uuser
(
    id      serial primary key,
    name    text,
    role_id integer references role (id)
);

create table item
(
    id          serial primary key,
    name        text,
    state_id    integer references state (id),
    uuser_id    integer references uuser (id),
    category_id integer references category (id)
);

create table attach
(
    id      serial primary key,
    name    text,
    item_id integer references state (id)
);

create table comment
(
    id      serial primary key,
    name    text,
    item_id integer references state (id)
);

insert into rule(name)
values ('full');
insert into rule(name)
values ('not-full');

insert into role(name)
values ('admin');
insert into role(name)
values ('everyone');

insert into role_rule(role_id, rule_id)
values (1, 1);
insert into role_rule(role_id, rule_id)
values (2, 2);

insert into uuser(name, role_id)
values ('person', 1);
insert into uuser(name, role_id)
values ('god', 2);

insert into state(name)
values ('todo');
insert into state(name)
values ('in-progress');
insert into state(name)
values ('done');

insert into category(name)
values ('major');
insert into category(name)
values ('minor');

insert into item (name, state_id, uuser_id, category_id)
values ('first-task', 1, 1, 2);