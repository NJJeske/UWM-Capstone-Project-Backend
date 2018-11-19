--STATEMENT createCompany
INSERT INTO companies (
  name,
  address,
  phone_number,
  website,
  created_date,
  updated_date
) VALUES (
  :name,
  :address,
  :phone_number,
  :website,
  :created_date,
  :updated_date
);

--STATEMENT readCompany
SELECT * FROM companies WHERE id = :id;

--STATEMENT deleteCompany
DELETE FROM companies WHERE id = :id;

--STATEMENT updateCompany
UPDATE companies SET
  name = :name,
  address = :address,
  phone_number = :phone_number,
  website = :website,
  updated_date = :updated_date
WHERE
  id = :id;