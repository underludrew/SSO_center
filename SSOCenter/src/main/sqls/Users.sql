create table Users(
    user_id INTEGER AUTO_INCREMENT,
    user_name varchar(40) NOT NULL,
    user_password varchar(50) NOT NULL,
    img varchar(100),
    user_birthday DATE,
    isvip boolean NOT NULL,
    primary key (user_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;