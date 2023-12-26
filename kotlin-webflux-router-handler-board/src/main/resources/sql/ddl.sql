CREATE TABLE user
(
    id        SERIAL primary key,
    userId    varchar(45)  not null,
    password  varchar(200) not null,
    nickname  varchar(45)           DEFAULT null,
    isAdmin   boolean      not null DEFAULT false,
    status    varchar(45)           DEFAULT null,
    createdAt datetime              DEFAULT null,
    updatedAt datetime              DEFAULT null
);

CREATE TABLE category
(
    id   SERIAL primary key,
    name varchar(45) not null
);

CREATE TABLE post
(
    id         SERIAL primary key,
    userId     bigint unsigned not null,
    categoryId bigint unsigned not null,
    name       varchar(45)     not null,
    content    varchar(500)    not null,
    viewCount  int             not null,
    createdAt  datetime        not null,
    updatedAt  datetime DEFAULT null,
    foreign key (categoryId) REFERENCES category (id),
    foreign key (userId) REFERENCES user (id)
);

CREATE TABLE tag
(
    id   SERIAL primary key,
    name varchar(45) not null,
    url  varchar(45) not null
);

CREATE TABLE post_tag
(
    id     SERIAL primary key,
    postId bigint unsigned not null,
    tagId  bigint unsigned not null,

    foreign key post_tag_fk_1 (postId) REFERENCES post (id),
    foreign key post_tag_fk_2 (tagId) REFERENCES tag (id)
);

CREATE TABLE file
(
    id        SERIAL primary key,
    postId    bigint unsigned not null,
    path      varchar(100)    not null,
    name      varchar(45)     not null,
    extension varchar(45)     not null,

    foreign key file_fk_1 (postId) REFERENCES post (id)
);

CREATE TABLE post_file
(
    id     SERIAL primary key,
    postId bigint unsigned not null,
    fileId bigint unsigned not null,

    foreign key post_tag_fk_1 (postId) REFERENCES post (id),
    foreign key post_tag_fk_2 (fileId) REFERENCES file (id)
);

CREATE TABLE comment
(
    id           SERIAL primary key,
    contents     varchar(300)    not null,
    subCommentId int             not null,
    postId       bigint unsigned not null,

    foreign key comment_fk_1 (postId) REFERENCES post (id)
);
