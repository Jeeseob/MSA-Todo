INSERT INTO PERSON (name, organization, position, remark) VALUES ('jee', 'jbae', '목사', '목사 rest');
INSERT INTO PERSON (name, organization, position, remark) VALUES ('jee2', 'jbae', '목사', '목사 rest');
INSERT INTO PERSON (name, organization, position, remark) VALUES ('jee3', 'jbae', '목사', '목사 rest');
INSERT INTO PERSON (name, organization, position, remark) VALUES ('jee4', 'jbae', '목사', '목사 rest');

INSERT INTO PROGRAM (name, type, start_time, end_time) VALUES ('안녕다큐', '다큐', '15:30:00.000', '16:30:00.000');
INSERT INTO PROGRAM (name, type, start_time, end_time) VALUES ('asdg', 'sdgf', '11:30:00.000', '13:30:00.000');
INSERT INTO PROGRAM (name, type, start_time, end_time) VALUES ('asdg', 'asd', '16:30:00.000', '17:30:00.000');

INSERT INTO PERSON_PROGRAM (local_date_time, person_id, program_id) VALUES ('2022-01-01 16:00:00', 1, 1);
INSERT INTO PERSON_PROGRAM (local_date_time, person_id, program_id) VALUES ('2022-01-01 16:30:00', 1, 3);
INSERT INTO PERSON_PROGRAM (local_date_time, person_id, program_id) VALUES ('2022-01-01 15:00:00', 1, 2);