INSERT INTO Department (id, name, institute) VALUES (nextval('department_seq'), 'Computer Engineering Department', 'Kyrghyz Turkish Manas University');

INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'john@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'michael@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'asan@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'TEACHER');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'adil@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'MANAGER');

INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 1, 'John', 'Doe', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 2, 'Michael', 'Jakson', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 3, 'Asan', 'Asanov', 1);
INSERT INTO Teacher (id, user_id, name, surname, department_id) VALUES (nextval('teacher_seq'), 4, 'Adil', 'Asanov', 1);

INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'stud1@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'STUDENT');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'stud2@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'STUDENT');
INSERT INTO Users (id, email, password, role) VALUES (nextval('user_seq'), 'stud3@gmail.com', '$2a$12$xW0toPA2AchEJ.deBxnmcuaDR/1kD6cWd9IbVkO7.3.o374DjkqaO', 'STUDENT');

INSERT INTO Student (user_id, date_from, date_to, id, diplom, image, address, email, faculty, name, profession, sur_name, tel_number, university)
VALUES (5, 2020, 2025, nextval('student_seq'), null, null, 'Adress', '2004.01031@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' ),
       (6, 2020, 2025, nextval('student_seq'), null, null, 'Adress', '2004.01034@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' ),
       (7, 2020, 2025, nextval('student_seq'), null, null, 'Adress', '2004.01035@manas.edu.kg', 'Engineering', 'Orozali','Computer','Iliazov', '+996551553552', 'Manas' );

INSERT INTO Application (id, status, student_id, rating)
VALUES (nextval('application_seq'), 'PENDING', 1, 0),
        (nextval('application_seq'), 'PENDING', 2, 0),
        (nextval('application_seq'), 'PENDING', 3, 0);

INSERT INTO exam(date, duration, time, id, name)
VALUES ('2024-05-01', 90, '12:00:00', nextval('exam_seq'), 'Bil-316'),
        ('2024-05-01', 90, '12:00:00', nextval('exam_seq'), 'Bil-316'),
        ('2024-05-01', 90, '12:00:00', nextval('exam_seq'), 'Bil-316');

INSERT INTO exam_paper(exam_id, id, file)
VALUES (1, nextval('exam_paper_seq'), null),
       (2, nextval('exam_paper_seq'), null),
       (3, nextval('exam_paper_seq'), null);

INSERT INTO Exam_Answer (id, application_id, image)
VALUES (nextval('exam_answer_seq'), 1, null);
INSERT INTO Exam_Answer (id, application_id, image)
VALUES (nextval('exam_answer_seq'), 2, null);
INSERT INTO Exam_Answer (id, application_id, image)
VALUES (nextval('exam_answer_seq'), 3, null);

INSERT INTO Exam_Grade (id, grade, feedback, exam_answer_id, teacher_id)
VALUES (nextval('exam_grade_seq'), 90, 'Excellent performance', 1, 1);

INSERT INTO Exam_Grade (id, grade, feedback, exam_answer_id, teacher_id)
VALUES (nextval('exam_grade_seq'), 100, 'Excellent performance', 2, 2);

INSERT INTO Exam_Grade (id, grade, feedback, exam_answer_id, teacher_id)
VALUES (nextval('exam_grade_seq'), 22, 'Excellent performance', 3, 3);


INSERT INTO form(id, exam_id, question)
VALUES (nextval('form_seq'), 1, 'What is you name?'),
       (nextval('form_seq'), 1, 'What is you name?'),
       (nextval('form_seq'), 2, 'What is you name?'),
       (nextval('form_seq'), 2, 'What is you name?'),
       (nextval('form_seq'), 3, 'What is you name?'),
       (nextval('form_seq'), 3, 'What is you name?');

INSERT INTO form_grade(id, grade, application_id, teacher_id)
VALUES (nextval('form_grade_seq'), 89, 1, 1),
       (nextval('form_grade_seq'), 89, 2, 2),
       (nextval('form_grade_seq'), 89, 3, 3);
