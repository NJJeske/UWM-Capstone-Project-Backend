--STATEMENT createAddress
INSERT INTO addresses (
  user_id,
  street_1,
  street_2,
  city,
  state,
  zipcode,
  created_date
) VALUES (
  :user_id,
  :street_1,
  :street_2,
  :city,
  :state,
  :zipcode,
  :created_date
);

--STATEMENT readAddress
SELECT * FROM addresses WHERE id = :id;

--STATEMENT deleteAddress
DELETE FROM addresses WHERE id = :id;

--STATEMENT updateAddress
UPDATE profiles SET
  user_id = :user_id,
  street_1 = :street_1,
  street_2 = :street_2,
  city = :city,
  state = :state,
  zipcode = :zipcode,
  updated_date = :updated_date
WHERE
  id = :id;