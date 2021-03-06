    CREATE DATABASE exam_navita
        WITH
        OWNER = postgres
        ENCODING = 'UTF8'
        CONNECTION LIMIT = -1;

    create table marca (
       id int8 generated by default as identity,
        nome varchar(255) not null,
        primary key (id)
    );

    create table patrimonio (
       id int8 generated by default as identity,
        descricao varchar(255),
        nome varchar(255) not null,
        numero_tombo int4,
        marca_id int8,
        primary key (id)
    );
    create table role (
       id int8 generated by default as identity,
        descricao varchar(255),
        primary key (id)
    )
    create table role_usuario (
           usuario_id int8 not null,
            role_id int8 not null
        );

    create table usuario (
           id int8 generated by default as identity,
            ativo boolean not null,
            email varchar(255),
            nome varchar(255) not null,
            senha varchar(255) not null,
            primary key (id)
        );

   alter table if exists marca
       add constraint UK_ix7qqllivg82mpp45cgolja3 unique (nome);

   alter table if exists usuario
          add constraint UK_5171l57faosmj8myawaucatdw unique (email);

   alter table if exists patrimonio
         add constraint FK1rpn3p8il8p6whc6kjeiei96q
         foreign key (marca_id)
         references marca;

   alter table if exists role_usuario
          add constraint FKm5is1dm2q77xnij7mdlt7ot2c
          foreign key (role_id)
          references role;

   alter table if exists role_usuario
          add constraint FKd856qe9hqd4wq1qieixqm5n3f
          foreign key (usuario_id)
          references usuario;
