create table Rubric (
                        id bigserial primary key ,
                        name varchar(48) not null ,
                        parent_id bigint references Rubric(id)
);

create table Properties (
                            id bigserial primary key ,
                            name varchar(48) not null ,
                            units varchar(10)
);

create table Rubric_Properties (
                                   id bigserial primary key ,
                                   properties_id bigint references Properties(id),
                                   rubric_id bigint references Rubric(id)
);

create table Items (
                       id bigserial primary key ,
                       name varchar(400) not null ,
                       price int ,
                       description varchar(300) ,
                       rubric_id bigint references Rubric(id)
);


create table Values (
                        id bigserial primary key ,
                        value varchar(300) not null
);


create table Properties_Value (
                                  id bigserial primary key ,
                                  properties_id bigint references Properties(id),
                                  value_id bigint references Values(id)
);


create table Item_Properties_Value (
                                       id bigserial primary key ,
                                       properties_value_item bigint references Properties_Value(id),
                                       item_id bigint references Items(id)
);