INSERT INTO TBL_AUTHORS (first_name, last_name, country) VALUES
  ('George R. R.', 'Martin', 'USA'),
  ('Andrzej', 'Sapkowski', 'Poland'),
  ('Stephen', 'King', 'USA'),
  ('Howard Phillips', 'Lovecraft', 'USA'),
  ('Jeanne', 'Boyarsky ', 'USA'),
  ('Scott', 'Selikoff ', 'USA'),
    ('Scott', '555 ', 'USA');

   INSERT INTO TBL_GENRES (name) values
   ('fantasy'),
   ('romance '),
   ('horror'),
   ('study'),
   ('science-fiction');

    INSERT INTO TBL_BOOKS (name, author_id, genre_id) values
    ('A Game of Thrones', 1, 1),
    ('A Dream of Spring', 1, 1),
    ('OCA: Oracle Certified Associate', 5, 4),
    ('OCA: Oracle Certified Associate', 6, 4),
    ('The Call of Cthulhu', 4, 3),
    ('The Dark Tower',3, 5);