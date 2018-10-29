CREATE TABLE customers (
  id varchar(36) PRIMARY KEY,
  identification varchar(15) NOT NULL,
  name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  mail varchar(45) DEFAULT NULL,
  address varchar(500) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL,
  type varchar(1) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW()
);

CREATE INDEX customers_identification ON customers (identification);


CREATE TABLE faceplates (
  id varchar(36) PRIMARY KEY,
  faceplate varchar(10) NOT NULL,
  customerid varchar(36) NOT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
   update_date TIMESTAMP DEFAULT NOW()
  );
CREATE INDEX faceplates_faceplate ON faceplates (faceplate);