alter table t_comment modify gmt_create bigint not null;
alter table t_comment modify gmt_modified bigint not null;
alter table t_comment modify commentator long not null;
