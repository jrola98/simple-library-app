CREATE TABLE Book
(
    bookID serial PRIMARY KEY,
    title VARCHAR,
    Author CHAR,
    publish_year VARCHAR,
);

CREATE TABLE LoanedBooks
(
    memberID INT,
    bookID INT,
    loan_date VARCHAR,

    CONSTRAINT fk_Book_LoanedBooks
            FOREIGN KEY (bookID)
                REFERENCES Book (bookID)
);