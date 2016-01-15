--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.0
-- Started on 2016-01-15 09:52:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2013 (class 1262 OID 16393)
-- Name: aws; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE aws WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE aws OWNER TO postgres;

\connect aws

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 175 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2016 (class 0 OID 0)
-- Dependencies: 175
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 16410)
-- Name: bookings; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bookings (
    id integer NOT NULL,
    room integer,
    "user" integer,
    start date NOT NULL,
    "end" date NOT NULL
);


ALTER TABLE bookings OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16402)
-- Name: rooms; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rooms (
    nr integer NOT NULL,
    guests integer NOT NULL,
    description text,
    price double precision
);


ALTER TABLE rooms OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16394)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id bigint NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    card_nb text,
    first_name text NOT NULL,
    last_name text NOT NULL,
    address text NOT NULL,
    city text NOT NULL,
    country text NOT NULL,
    is_admin boolean NOT NULL,
    phone text
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 2008 (class 0 OID 16410)
-- Dependencies: 174
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO bookings (id, room, "user", start, "end") VALUES (1, 101, 1, '2016-02-13', '2016-02-16');
INSERT INTO bookings (id, room, "user", start, "end") VALUES (2, 101, 2, '2016-02-01', '2016-02-05');


--
-- TOC entry 2007 (class 0 OID 16402)
-- Dependencies: 173
-- Data for Name: rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO rooms (nr, guests, description, price) VALUES (101, 2, 'first floor room with private bathroom', 30);
INSERT INTO rooms (nr, guests, description, price) VALUES (102, 4, 'first floor apartment with private bathroom and kitchen', 50);
INSERT INTO rooms (nr, guests, description, price) VALUES (201, 2, 'second floor room with garden view and private bathroom', 35);
INSERT INTO rooms (nr, guests, description, price) VALUES (202, 2, 'second floor room with two sigle beds and private bathroom', 30);
INSERT INTO rooms (nr, guests, description, price) VALUES (203, 2, 'second floor room with private bathroom', 30);
INSERT INTO rooms (nr, guests, description, price) VALUES (301, 4, 'third floor apartment with two bedrooms and private bathroom', 60);


--
-- TOC entry 2006 (class 0 OID 16394)
-- Dependencies: 172
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (1, 'user1@aws.com', 'password', '1234', 'John', 'Doe', 'bla bla', 'Timisoara', 'Romania', false, '0765789');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (2, 'user2@aws.com', 'password', '3456', 'Jane', 'Doe', 'blabla', 'Arad', 'Romania', false, '0756432167');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (3, 'user3@aws.com', 'password', '4324235', 'John', 'Snow', 'RAmbla', 'BArcelona', 'Spania', false, '067545456');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (4, 'user4@aws.com', 'pass', '43432554', 'Bla', 'BLA', 'bla', 'Rome', 'Italy', false, 'fdfsdfsf');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (1452781359667, 'abc@yahoo.com', 'test', '54534', 'Cristina', 'Sirbu', 'bla', 'Timisoara', 'Romania', false, '54353');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (1452781724239, 'miamiau@yahoo.com', 'test', '54534', 'Teodora', 'Cosma', 'Manhattan', 'New York', 'USA', false, '5535345');
INSERT INTO users (id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone) VALUES (1452789119366, 'monica@yahoo.com', 'test', '343423', 'Monica', 'Vasile', 'aaa', 'Timisoara', 'Romania', false, '434324');


--
-- TOC entry 1894 (class 2606 OID 16414)
-- Name: bookingpk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT bookingpk PRIMARY KEY (id);


--
-- TOC entry 1892 (class 2606 OID 16409)
-- Name: roompk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rooms
    ADD CONSTRAINT roompk PRIMARY KEY (nr);


--
-- TOC entry 1890 (class 2606 OID 24577)
-- Name: userpk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT userpk PRIMARY KEY (id);


--
-- TOC entry 1895 (class 2606 OID 16415)
-- Name: firstfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT firstfk FOREIGN KEY (room) REFERENCES rooms(nr);


--
-- TOC entry 1896 (class 2606 OID 24578)
-- Name: secondfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT secondfk FOREIGN KEY ("user") REFERENCES users(id);


--
-- TOC entry 2015 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-01-15 09:52:52

--
-- PostgreSQL database dump complete
--

