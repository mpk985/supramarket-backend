create table news (
news_id bigserial primary key,
title varchar,
body varchar,
created_on date,
last_updated date,
news_img varchar
)