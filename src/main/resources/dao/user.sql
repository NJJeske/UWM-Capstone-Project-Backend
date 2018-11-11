--STATEMENT createUser
INSERT INTO users (
  email,
  password,
  title,
  first_name,
  middle_name,
  last_name,
  mobile_phone,
  home_phone,
  website,
  created_date,
  update_date
) VALUES (
  :email,
  :password,
  :title,
  :first_name,
  :middle_name,
  :last_name,
  :mobile_phone,
  :home_phone,
  :website,
  :created_date,
  :update_date
);

--STATEMENT readUser
SELECT * FROM users WHERE id = :id;

--STATEMENT readUserByFirstAndLast
SELECT * FROM users WHERE first_name = :first_name AND last_name = :last_name;

--STATEMENT deleteUser
DELETE FROM users WHERE id = :id;

--STATEMENT updateUser
UPDATE users SET
  email = :email,
  password = :password,
  title = :title,
  first_name = :first_name,
  middle_name = :middle_name,
  last_name = :last_name,
  mobile_phone = :mobile_phone,
  home_phone = :home_phone,
  website = :website,
  created_date = :created_date,
  update_date = :update_date
WHERE
  id = :id;