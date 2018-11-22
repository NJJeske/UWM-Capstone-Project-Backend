--STATEMENT createContact
INSERT INTO contacts (
  company_id,
  position,
  first_name,
  last_name,
  email,
  phone_number,
  notes,
  created_date
) VALUES (
  :company_id,
  :position,
  :first_name,
  :last_name,
  :email,
  :phone_number,
  :notes,
  :created_date
);

--STATEMENT readContact
SELECT * FROM contacts WHERE id = :id;

--STATEMENT deleteContact
DELETE FROM contacts WHERE id = :id;

--STATEMENT updateContact
UPDATE contacts SET
  company_id = :company_id,
  position = :position,
  first_name = :first_name,
  last_name = :last_name,
  email = :email,
  phone_number = :phone_number,
  notes = :notes,
  updated_date = :updated_date
WHERE
  id = :id;