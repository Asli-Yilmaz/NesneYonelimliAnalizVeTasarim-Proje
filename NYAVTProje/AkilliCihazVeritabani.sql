--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.1

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: HesapBilgileri; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."HesapBilgileri" (
    "kullaniciAdi" character varying(50) NOT NULL,
    sifre integer NOT NULL
);


ALTER TABLE public."HesapBilgileri" OWNER TO postgres;

--
-- Data for Name: HesapBilgileri; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."HesapBilgileri" VALUES
	('AhmetA.', 4321),
	('MehmetD.', 1234),
	('ZeynepK.', 4765),
	('Ademkaplan', 9999),
	('AsliYilmaz', 1111);


--
-- Name: HesapBilgileri unique_HesapBilgileri_KullaniciAdi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."HesapBilgileri"
    ADD CONSTRAINT "unique_HesapBilgileri_KullaniciAdi" UNIQUE ("kullaniciAdi");


--
-- PostgreSQL database dump complete
--

