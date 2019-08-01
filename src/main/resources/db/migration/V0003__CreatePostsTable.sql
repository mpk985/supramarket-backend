create table posts (
post_id bigserial primary key,
title varchar,
body varchar,
created_on date,
last_updated date,
post_img varchar
)