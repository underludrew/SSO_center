create table admins(
    admin_id INTEGER AUTO_INCREMENT,
    admin_name varchar(40) NOT NULL,
    admin_password varchar(50) NOT NULL,
    admin_permission varchar(40) NOT NULL,
    period varchar(50) NOT NULL,
    primary key (admin_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;