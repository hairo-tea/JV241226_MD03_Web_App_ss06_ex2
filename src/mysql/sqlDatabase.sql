create database movie_management;
use movie_management;

create table Movie
(
    id          bigint auto_increment primary key,
    title       varchar(100) not null,
    director    varchar(100) not null,
    genre       varchar(50)  not null,
    description text,
    duration    int          not null,
    language    varchar(50)  not null
);

#procedure
-- Hiển thị tất cả phim
DELIMITER &&
create procedure findAll()
begin
select * from Movie;
end &&
DELIMITER &&

-- thêm mới phim
DELIMITER &&
create procedure addMovie(
    title_in varchar(100),
    director_in varchar(100),
    genre_in varchar(50),
    description_in text,
    duration_in int,
    language_in varchar(50)
)
begin
insert into Movie(title, director, genre, description, duration, language)
VALUES (title_in, director_in, genre_in, description_in, duration_in, language_in);
end &&
DELIMITER &&

-- tìm id
DELIMITER &&
create procedure findMovieId(id_in bigint)
begin
SELECT * from Movie where id = id_in;
end &&
DELIMITER &&

-- Cập nhật phim
DELIMITER &&
create procedure updateMovie(
    id_in bigint,
    title_in varchar(100),
    director_in varchar(100),
    genre_in varchar(50),
    description_in text,
    duration_in int,
    language_in varchar(50)
)
begin
update Movie
set title      = title_in,
    director= director_in,
    genre      = genre_in,
    description= description_in,
    duration   = duration_in,
    language   =language_in
where id= id_in;
end &&

DELIMITER &&

-- Xoá phim
DELIMITER &&
create procedure deleteMovie(id_in bigint)
begin
delete from Movie where id= id_in;
end &&
DELIMITER &&

-- Dữ liệu mẫu
INSERT INTO Movie (title, director, genre, description, duration, language)
VALUES
    ('Inception', 'Christopher Nolan', 'Sci-Fi', 'A thief who steals corporate secrets through dream-sharing technology.', 148, 'English'),

    ('Parasite', 'Bong Joon-ho', 'Thriller', 'A poor family schemes to become employed by a wealthy household.', 132, 'Korean'),

    ('Spirited Away', 'Hayao Miyazaki', 'Animation', 'A young girl enters a magical world ruled by gods, spirits, and witches.', 125, 'Japanese'),

    ('The Godfather', 'Francis Ford Coppola', 'Crime', 'The aging patriarch of an organized crime dynasty transfers control to his son.', 175, 'English'),

    ('Amélie', 'Jean-Pierre Jeunet', 'Romance', 'A whimsical depiction of contemporary Parisian life', 122, 'French');
