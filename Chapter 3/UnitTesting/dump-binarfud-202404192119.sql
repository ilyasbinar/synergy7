--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-04-19 21:19:42 WIB

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE binarfud;
--
-- TOC entry 3382 (class 1262 OID 25247)
-- Name: binarfud; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE binarfud WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';


\connect binarfud

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 124121)
-- Name: hr; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA hr;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 124122)
-- Name: karyawan; Type: TABLE; Schema: hr; Owner: -
--

CREATE TABLE hr.karyawan (
    id bigint NOT NULL,
    alamat character varying,
    created_date timestamp without time zone NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 124141)
-- Name: rekening; Type: TABLE; Schema: hr; Owner: -
--

CREATE TABLE hr.rekening (
    id bigint NOT NULL,
    rekening character varying NOT NULL,
    id_karyawan bigint NOT NULL
);


--
-- TOC entry 3375 (class 0 OID 124122)
-- Dependencies: 222
-- Data for Name: karyawan; Type: TABLE DATA; Schema: hr; Owner: -
--



--
-- TOC entry 3376 (class 0 OID 124141)
-- Dependencies: 223
-- Data for Name: rekening; Type: TABLE DATA; Schema: hr; Owner: -
--



--
-- TOC entry 3228 (class 2606 OID 124128)
-- Name: karyawan karyawan_pk; Type: CONSTRAINT; Schema: hr; Owner: -
--

ALTER TABLE ONLY hr.karyawan
    ADD CONSTRAINT karyawan_pk PRIMARY KEY (id);


--
-- TOC entry 3230 (class 2606 OID 124147)
-- Name: rekening rekening_pk; Type: CONSTRAINT; Schema: hr; Owner: -
--

ALTER TABLE ONLY hr.rekening
    ADD CONSTRAINT rekening_pk PRIMARY KEY (id);


--
-- TOC entry 3231 (class 2606 OID 124148)
-- Name: rekening rekening_karyawan_fk; Type: FK CONSTRAINT; Schema: hr; Owner: -
--

ALTER TABLE ONLY hr.rekening
    ADD CONSTRAINT rekening_karyawan_fk FOREIGN KEY (id_karyawan) REFERENCES hr.karyawan(id);


-- Completed on 2024-04-19 21:19:42 WIB

--
-- PostgreSQL database dump complete
--

