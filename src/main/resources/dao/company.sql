--STATEMENT createCompany
INSERT INTO companies (
  name,
  address,
  phone_number,
  website,
  created_date,
  update_date
) VALUES (
  :name,
  :address,
  :phone_number,
  :website,
  :created_date,
  :update_date
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
  home_phone = :home_phone,
  website = :website,
  created_date = :created_date,
  update_date = :update_date
WHERE
  id = :id;