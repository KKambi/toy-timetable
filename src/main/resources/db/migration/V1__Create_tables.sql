create table course (id bigint NOT NULL AUTO_INCREMENT, code varchar(50), title varchar(50), professor varchar(50), building varchar(10), room varchar(10), start_time integer not null, end_time integer not null, mon varchar(1), tue varchar(1), wed varchar(1), thu varchar(1), fri varchar(1), primary key (id));
create table memo (id bigint NOT NULL AUTO_INCREMENT, registration_course_id bigint, title varchar(25), content varchar(255), primary key (id));
create table registration_course (id bigint NOT NULL AUTO_INCREMENT, course_id bigint, user_id bigint, primary key (id));
create table user (id bigint NOT NULL AUTO_INCREMENT, name varchar(50), primary key (id));
alter table memo add constraint FKhy4fy5s1qvjxvqvl6qrcfvna4 foreign key (registration_course_id) references registration_course(id) on delete cascade;
alter table registration_course add constraint FKtj73gfsxbweiulv4qwutagocf foreign key (course_id) references course(id) on delete cascade;
alter table registration_course add constraint FK2ld6eixhu9kk8uiqdovhxr97d foreign key (user_id) references user(id) on delete cascade;