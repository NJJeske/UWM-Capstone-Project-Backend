--STATEMENT createProject
INSERT INTO projects (
  title,
  description,
  start_date,
  end_date,
  created_date
) VALUES (
  :title,
  :description,
  :start_date,
  :end_date,
  :created_date
);

--STATEMENT readProject
SELECT * FROM projects WHERE id = :id;

--STATEMENT deleteProject
DELETE FROM projects WHERE id = :id;

--STATEMENT updateProject
UPDATE profiles SET
  title = :title,
  description = :description,
  start_date = :start_date,
  end_date = :end_date,
  updated_date = :updated_date
WHERE
  id = :id;
