insert into clinic (id, address, city, clinic_average_rating, description, name, times_rated) values (1, 'Sime Milosevica', 'Novi Sad', 9, 'Ludara', 'Dom Bajic', 2);
insert into db.clinic (id, address, city, clinic_average_rating, description, name, times_rated) values ('2', 'Milosa Simovica', 'Beograd', '8.5', 'Neludara', 'Dom Vlahovic', '4');
insert into db.clinic (id, address, city, clinic_average_rating, description, name, times_rated) values ('3', 'Mile Simica', 'Iscuruga', '6', 'Kkfdaf', 'Dom Culum', '1');
insert into db.clinic (id, address, city, clinic_average_rating, description, name, times_rated) values ('4', 'Sole Misevica', 'Indjija', '7.5', 'Sdfsdf', 'Dom Sajam', '2');

insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('PA', '1', 'Laze Kostica', 'Indjija', 'Srbija', 'igor_malesevic@yahoo.com', b'1', 'Igor', 'Malesevic', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '123123123', '1901998710244', null, null, null);
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('CCA', '2', 'Miroslava Ilica', 'Sabac', 'Srbija', 'cca@yahoo.com', b'1', 'Admin', 'Centra', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '111111111', '1111111111111', null, null, null);
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('DO', '3', 'Ulica', 'Gradic', 'Serbistan', 'doctor@yahoo.com', b'1', 'Doktor', 'Doktoric', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '222222222', '2222222222222', '9', '1', '1');
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('NU', '4', 'Odje zivim', 'Stari grad', 'Srbija', 'nurse@gmail.com', b'1', 'Sestra', 'Sestrica', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '333333333', '3333333333333', null, null, null);
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('CA', '5', 'Pejicevi Salasi', 'Novi Sad', 'Srbija', 'ca@gmail.com', b'1', 'Djordje', 'Cvarkov', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '444444444', '4444444444444', null, null, null);
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('DO', '6', 'Streetic', 'Cityic', 'Serbia', 'doctor@gmail.com', b'1', 'Lekar', 'Lekaric', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '222222222', '2222222222222', '9', '1', '1');
insert into db.users (type, id, address, city, country, email, enabled, first_name, last_name, last_password_reset_date, password, phone, ssn, average_rating, times_rated, clinic_id) values ('DO', '7', 'Zdrid', 'Zidi', 'Zrbija', 'doc@yahoo.com', b'1', 'Zdravko', 'Herbiko', '2019-12-03 19:00:00.000000', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '222222222', '2222222222222', '9', '1', '1');

insert into db.authority (id, name) values (1, 'ROLE_PATIENT');
insert into db.authority (id, name) values (2, 'ROLE_DOCTOR');
insert into db.authority (id, name) values (3, 'ROLE_NURSE');
insert into db.authority (id, name) values (4, 'ROLE_CLINIC_ADMIN');
insert into db.authority (id, name) values (5, 'ROLE_CLINIC_CENTER_ADMIN');

insert into db.user_authority (user_id, authority_id) values ('1', '1');
insert into db.user_authority (user_id, authority_id) values ('2', '5');
insert into db.user_authority (user_id, authority_id) values ('3', '2');
insert into db.user_authority (user_id, authority_id) values ('4', '3');
insert into db.user_authority (user_id, authority_id) values ('5', '4');

insert into db.medical_examination_type (id, name, price) values ('1', 'pregled glave', '1000');
insert into db.medical_examination_type (id, name, price) values ('2', 'pregled pluca', '2000');
insert into db.medical_examination_type (id, name, price) values ('3', 'pregled srca', '3000');

insert into db.doctor_examination_types (doctor_id, type_id) values('3','1');
insert into db.doctor_examination_types (doctor_id, type_id) values('3','2');
insert into db.doctor_examination_types (doctor_id, type_id) values('3','3');
insert into db.doctor_examination_types (doctor_id, type_id) values('6','1');
insert into db.doctor_examination_types (doctor_id, type_id) values('6','2');
insert into db.doctor_examination_types (doctor_id, type_id) values('7','2');
insert into db.doctor_examination_types (doctor_id, type_id) values('7','3');

INSERT INTO db.registration_request (id, address, city, `country`, date, email, first_name, last_name, password, phone, ssn) VALUES ('1', 'Zbrda', 'Vlasenca', 'Republika Srpska', '2019-12-03 19:00:00.000000', 'req@gmail.com', 'Mitar', 'Mitrovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '456456456', '4564564565464');

INSERT INTO db.medicament (id, description, name, on_prescription, purpose) VALUES ('1', 'Za glavu', 'Aspirin', null, 'Da ne boli');


