--STATEMENT createPosition
INSERT INTO positions (
  name,
  company_id,
  description,
  created_date,
  update_date,
  start_date,
  end_date,
  start_pay,
  end_pay
) VALUES (
  :name,
  :company_id,
  :description,
  :created_date,
  :update_date,
  :start_date,
  :end_date,
  :start_pay,
  :end_pay
);

--STATEMENT readPosition
SELECT * FROM positions WHERE id = :id;

--STATEMENT deletePosition
DELETE FROM positions WHERE id = :id;

--STATEMENT updatePosition
UPDATE positions SET
  name = :name,
  company_id = :company_id,
  description = :description,
  home_phone = :home_phone,
  created_date = :created_date,
  update_date = :update_date,
  start_date = :start_date,
  end_date = :end_date,
  start_pay = :start_pay,
  end_pay = :end_pay
WHERE
  id = :id;