CREATE TABLE positions(
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  company_id BIGINT(20) NOT NULL FOREIGN KEY,
  description VARCHAR(255) DEFAULT NULL,
  created_date BIGINT(20) NOT NULL,
  updated_date BIGINT(20) DEFAULT NULL,
  start_date BIGINT(20) DEFAULT NULL,
  end_date BIGINT(20) DEFAULT NULL,
  start_pay DOUBLE(28) DEFAULT NULL,
  end_pay DOUBLE(28) DEFAULT NULL,
);