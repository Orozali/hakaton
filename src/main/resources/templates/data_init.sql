INSERT INTO Department (id, name, institute) VALUES (nextval('department_seq'), 'Computer Engineering Department', 'Kyrghyz Turkish Manas University');

INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'john@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'michael@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'asan@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'adil@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'MANAGER');

INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 1, 'John', 'Doe', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 2, 'Michael', 'Jakson', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 3, 'Asan', 'Asanov', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 4, 'Adil', 'Asanov', 1);

insert into student(date_from, date_to, id, user_id, diplom, image, address, email, faculty, name, profession, sur_name, tel_number, university)
VALUES ( 2020, 2025, nextval('student_seq'), 1, null, null, 'Adress', '2004.01031@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' ),
       ( 2020, 2025, nextval('student_seq'), 2, null, null, 'Adress', '2004.01032@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' ),
       ( 2020, 2025, nextval('student_seq'), 3, null, null, 'Adress', '2004.01033@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' ),
       ( 2020, 2025, nextval('student_seq'), 4, null, null, 'Adress', '2004.01034@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' );





