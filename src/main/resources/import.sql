INSERT INTO Book
VALUES (1, 'World Classics', 'Jane Eyre', '20');
INSERT INTO Book
VALUES (2, 'World Classics', 'Romeo and Juliet', '25');
INSERT INTO Book
VALUES (3, 'Maths', 'Geometri', '20');

INSERT INTO Category
VALUES (1, 'World Classics');
INSERT INTO Category
VALUES (2, 'Maths');

INSERT INTO Book_Store
VALUES (1, 'ISTANBUL', 'Deniz Book Store');
INSERT INTO Book_Store
VALUES (2, 'ANKARA', 'Pegasus Book Store');
INSERT INTO Book_Store
VALUES (3, 'IZMIR', 'Paper Book Store');

INSERT INTO Book_Store_Inventory
VALUES (1, 2, 'Romeo and Juliet', 75, 10, 'Istanbul', 1, 'Deniz Book Store')