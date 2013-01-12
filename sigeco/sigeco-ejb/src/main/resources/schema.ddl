
    create table public.Member (
        id int8 not null,
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (id),
        unique (email)
    );

    create sequence public.hibernate_sequence;
