--invoice
INSERT INTO invoice VALUES (1, 'ABC (Pty) Ltd', 10, '2018-06-29 01:33:00', 3.00, 30.00, 33.00);
INSERT INTO invoice VALUES (2, 'MODI (Pty) Ltd', 15, '2018-06-29 01:33:00', 3.00, 20.00, 33.00);
INSERT INTO invoice VALUES (3, 'EOH (Pty) Ltd', 15, '2018-06-29 01:33:00', 3.00, 20.00, 23.00);

--item line
INSERT INTO line_item VALUES (1, 2, 'XYZ Item', 5.00, 10.00, 1);
INSERT INTO line_item VALUES (2, 1, 'XYZ Item', 10.00, 10.00, 1);
INSERT INTO line_item VALUES (3, 2, 'XYZ Item', 5.00, 10.00, 1);

INSERT INTO line_item VALUES (4, 2, 'XYZ Item', 5.00, 10.00, 2);
INSERT INTO line_item VALUES (5, 1, 'XYZ Item', 10.00, 10.00, 2);
INSERT INTO line_item VALUES (6, 2, 'XYZ Item', 5.00, 10.00, 2);


INSERT INTO line_item VALUES (7, 2, 'XYZ Item', 5.00, 10.00, 3);
INSERT INTO line_item VALUES (8, 1, 'XYZ Item', 10.00, 10.00, 3);
INSERT INTO line_item VALUES (9, 2, 'XYZ Item', 5.00, 10.00, 3);
