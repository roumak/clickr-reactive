create table if not exists click(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20),
    user_type VARCHAR(20),
    session_id UUID,
    creation_timestamp TIMESTAMP,
    colour VARCHAR(10),
    click_count BIGINT

);



create table if not exists click_session(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    session_id UUID,
    creation_timestamp TIMESTAMP,
    created_by VARCHAR(20)

)