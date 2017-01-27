CREATE TABLE IF NOT EXISTS address_list (
  address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  vorname VARCHAR(40) NOT NULL,
  nachname VARCHAR(40) NOT NULL,
  strasse VARCHAR(70),
  hausnummer VARCHAR(10),
  plz varchar(10),
  ort VARCHAR(50)
);