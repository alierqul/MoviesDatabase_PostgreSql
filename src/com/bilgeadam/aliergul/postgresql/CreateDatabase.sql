--CREATE DATABASE "MarathonMovies"
--    WITH 
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_CTYPE = 'Turkish_Turkey.1254'
--    CONNECTION LIMIT = -1;
  
    -- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.

BEGIN;

CREATE TABLE IF NOT EXISTS public.movies
(
    "movieid" integer NOT NULL,
    title character varying,
    genres character varying,
    PRIMARY KEY ("movieid")
);

CREATE TABLE IF NOT EXISTS public.tags
(
    "userid" integer,
    "movieid" integer,
    tag character varying,
    "timestamp" bigint
);

CREATE TABLE IF NOT EXISTS public.ratings
(
    "userid" integer,
    "movieid" integer,
    rating real,
    "timestamp" bigint
);

CREATE TABLE IF NOT EXISTS public.links
(
    "movieid" integer,
    "imdbid" integer,
    "tmdbid" integer
);

ALTER TABLE public.ratings
    ADD FOREIGN KEY ("movieid")
    REFERENCES public.movies ("movieid")
    NOT VALID;


ALTER TABLE public.tags
    ADD FOREIGN KEY ("movieid")
    REFERENCES public.movies ("movieid")
    NOT VALID;


ALTER TABLE public.links
    ADD FOREIGN KEY ("movieid")
    REFERENCES public.movies ("movieid")
    NOT VALID;
commit;
END;