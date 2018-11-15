--STATEMENT createEducation
INSERT INTO educations (
  user_id,
  address_id,
  school_name,
  degree,
  field_of_study,
  start_date,
  end_date,
  created_date
) VALUES (
  :user_id,
  :address_id,
  :school_name,
  :degree,
  :field_of_study,
  :start_date,
  :end_date,
  :created_date
);

--STATEMENT readEducation
SELECT * FROM educations WHERE id = :id;

--STATEMENT deleteEducation
DELETE FROM educations WHERE id = :id;

--STATEMENT updateEducation
UPDATE educations SET
  user_id = :user_id,
  address_id = :address_id,
  school_name = :school_name,
  degree = :degree,
  field_of_study = :field_of_study,
  start_date = :start_date,
  end_date = :end_date,
  updated_date = :updated_date
WHERE
  id = :id;
