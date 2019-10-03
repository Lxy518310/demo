alter table t_question drop column creator;
alter table t_question add creator int not null;