CREATE TABLE IF NOT EXISTS user
(
    id        SERIAL primary key,
    user_id    varchar(45)  not null,
    password  varchar(200) not null,
    nickname  varchar(45)           DEFAULT null,
    is_admin   boolean      not null DEFAULT false,
    status    varchar(45)           DEFAULT null,
    created_at datetime              DEFAULT null,
    updated_at datetime              DEFAULT null
);

CREATE TABLE IF NOT EXISTS category
(
    id        SERIAL primary key,
    name      varchar(45) not null,
    created_at datetime    not null
);

CREATE TABLE IF NOT EXISTS post
(
    id         SERIAL primary key,
    user_id     bigint unsigned not null,
    category_id bigint unsigned not null,
    name       varchar(45)     not null,
    content    varchar(500)    not null,
    view_count  int             not null,
    created_at  datetime        not null,
    updated_at  datetime,
    deleted_at  datetime,
    foreign key (category_id) REFERENCES category (id),
    foreign key (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS tag
(
    id   SERIAL primary key,
    name varchar(45) not null,
    url  varchar(45) not null
);

CREATE TABLE IF NOT EXISTS post_tag
(
    id     SERIAL primary key,
    post_id bigint unsigned not null,
    tag_id  bigint unsigned not null,

    foreign key post_tag_fk_1 (post_id) REFERENCES post (id),
    foreign key post_tag_fk_2 (tag_id) REFERENCES tag (id)
);

CREATE TABLE IF NOT EXISTS file
(
    id        SERIAL primary key,
    post_id    bigint unsigned not null,
    path      varchar(100)    not null,
    name      varchar(45)     not null,
    extension varchar(45)     not null,

    foreign key file_fk_1 (post_id) REFERENCES post (id)
);

CREATE TABLE IF NOT EXISTS comment
(
    id           SERIAL primary key,
    user_id       bigint unsigned not null,
    post_id       bigint unsigned not null,
    sub_comment_id bigint unsigned,
    content     varchar(300)    not null,
    created_at    datetime        not null,
    deleted_at    datetime,

    foreign key comment_fk_1 (post_id) REFERENCES post (id)
);
