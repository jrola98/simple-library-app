DROP TABLE if exists books CASCADE;
CREATE TABLE books
(
    book_id serial PRIMARY KEY,
    title VARCHAR,
    author varchar,
    publish_year VARCHAR
);



DROP TABLE if exists users CASCADE;
CREATE TABLE users
(
    user_id serial PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    email VARCHAR

);

DROP TABLE if exists loaned_books CASCADE;
CREATE TABLE loaned_books
(
    loan_id serial,
    book_id INT,
    user_id INT,
    loan_date VARCHAR,

    CONSTRAINT fk_Book_LoanedBooks
            FOREIGN KEY (book_id)
                REFERENCES books (book_id),

    CONSTRAINT fk_user_LoanedBooks
            FOREIGN KEY (user_id)
                REFERENCES users (user_id)
);























