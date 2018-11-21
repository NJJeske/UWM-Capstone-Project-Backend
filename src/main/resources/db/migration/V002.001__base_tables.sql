CREATE TABLE projects (
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT(20) NOT NULL,
  position_id BIGINT(20) DEFAULT NULL,
  education_id BIGINT(20) DEFAULT NULL,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL DEFAULT '',
  start_date BIGINT(20) DEFAULT NULL,
  end_date BIGINT(20) DEFAULT NULL,
  created_date BIGINT(20) NOT NULL,
  updated_date BIGINT(20) DEFAULT NULL
);