--STATEMENT createDocument
INSERT INTO documents (
  user_id,
  name,
  created_date,
  updated_date,
  path
) VALUES (
  :user_id,
  :name,
  :created_date,
  :updated_date,
  :path
);

--STATEMENT readDocument
SELECT * FROM documents WHERE id = :id;

--STATEMENT deleteDocument
DELETE FROM documents WHERE id = :id;

--STATEMENT updateDocument
UPDATE documents SET
  user_id = :user_id,
  name = :name,
  updated_date = :updated_date,
  path = :path
WHERE
  id = :id;