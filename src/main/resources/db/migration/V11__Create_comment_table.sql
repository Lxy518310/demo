create table t_comment
(
    id bigint auto_increment,
    parent_id bigint not null,
    content varchar(1024) not null,
    gmt_create long not null,
    gmt_modified long not null,
    type int not null,
    like_count int default 0 not null,
    commentator long not null,
    constraint t_comment_pk
    primary key (id)
);