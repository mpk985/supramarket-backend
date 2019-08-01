create table images (
post bigserial,
img1 varchar,
img2 varchar,
img3 varchar,
img4 varchar,
img5 varchar,
img6 varchar,
img7 varchar,
img8 varchar,
img9 varchar,
FOREIGN KEY(post) REFERENCES posts(post_id)
)