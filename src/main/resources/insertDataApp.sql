INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('1', 'Danila Kisa', 'Novi Sad', '0', 'Ovo je lepa klinika', 'KCV', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('2', 'Viktora Igoa', 'Beograd', '0', 'Ovo je klinika u Beogradu', 'Bel Medic', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('3', 'Gospodar Jovanova', 'Beograd', '0', 'Klinika za sve i svasta', 'Natal', '0');
INSERT INTO `db`.`clinic` (`id`, `address`, `city`, `clinic_average_rating`, `description`, `name`, `times_rated`) VALUES ('4', 'Dragise Cvetkovica', 'Nis', '0', 'U nis', 'Poliklinika Panajtovic', '0');

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CA', '1', 'Danila Kisa', '0', 'Novi Sad', 'Srbija', 'ca@gmail.com', b'1', 'Ivan', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '123456789', '1234567894561', '0', '19', '13', '1', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CA', '2', 'Zivojina Misica', '0', 'Beograd', 'Srbija', 'ca2@gmail.com', b'1', 'Jovan', 'Jovanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '789456123', '7412589632145', '0', '14', '8', '2', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CA', '3', 'Vuka Karadzica', '0', 'Beograd', 'Srbija', 'ca3@gmail.com', b'1', 'Mitar', 'Mitrovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '121212121', '1452369874521', '0', '18', '12', '3', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CA', '4', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'ca4@gmail.com', b'1', 'Nikola', 'Novakovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', '4', '0');


INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '5', 'Marsala Tita', '0', 'Novi Sad', 'Srbija', 'do@gmail.com', b'1', 'Milos', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '123456789', '4545454545454', '0', '19', '13', '1', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '6', 'Zivojina Misica', '0', 'Beograd', 'Srbija', 'do2@gmail.com', b'1', 'Marko', 'Markovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '789456123', '8989898989898', '0', '14', '8', '2', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '7', 'Vuka Karadzica', '0', 'Beograd', 'Srbija', 'do3@gmail.com', b'1', 'Petar', 'Petrovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '121212121', '7575757575757', '0', '18', '12', '3', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '8', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do4@gmail.com', b'1', 'Nikola', 'Zivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', '4', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '9', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do5@gmail.com', b'1', 'Igor', 'Ivic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '19', '13', '4', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '10', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do6@gmail.com', b'1', 'Dragan', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', '4', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('DO', '11', 'Nikole Nikolica', '0', 'Nis', 'Srbija', 'do7@gmail.com', b'1', 'Aleksandar', 'Ivic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '16', '10', '2', '0');


INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('NU', '12', 'Marka Nikolica', '0', 'Novi Sad', 'Srbija', 'nu@gmail.com', b'1', 'Jovana', 'Markovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4141414141414', '0', '16', '8', '4', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('NU', '13', 'Jovana Nikolica', '0', 'Nis', 'Srbija', 'nu2@gmail.com', b'1', 'Jelena', 'Jovanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6363636363636', '0', '19', '13', '4', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('NU', '14', 'Petra Nikolica', '0', 'Beograd', 'Srbija', 'nu3@gmail.com', b'1', 'Ivana', 'Ivanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '5252525252525', '0', '16', '8', '1', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('NU', '15', 'Milosa Nikolica', '0', 'Kragujevac', 'Srbija', 'nu4@gmail.com', b'1', 'Aleksandara', 'Peric', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1010101010101', '0', '16', '10', '2', '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('NU', '16', 'Milosa Nikolica', '0', 'Kraljevo', 'Srbija', 'nu5@gmail.com', b'1', 'Milica', 'Mirkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '7575757575757', '0', '15', '7', '3', '0');

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('PA', '17', 'Jovana Mirkovica', '0', 'Nis', 'Srbija', 'pa@gmail.com', b'1', 'Rade', 'Radovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '1234569874136', '0', '18', '11', null, '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('PA', '18', 'Petra Petrovica', '0', 'Nis', 'Srbija', 'pa2@gmail.com', b'1', 'Ivana', 'Stojkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '6565656565656', '0', '19', '13', null, '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('PA', '19', 'Lole Lolovica', '0', 'Nis', 'Srbija', 'pa3@gmail.com', b'1', 'Milica', 'Garic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null, '0');

INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CCA', '20', 'Mite Lolovica', '0', 'Kragujevac', 'Srbija', 'cca@gmail.com', b'1', 'Jovica', 'Jovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null, '0');
INSERT INTO `db`.`users` (`type`, `id`, `address`, `average_rating`, `city`, `country`, `email`, `enabled`, `first_name`, `last_name`, `password`, `password_changed`, `phone`, `ssn`, `times_rated`, `end_work`, `start_work`, `clinic_id`, `version`) VALUES ('CCA', '21', 'Lole Markovica', '0', 'Zemun', 'Srbija', 'scca@gmail.com', b'1', 'Zdravko', 'Ivkovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', b'0', '145874521', '4646464646464', '0', '16', '8', null, '0');

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
INSERT INTO `db`.`user_authority` (`user_id`, `authority_id`) VALUES ('17', '1');
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
INSERT INTO `db`.`registration_request` (`id`, `address`, `city`, `country`, `date`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`) VALUES ('3', 'Alekse Santica', 'Novi Sad', 'Srbija', '2020-02-29 19:00:00.000000', 'jovan@gmail.com', 'Jovan', 'Jovanovic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '123456789', '1452145214521');
INSERT INTO `db`.`registration_request` (`id`, `address`, `city`, `country`, `date`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`) VALUES ('4', 'Zivojina Misica', 'Beograd', 'Srbija', '2020-03-03 19:00:00.000000', 'lazar@gmail.com', 'Lazar', 'Lazic', '$2a$10$DPpa3Slt3jcwkynr.9WSaO70xTGYYK8iDlX5H89fry1vHxlLUPE0C', '898989898', '7575484875487');


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

INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('1', '2019-12-03 16:00:00.000000', '30', '1', '5', '18');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('2', '2020-03-05 10:00:00.000000', '30', '2', '6', '19');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('3', '2020-03-05 09:30:00.000000', '30', '4', '10', '18');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('4', '2020-03-25 14:30:00.000000', '30', '1', '5', '18');
INSERT INTO `db`.`operation_request` (`id`, `date`, `duration`, `clinic_id`, `doctor_id`, `patient_id`) VALUES ('5', '2020-03-21 11:00:00.000000', '30', '4', '8', '19');

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

INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('1', '2020-02-29 11:30:00.000000', '0', '30', '1000', '4', '9', '17', '1');
INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('2', '2020-03-01 11:30:00.000000', '0', '30', '1000', '2', '6', '17', '3');
INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('3', '2020-03-22 15:00:00.000000', '0', '30', '1000', '3', '7', '18', '2');
INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('4', '2020-03-21 11:00:00.000000', '0', '30', '1000', '2', '6', '18', '1');
INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('5', '2020-03-10 13:30:00.000000', '0', '30', '1000', '4', '10', '18', '2');
INSERT INTO `db`.`medical_examination_request` (`id`, `date`, `discount`, `duration`, `price`, `clinic_id`, `doctor_id`, `patient_id`, `met_id`) VALUES ('6', '2020-03-02 18:00:00.000000', '0', '30', '1000', '1', '5', '19', '1');


INSERT INTO `db`.`medical_examination` (`id`, `clinic_rated`, `confirmed`, `date`, `discount`, `doctor_rated`, `duration`, `finished`, `predefined`, `price`, `clinic_id`, `doctor_id`, `mer_id`, `met_id`) VALUES ('1', b'0', b'0', '2020-02-22 17:00:00.000000', '1', b'0', '30', b'0', b'1', '1000', '1', '5', '1','1');
INSERT INTO `db`.`medical_examination` (`id`, `clinic_rated`, `confirmed`, `date`, `discount`, `doctor_rated`, `duration`, `finished`, `predefined`, `price`, `clinic_id`, `doctor_id`, `mer_id`, `patient_id`, `met_id`) VALUES ('2', b'0', b'1', '2020-02-23 17:00:00.000000', '1', b'0', '30', b'0', b'1', '1000', '1', '5', '1','18','1');
INSERT INTO `db`.`medical_examination` (`id`, `clinic_rated`, `confirmed`, `date`, `discount`, `doctor_rated`, `duration`, `finished`, `predefined`, `price`, `clinic_id`, `doctor_id`, `mer_id`, `patient_id`, `met_id`) VALUES ('4', b'0', b'1', '2020-02-16 18:00:00.000000', '0', b'0', '30', b'0', b'0', '1500', '1', '5', '2', '19','1');
INSERT INTO `db`.`medical_examination` (`id`, `clinic_rated`, `confirmed`, `date`, `discount`, `doctor_rated`, `duration`, `finished`, `predefined`, `price`, `clinic_id`, `doctor_id`, `mer_id`, `patient_id`, `met_id`) VALUES ('3', b'0', b'0', '2020-02-16 18:30:00.000000', '0', b'0', '30', b'0', b'0', '1500', '1', '5', '2', '19','1');


INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('1', b'0', 'absence', '2020-03-22 17:00:00.000000', 'eto tako', '2020-03-25 17:00:00.000000', '5');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('2', b'0', 'absence', '2020-03-20 17:00:00.000000', 'malo bi i ja', '2020-03-28 17:00:00.000000', '6');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('3', b'0', 'absence', '2020-03-28 17:00:00.000000', 'odo odmorit', '2020-03-29 17:00:00.000000', '7');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('4', b'0', 'vacation', '2020-03-15 17:00:00.000000', 'odo ', '2020-03-20 17:00:00.000000', '5');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('5', b'0', 'vaction', '2020-03-13 17:00:00.000000', 'malko bi odmorio', '2020-03-16 17:00:00.000000', '10');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('6', b'0','vacation', '2020-03-15 17:00:00.000000', 'molim vas jel smem', '2020-03-16 17:00:00.000000', '9');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('7', b'0', 'absence', '2020-03-17 17:00:00.000000', 'pls', '2020-03-28 17:00:00.000000', '11');
INSERT INTO `db`.`annual_leave_request` (`id`, `approved`, `flag`, `leave_date`, `reason`, `return_date`, `user_id`) VALUES ('8', b'0', 'absence', '2020-03-22 17:00:00.000000', 'odo na more', '2020-03-23 17:00:00.000000', '8');

INSERT INTO `db`.`medical_report` (`id`, `report`, `therapy`, `diagnosis_id`, `medical_examination_id`, `medicament_id`) VALUES ('1', 'boljestan je', 'Malo po malo', '1', '4', '1');
INSERT INTO `db`.`medical_report` (`id`, `report`, `therapy`, `diagnosis_id`, `medical_examination_id`, `medicament_id`) VALUES ('2', 'ovaj takodje bolesjiv', 'laganeze', '2', '3', '3');
INSERT INTO `db`.`medical_report` (`id`, `report`, `medical_examination_id`) VALUES ('3', 'ovaj je zdrav', '1');
INSERT INTO `db`.`medical_report` (`id`, `report`, `therapy`, `diagnosis_id`, `medical_examination_id`, `medicament_id`) VALUES ('4', 'boljestan u glavu', 'jednu tableticu dnevno', '4', '2', '4');

INSERT INTO `db`.`operation` (`id`, `clinic_rated`, `date`, `discount`, `doctor_rated`, `duration`, `price`, `clinic_id`, `doctor_id`, `or_id`, `patient_id`) VALUES ('1', b'1', '2020-03-15 13:00:00.000000', '10', b'0', '30', '1000', '1', '5', '3', '17');
INSERT INTO `db`.`operation` (`id`, `clinic_rated`, `date`, `discount`, `doctor_rated`, `duration`, `price`, `clinic_id`, `doctor_id`, `or_id`, `patient_id`) VALUES ('2', b'0', '2020-03-25 09:00:00.000000', '20', b'1', '30', '2000', '1', '6', '3', '19');
INSERT INTO `db`.`operation` (`id`, `clinic_rated`, `date`, `discount`, `doctor_rated`, `duration`, `price`, `clinic_id`, `doctor_id`, `or_id`, `patient_id`) VALUES ('3', b'1', '2020-03-05 14:30:00.000000', '0', b'0', '30', '1500', '2', '7', '5', '17');
INSERT INTO `db`.`operation` (`id`, `clinic_rated`, `date`, `discount`, `doctor_rated`, `duration`, `price`, `clinic_id`, `doctor_id`, `or_id`, `patient_id`) VALUES ('4', b'1', '2020-03-09 12:30:00.000000', '15', b'0', '30', '3000', '4', '8', '11', '19');
INSERT INTO `db`.`operation` (`id`, `clinic_rated`, `date`, `discount`, `doctor_rated`, `duration`, `price`, `clinic_id`, `doctor_id`, `or_id`, `patient_id`) VALUES ('5', b'0', '2020-03-14 18:00:00.000000', '0', b'1', '30', '1500', '3', '9', '8', '18');

INSERT INTO `db`.`doctors_at_operation` (`operation_id`, `doctor_id`) VALUES ('1', '5');
INSERT INTO `db`.`doctors_at_operation` (`operation_id`, `doctor_id`) VALUES ('1', '6');
INSERT INTO `db`.`doctors_at_operation` (`operation_id`, `doctor_id`) VALUES ('2', '7');
INSERT INTO `db`.`doctors_at_operation` (`operation_id`, `doctor_id`) VALUES ('3', '10');

INSERT INTO `db`.`recipe` (`id`, `description`, `medicament_name`, `validated`, `medicament_id`) VALUES ('1', 'Ovo je recepat', 'Kafetin', b'0', '1');
INSERT INTO `db`.`recipe` (`id`, `description`, `medicament_name`, `validated`, `medicament_id`) VALUES ('2', 'Recepat 2', 'Fervex', b'0', '2');
INSERT INTO `db`.`recipe` (`id`, `description`, `medicament_name`, `validated`, `medicament_id`) VALUES ('3', 'Receptic za svasta', 'Konjska Mast', b'0', '6');
INSERT INTO `db`.`recipe` (`id`, `description`, `medicament_name`, `validated`, `medicament_id`) VALUES ('4', 'Overen recept', 'Andol', b'1', '5');
