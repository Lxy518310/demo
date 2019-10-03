create table t_question
(
	id int auto_increment,
	title varchar(50) not null,
	description text null,
	gmt_create bigint null,
	gmt_modified bigint null,
	tag varchar(100) null,
	like_count int default 0 not null,
	comment_count int default 0 not null,
	constraint t_question_pk
		primary key (id)
);
