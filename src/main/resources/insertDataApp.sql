INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('1', 'Danila Kisa', 'Novi Sad', '0', 'Ovo je lepa klinika', 'KCV', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('2', 'Viktora Igoa', 'Beograd', '0', 'Ovo je klinika u Beogradu', 'Bel Medic', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('3', 'Gospodar Jovanova', 'Beograd', '0', 'Klinika za sve i svasta', 'Natal', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('4', 'Dragise Cvetkovica', 'Nis', '0', 'U nis', 'Poliklinika Panajtovic', '0');

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CA', '1', 'Danila Kisa', '0', 'Novi Sad', 'Srbija', 'ca@gmail.com', b'1', 'Ivan', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '123456789', '1234567894561', '0', '19', '13', '1');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CA', '2', 'Zivojina Misica', '0', 'Beograd', 'Srbija', 'ca2@gmail.com', b'1', 'Jovan', 'Jovanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '789456123', '7412589632145', '0', '14', '8', '2');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CA', '3', 'Vuka Karadzica', '0', 'Beograd', 'Srbija', 'ca3@gmail.com', b'1', 'Mitar', 'Mitrovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '121212121', '1452369874521', '0', '18', '12', '3');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CA', '4', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'ca4@gmail.com', b'1', 'Nikola', 'Novakovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', '4');


INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '5', 'Marsala Tita', '0', 'Novi Sad', 'Srbija', 'do@gmail.com', b'1', 'Milos', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '123456789', '4545454545454', '0', '19', '13', '1');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '6', 'Zivojina Misica', '0', 'Beograd', 'Srbija', 'do2@gmail.com', b'1', 'Marko', 'Markovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '789456123', '8989898989898', '0', '14', '8', '2');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '7', 'Vuka Karadzica', '0', 'Beograd', 'Srbija', 'do3@gmail.com', b'1', 'Petar', 'Petrovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '121212121', '7575757575757', '0', '18', '12', '3');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '8', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do4@gmail.com', b'1', 'Nikola', 'Zivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', '4');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '9', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do5@gmail.com', b'1', 'Igor', 'Ivic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '19', '13', '4');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '10', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do6@gmail.com', b'1', 'Dragan', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', '4');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('DO', '11', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do7@gmail.com', b'1', 'Aleksandar', 'Ivic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '16', '10', '2');


INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('NU', '12', 'Marka Nikolica', '0', 'Novi Sad', 'Srbija', 'nu@gmail.com', b'1', 'Jovana', 'Markovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4141414141414', '0', '16', '8', '4');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('NU', '13', 'Jovana Nikolica', '0', 'Nis', 'Srbija', 'nu2@gmail.com', b'1', 'Jelena', 'Jovanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6363636363636', '0', '19', '13', '4');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('NU', '14', 'Petra Nikolica', '0', 'Beograd', 'Srbija', 'nu3@gmail.com', b'1', 'Ivana', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '5252525252525', '0', '16', '8', '1');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('NU', '15', 'Milosa Nikolica', '0', 'Kragujevac', 'Srbija', 'nu4@gmail.com', b'1', 'Aleksandara', 'Peric', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1010101010101', '0', '16', '10', '2');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('NU', '16', 'Milosa Nikolica', '0', 'Kraljevo', 'Srbija', 'nu5@gmail.com', b'1', 'Milica', 'Mirkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '7575757575757', '0', '15', '7', '3');

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('PA', '17', 'Jovana Mirkovica', '0', 'Nis', 'Srbija', 'pa@gmail.com', b'1', 'Rade', 'Radovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', null);
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('PA', '18', 'Petra Petrovica', '0', 'Nis', 'Srbija', 'pa2@gmail.com', b'1', 'Ivana', 'Stojkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '19', '13', null);
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('PA', '19', 'Lole Lolovica', '0', 'Nis', 'Srbija', 'pa3@gmail.com', b'1', 'Milica', 'Garic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null);

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CCA', '20', 'Mite Lolovica', '0', 'Kragujevac', 'Srbija', 'cca@gmail.com', b'1', 'Jovica', 'Jovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null);
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`) VALUES ('CCA', '21', 'Lole Markovica', '0', 'Zemun', 'Srbija', 'scca@gmail.com', b'1', 'Zdravko', 'Ivkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null);

INSERT INTO `db`.`medical_record` (`id`, `blood_type`, `diopter`, `height`, `weight`) VALUES ('1', 'AB', '1', '145', '23');
INSERT INTO `db`.`medical_record` (`id`, `blood_type`, `diopter`, `height`, `weight`) VALUES ('2', 'A', '4', '180', '90');
INSERT INTO `db`.`medical_record` (`id`, `blood_type`, `diopter`, `height`, `weight`) VALUES ('3', 'B', '2', '190', '80');
INSERT INTO `db`.`medical_record` (`id`) VALUES ('4');

UPDATE `db`.`users` SET `medical_record_id` = '1' WHERE (`id` = '17');
UPDATE `db`.`users` SET `medical_record_id` = '2' WHERE (`id` = '18');
UPDATE `db`.`users` SET `medical_record_id` = '3' WHERE (`id` = '19');

INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('1', 'ROLE_PATIENT');
INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('2', 'ROLE_CLINIC_ADMIN');
INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('3', 'ROLE_CLINIC_CENTER_ADMIN');
INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('4', 'ROLE_NURSE');
INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('5', 'ROLE_DOCTOR');
INSERT INTO `db`.`authority` (`id`, `name`) VALUES ('6', 'ROLE_CLINIC_CENTER_ADMIN_SUPER');


INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('1', '2');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('2', '2');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('3', '2');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('4', '2');

INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('5', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('6', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('7', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('8', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('9', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('10', '5');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('11', '5');

INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('12', '4');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('13', '4');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('14', '4');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('15', '4');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('16', '4');

INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('18', '1');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('19', '1');

INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('20', '3');
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('21', '6');

INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('1', '123', 'Ovo je lepa dijagnoza', '1', 'Alchajmer');
INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('2', '234', 'Ovo je druga dijagnoza', '2', 'Tuberkuloza');
INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('3', '75', 'Neje dobro', '3', 'Gripa');
INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('4', '23', 'Ovo je neka dijagnoza', '4', 'Parkinsova Bolest');
INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('5', '78', 'Obicna dijagnoza', '5', 'Epilepsija');
INSERT INTO `db`.`diagnosis` (`id`, `code`, `description`, `group`, `name`) VALUES ('6', '77', 'Ovo je druga obicna dijagnoza', '7', 'Migrena');

INSERT INTO `db`.`registration_request` (`id`, `address`, `city`, `country`, `date`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`) VALUES ('1', 'Lasla Gala', 'Novi Sad', 'Srbija', '2020-02-29 19:00:00.000000', 'mitar@gmail.com', 'Mitar', 'Sumar', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '101010101', '3030303030303');
INSERT INTO `db`.`registration_request` (`id`, `address`, `city`, `country`, `date`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`) VALUES ('2', 'Mise Dimitrijevica', 'Novi Sad', 'Srbija', '2020-02-27 19:00:00.000000', 'jelica@gmail.com', 'Jelica', 'Jelic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '789456123', '7478747874787');


INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('1', 'Sala za hirurhiju', '101', '1');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('2', 'Sala za hitne operacije', '102', '2');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('3', 'Sala za kardio hirurgiju', '103', '1');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('4', 'Sala za plasticnu hirurgiju', '104', '1');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('5', 'Sala1', '202', '2');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('6', 'Sala2', '203', '2');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('7', 'Sala3', '204', '2');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('8', 'Sala4', '205', '3');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('9', 'Sala5', '208', '3');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('10', 'Sala9', '209', '3');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('11', 'Sala10', '210', '4');
INSERT INTO `db`.`operation_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('12', 'Sala88', '221', '4');

INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('1', '2019-12-03 19:00:00.000000', '30', '1', '5', '18');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('2', '2020-03-05 19:00:00.000000', '30', '2', '6', '19');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('3', '2020-03-05 19:00:00.000000', '30', '4', '10', '18');

INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('1', '123', 'Ljek za sve', 'Kafetin', b'1', 'Za bolove');
INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('2', '188', 'Ljek za gripu', 'Fervex', b'0', 'Za gripu');
INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('3', '18', 'Ljek za alchajmera', 'Lek', b'1', 'Za alchajmera');
INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('4', '13', 'Ljek za tuberkulozu', 'Kafetin', b'1', 'Za bolove');
INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('5', '12', 'Ljek za glavu', 'Andol', b'0', 'Za bolove');
INSERT INTO `db`.`medicament` (`id`, `code`, `description`, `name`, `on_prescription`, `purpose`) VALUES ('6', '145', 'Ljek za bol', 'Konjska mast', b'0', 'Za bolove');

INSERT INTO `db`.`medical_examination_type` (`id`, `name`, `price`) VALUES ('1', 'Pregled pluca', '1000');
INSERT INTO `db`.`medical_examination_type` (`id`, `name`, `price`) VALUES ('2', 'Pregled glave', '5000');
INSERT INTO `db`.`medical_examination_type` (`id`, `name`, `price`) VALUES ('3', 'Pregled srca', '3000');

INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('5', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('5', '2');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('6', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('6', '3');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('6', '2');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('7', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('7', '2');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('8', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('9', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('10', '1');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('10', '2');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('10', '3');
INSERT INTO `db`.`doctor_examination_types` (`doctor_id`, `type_id`) VALUES ('11', '2');


INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('1', 'Soba', '101', '1');
INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('2', 'Sobicak', '102', '1');
INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('3', 'Soba za pregled', '103', '2');
INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('4', 'Soba za pregledic', '405', '2');
INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('5', 'Sobica za pregeldic', '404', '3');
INSERT INTO `db`.`medical_examination_room` (`id`, `name`, `number`, `clinic_id`) VALUES ('6', 'Sobica', '55', '4');




