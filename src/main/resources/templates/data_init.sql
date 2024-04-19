INSERT INTO Department (id, name, institute) VALUES (nextval('department_seq'), 'Computer Engineering Department', 'Kyrghyz Turkish Manas University');

INSERT INTO Users (id, email, password, role) VALUES (nextval('student_seq'), 'john@gmail.com', 'pass', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('student_seq'), 'michael@gmail.com', 'pass', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('student_seq'), 'asan@gmail.com', 'pass', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('student_seq'), 'adil@gmail.com', 'pass', 'MANAGER');

INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 1, 'John', 'Doe', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 2, 'Michael', 'Jakson', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 3, 'Asan', 'Asanov', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 4, 'Adil', 'Asanov', 1);

