drop table if exists book cascade;
drop table if exists author cascade;
drop table if exists author_books cascade;

CREATE TABLE public.author
(
    name character varying(255) NOT NULL
);

CREATE TABLE public.author_books
(
    author_list_name character varying(255) NOT NULL,
    books_name       character varying(255) NOT NULL
);

CREATE TABLE public.book
(
    name  character varying(255) NOT NULL,
    price integer
);

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (name);


ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (name);

ALTER TABLE ONLY public.author_books
    ADD CONSTRAINT fkk74goiut348b993ynq9lfcise FOREIGN KEY (author_list_name) REFERENCES public.author(name);

ALTER TABLE ONLY public.author_books
    ADD CONSTRAINT fkqs3yqt08ti7jqufw5bjmfka78 FOREIGN KEY (books_name) REFERENCES public.book(name);


truncate table book cascade;
truncate table author cascade;
truncate table author_books cascade;

insert into author (name)
values ('igor');
insert into author (name)
values ('rita');
insert into author (name)
values ('fedor');
insert into author (name)
values ('petya');
insert into author (name)
values ('dima');

insert into book (name, price)
values ('b2', 1000);
insert into book (name, price)
values ('b3', 2000);
insert into book (name, price)
values ('b4', 3000);
insert into book (name, price)
values ('b5', 4000);
insert into book (name, price)
values ('b6', 5000);

insert into author_books (author_list_name, books_name)
values ('igor', 'b2');
insert into author_books (author_list_name, books_name)
values ('igor', 'b3');
insert into author_books (author_list_name, books_name)
values ('igor', 'b4');
insert into author_books (author_list_name, books_name)
values ('igor', 'b5');
insert into author_books (author_list_name, books_name)
values ('igor', 'b6');
insert into author_books (author_list_name, books_name)
values ('rita', 'b2');
insert into author_books (author_list_name, books_name)
values ('rita', 'b3');