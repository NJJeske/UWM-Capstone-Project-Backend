--STATEMENT createCompany
INSERT INTO companies (
  user_id,
  name,
  address,
  phone_number,
  website,
  created_date,
  updated_date
) VALUES (
  :user_id,
  :name,
  :address,
  :phone_number,
  :website,
  :created_date,
  :updated_date
);

--STATEMENT readCompany
SELECT * FROM companies WHERE id = :id;

--STATEMENT readManyCompanies
SELECT * FROM companies WHERE user_id = :user_id;

--STATEMENT deleteCompany
DELETE FROM companies WHERE id = :id;

--STATEMENT updateCompany
UPDATE companies SET
  user_id = :user_id,
  name = :name,
  address = :address,
  phone_number = :phone_number,
  website = :website,
  updated_date = :updated_date
WHERE
  id = :id;