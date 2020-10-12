create table art_inventory (
inventory_id bigserial primary key,
year varchar,
title varchar,
description varchar,
price NUMBER(8,2),
sold SMALLINT,
product_img varchar
)