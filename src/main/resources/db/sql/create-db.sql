CREATE TABLE invoice (
  id  IDENTITY PRIMARY KEY ,
  client  VARCHAR(150) NOT NULL,
  vat_rate INTEGER NOT NULL,
  invoice_date TIMESTAMP NOT NULL,
  vat DECIMAL(20,2),
  sub_total DECIMAL(20,2) NOT NULL,
  total DECIMAL(20,2) NOT NULL
);

CREATE TABLE line_item (
  id  IDENTITY PRIMARY KEY,
  quantity INTEGER NOT NULL,
  description VARCHAR(255) NOT NULL,
  unit_price DECIMAL(20,2) NOT NULL,
  line_item_total DECIMAL(20,2) NOT NULL,
  invoice_id BIGINT REFERENCES invoice(id)
);


