drop schema if exists project1 cascade;
create schema project1;
set schema 'project1';

create table user_roles (
	user_role_id serial primary key,
	user_role text not null
);

create table users (
	user_id serial primary key,
	username text unique not null,
	"password" text not null,
	first_name text not null,
	last_name text not null,
	email text unique not null,
	user_role_id int not null references user_roles
);

create table reimbursement_status (
	reimb_status_id serial primary key,
	reimb_status text not null default 'pending'
	
);

create table reimbursement_type (
	reimb_type_id serial primary key,
	reimb_type text not null
	
);

create table reimbursements (
	reimb_id serial primary key,
	reimb_amount int not null,
	reimb_submitted timestamp not null,
	reimb_approved timestamp,
	reimb_description text,
	reimb_receipt bytea,
	reimb_author int not null references users,
	reimb_resolver int references users,
	reimb_status_id int not null references reimbursement_status,
	reimb_type_id int not null references reimbursement_type
);

--ALTER SEQUENCE accounts_account_number_seq RESTART WITH 123000;