create table clothing_inventory (
inventory_id bigserial primary key,
title varchar,
size varchar,
color varchar,
price numeric(4,2) not null,
inventory_remaining smallint not null DEFAULT 0,
product_img varchar
)