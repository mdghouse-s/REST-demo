--------------------------------------------------------
--  DDL for Table MOVIES
--------------------------------------------------------

  CREATE TABLE "MOVIES" 
   (	"MOVIE_ID" NUMBER(5,0), 
	"TITLE" VARCHAR2(40 CHAR), 
	"GENRE" VARCHAR2(20), 
	"LANGUAGE" VARCHAR2(20), 
	"RELEASE_YEAR" NUMBER(4,0)
   ) ;
REM INSERTING into MOVIES
SET DEFINE OFF;
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (103,'Antman and the Wasp','fiction','English',2018);
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (104,'Ferdinand','Animation','English',2017);
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (105,'Newton','Comedy','Hindi',2017);
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (106,'Golmaal Again','Comedy','Hindi',2017);
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (107,'Bahubali 2','Fiction','Hindi',2017);
Insert into MOVIES (MOVIE_ID,TITLE,GENRE,LANGUAGE,RELEASE_YEAR) values (108,'Hitchki','drama','Hindi',2018);
--------------------------------------------------------
--  DDL for Index MOVIES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MOVIES_PK" ON "MOVIES" ("MOVIE_ID") 
  ;
--------------------------------------------------------
--  Constraints for Table MOVIES
--------------------------------------------------------

  ALTER TABLE "MOVIES" ADD CONSTRAINT "MOVIES_PK" PRIMARY KEY ("MOVIE_ID") ENABLE;
  ALTER TABLE "MOVIES" MODIFY ("MOVIE_ID" NOT NULL ENABLE);
  
  --------------------------------------------------------
--  File created - Tuesday-September-11-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence MOVIE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MOVIE_SEQ"  MINVALUE 200 MAXVALUE 9999 INCREMENT BY 1 START WITH 200 NOCACHE  NOORDER  NOCYCLE ;
