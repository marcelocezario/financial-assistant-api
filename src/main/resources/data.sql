-- INSERT CURRENCIES
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('96b9ef14-bb37-4f53-947d-1a679bbd7608', 'BRL', 'Real', 'R$', 2, 1.0, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('144db3c3-8b61-4c90-8eaf-ea5b9fe560ea', 'USD', 'Dólar Americano', 'US$', 2, 5.715, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('ee621c6e-a586-45cf-b582-ea12d16714be', 'EUR', 'Euro', '€', 2, 6.73, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('f56e1b76-a6ef-4548-a511-25ae1faea3a3', 'GBP', 'Libra Esterlina', '£', 2, 7.907, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('31c312d6-ca45-40eb-a3da-43d6520a7455', 'ARS', 'Peso Argentino', 'ARS', 2, 0.062, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('715840a0-2976-422d-a4ff-8f6832a42265', 'CAD', 'Dólar Canadense', 'C$', 2, 4.5422, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('924be1a7-722f-443c-84be-84cbe383730d', 'AUD', 'Dólar Australiano', 'AU$', 2, 4.3404, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('dc4ac05c-4653-4b16-9120-ae7294727b5c', 'JPY', 'Iene', '¥', 0, 0.0516, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('ae3b4bd9-84a0-4205-9120-600947960016', 'CNY', 'Renminbi', 'CN¥', 1, 0.8691, CURRENT_TIMESTAMP, null, true);
INSERT INTO public.tb_currency_type (UUID, CODE, NAME, INITIALS, DECIMAL_DIGITS, PRICE_INBRL, CREATION_MOMENT, LAST_UPDATE, ACTIVE) VALUES ('4fe55abb-cf55-482e-b1fd-9b60efa22862', 'BTC', 'Bitcoin', '₿', 5, 359843.803, CURRENT_TIMESTAMP, null, true);

-- INSERT USERS
INSERT INTO public.tb_user (UUID, NAME, NICKNAME, EMAIL, PASSWORD, IMAGE_URL, CREATION_MOMENT, LAST_UPDATE, ACTIVE, DEFAULT_CURRENCY_TYPE_ID) VALUES ('ad173b6d-7864-30db-8fce-f93fb926cf66', 'Administrador', 'Admin', 'admin@mhc.dev.br', '$2a$10$LriBEPoPQGgk5tN5a5s3S.Hb3NMJ4Ww4SS3Gmv7G1TFpFrKbwkC5y', null, CURRENT_TIMESTAMP, null, true, 1);
INSERT INTO PUBLIC.TB_PROFILES (USER_ID, PROFILES) VALUES (1, 1);
INSERT INTO PUBLIC.TB_PROFILES (USER_ID, PROFILES) VALUES (1, 2);


INSERT INTO public.tb_user (UUID, NAME, NICKNAME, EMAIL, PASSWORD, IMAGE_URL, CREATION_MOMENT, LAST_UPDATE, ACTIVE, DEFAULT_CURRENCY_TYPE_ID) VALUES ('c50e7533-673f-3886-bfb7-9f7894ef8c9a', 'Usuário Básico', 'Basico', 'basic@mhc.dev.br', '$2a$10$TYpQkI/yuulkZux3lfmLBO3FI3K.1iHKGND/lkaj3OjVyKn6CAVv2', null, CURRENT_TIMESTAMP, null, true, 1);
INSERT INTO PUBLIC.TB_PROFILES (USER_ID, PROFILES) VALUES (2, 2);

