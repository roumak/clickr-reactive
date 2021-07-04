
truncate table click_session;
insert into click_session(session_id,creation_timestamp,created_by)
values(RANDOM_UUID(),CURRENT_TIMESTAMP(),'roumak');
insert into click_session(session_id,creation_timestamp,created_by)
values(RANDOM_UUID(),CURRENT_TIMESTAMP(),'roumak');


truncate table click;
insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values( (select session_id from click_session where id=1),'josh','CLICK_USER',CURRENT_TIMESTAMP(),'RED',0);
insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values((select session_id from click_session where id=1),'soham','CLICK_USER',CURRENT_TIMESTAMP(),'RED',0);
insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values((select session_id from click_session where id=1),'simon','CLICK_USER',CURRENT_TIMESTAMP(),'BLUE',0);
insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values((select session_id from click_session where id=1),'avik','CLICK_USER',CURRENT_TIMESTAMP(),'BLUE',1);


insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values((select session_id from click_session where id=2),'watson','CLICK_USER',CURRENT_TIMESTAMP(),'RED',0);
insert into click (session_id,user_name,user_type,creation_timestamp,colour,click_count)
values((select session_id from click_session where id=2),'wilson','CLICK_USER',CURRENT_TIMESTAMP(),'BLUE',0);


