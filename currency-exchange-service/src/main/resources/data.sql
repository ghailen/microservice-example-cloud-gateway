insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment) values (10001,'USD','INR',65,'');
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment) values (10002,'EUR','INR',75,'');
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment) values (10003,'AUD','INR',25,'');


-- Insert data into Bank (one-to-many relationship with Country)
INSERT INTO Bank (name)
VALUES ('Bank_Name_1');

-- Insert data into Country (one-to-one relationship with Currency)
INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_1', (SELECT id FROM Bank WHERE name = 'Bank_Name_1'));

INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_2', (SELECT id FROM Bank WHERE name = 'Bank_Name_1'));

INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_3', (SELECT id FROM Bank WHERE name = 'Bank_Name_1'));

-- Insert data into Currency (one-to-one relationship with Country)
INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_1', (SELECT id FROM Country WHERE name = 'Country_Name_1'));

INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_2', (SELECT id FROM Country WHERE name = 'Country_Name_2'));

INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_3', (SELECT id FROM Country WHERE name = 'Country_Name_3'));
-- You can continue adding more data as needed




INSERT INTO Bank (name)
VALUES ('Bank_Name_2');

-- Insert data into Country (one-to-one relationship with Currency)
INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_4', (SELECT id FROM Bank WHERE name = 'Bank_Name_2'));

INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_5', (SELECT id FROM Bank WHERE name = 'Bank_Name_2'));

INSERT INTO Country (name, bank_id)
VALUES ('Country_Name_6', (SELECT id FROM Bank WHERE name = 'Bank_Name_2'));

-- Insert data into Currency (one-to-one relationship with Country)
INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_4', (SELECT id FROM Country WHERE name = 'Country_Name_4'));

INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_5', (SELECT id FROM Country WHERE name = 'Country_Name_5'));

INSERT INTO Currency (currency_name, country_id)
VALUES ('Currency_Name_6', (SELECT id FROM Country WHERE name = 'Country_Name_6'));
-- You can continue adding more data as needed

-- select distinct 'abc', cu.country_id,  k.id from bank k
-- join country c on c.bank_id=k.id
-- join currency cu on c.id=cu.country_id
--
-- SELECT 'abc', 'bf', subquery.id
-- FROM (
--     SELECT MIN(c.id) AS min_id, k.id AS id
--     FROM Bank k
--     JOIN Country c ON c.bank_id = k.id
--     JOIN Currency cu ON c.id = cu.country_id
--     GROUP BY k.id
-- ) AS subquery;