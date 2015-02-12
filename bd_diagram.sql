/*==============================================================*/
/* Table: DIAGNOSIS                                             */
/*==============================================================*/
create table DIAGNOSIS (
   ID_DIAG              SERIAL not null,
   ID_P                 INT4                 not null,
   DIAGNOSIS_ID         INT4                 null,
   DIAGNOSISTYPE        VARCHAR(200)         null,
   COMPLICATIONS        VARCHAR(300)         null,
   DIAGNOSISDATE        DATE                 null,
   constraint PK_DIAGNOSIS primary key (ID_DIAG)
);

/*==============================================================*/
/* Index: DIAGNOSIS_PK                                          */
/*==============================================================*/
create unique index DIAGNOSIS_PK on DIAGNOSIS (
ID_DIAG
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on DIAGNOSIS (
ID_P
);

/*==============================================================*/
/* Table: DOCTOR                                                */
/*==============================================================*/
create table DOCTOR (
   ID_D                 SERIAL not null,
   ID_H                 INT4                 not null,
   DOCTOR_ID            INT4                 null,
   CI                   INT4                 null,
   NAMEDOCTOR           VARCHAR(100)         null,
   SPECIALTY            VARCHAR(60)          null,
   constraint PK_DOCTOR primary key (ID_D)
);

/*==============================================================*/
/* Index: DOCTOR_PK                                             */
/*==============================================================*/
create unique index DOCTOR_PK on DOCTOR (
ID_D
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on DOCTOR (
ID_H
);

/*==============================================================*/
/* Table: DOCTORVISIT                                           */
/*==============================================================*/
create table DOCTORVISIT (
   ID_DV                SERIAL not null,
   ID_P                 INT4                 not null,
   ID_D                 INT4                 not null,
   DOCTORVISIT_ID       INT4                 null,
   VISITDATE            DATE                 null,
   constraint PK_DOCTORVISIT primary key (ID_DV)
);

/*==============================================================*/
/* Index: DOCTORVISIT_PK                                        */
/*==============================================================*/
create unique index DOCTORVISIT_PK on DOCTORVISIT (
ID_DV
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on DOCTORVISIT (
ID_D
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on DOCTORVISIT (
ID_P
);

/*==============================================================*/
/* Table: HOSPITAL                                              */
/*==============================================================*/
create table HOSPITAL (
   ID_H                 SERIAL not null,
   HOSPITAL_ID          INT4                 null,
   NAME                 VARCHAR(100)         null,
   ADDRESS              VARCHAR(200)         null,
   PHONE                NUMERIC              null,
   NUMBEROFBEDS         INT4                 null,
   constraint PK_HOSPITAL primary key (ID_H)
);

/*==============================================================*/
/* Index: HOSPITAL_PK                                           */
/*==============================================================*/
create unique index HOSPITAL_PK on HOSPITAL (
ID_H
);

/*==============================================================*/
/* Table: HOSPITALROOM                                          */
/*==============================================================*/
create table HOSPITALROOM (
   ID_R                 SERIAL not null,
   ID_H                 INT4                 not null,
   ROOM_ID              INT4                 null,
   NAMEROOM             VARCHAR(200)         null,
   NUMBEROFBEDS         INT4                 null,
   constraint PK_HOSPITALROOM primary key (ID_R)
);

/*==============================================================*/
/* Index: HOSPITALROOM_PK                                       */
/*==============================================================*/
create unique index HOSPITALROOM_PK on HOSPITALROOM (
ID_R
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on HOSPITALROOM (
ID_H
);

/*==============================================================*/
/* Table: LAB                                                   */
/*==============================================================*/
create table LAB (
   ID_L                 SERIAL not null,
   LAB_ID               INT4                 null,
   NAME_LAB             VARCHAR(150)         null,
   ADDRESS_LAB          VARCHAR(150)         null,
   PHONE_LAB            INT4                 null,
   constraint PK_LAB primary key (ID_L)
);

/*==============================================================*/
/* Index: LAB_PK                                                */
/*==============================================================*/
create unique index LAB_PK on LAB (
ID_L
);

/*==============================================================*/
/* Table: LABTEST                                               */
/*==============================================================*/
create table LABTEST (
   ID_LT                SERIAL not null,
   ID_H                 INT4                 not null,
   ID_L                 INT4                 not null,
   LABTEST_ID           INT4                 null,
   SERVICEDESCRIPTION   VARCHAR(200)         null,
   TESTDATE             DATE                 null,
   constraint PK_LABTEST primary key (ID_LT)
);

/*==============================================================*/
/* Index: LABTEST_PK                                            */
/*==============================================================*/
create unique index LABTEST_PK on LABTEST (
ID_LT
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on LABTEST (
ID_L
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on LABTEST (
ID_H
);

/*==============================================================*/
/* Table: PATIENT                                               */
/*==============================================================*/
create table PATIENT (
   ID_P                 SERIAL not null,
   ID_R                 INT4                 null,
   PATIENT_ID           INT4                 null,
   CI                   INT4                 null,
   REGISTRATIONNUMBER   INT4                 null,
   NAME                 VARCHAR(100)         null,
   BEDNUMBER            INT4                 null,
   ADDRESS              VARCHAR(200)         null,
   DATEOFBIRTH          DATE                 null,
   SEX                  CHAR(1)              null,
   constraint PK_PATIENT primary key (ID_P)
);

/*==============================================================*/
/* Index: PATIENT_PK                                            */
/*==============================================================*/
create unique index PATIENT_PK on PATIENT (
ID_P
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on PATIENT (
ID_R
);

alter table DIAGNOSIS
   add constraint FK_DIAGNOSI_RELATIONS_PATIENT foreign key (ID_P)
      references PATIENT (ID_P)
      on delete restrict on update restrict;

alter table DOCTOR
   add constraint FK_DOCTOR_RELATIONS_HOSPITAL foreign key (ID_H)
      references HOSPITAL (ID_H)
      on delete restrict on update restrict;

alter table DOCTORVISIT
   add constraint FK_DOCTORVI_RELATIONS_DOCTOR foreign key (ID_D)
      references DOCTOR (ID_D)
      on delete restrict on update restrict;

alter table DOCTORVISIT
   add constraint FK_DOCTORVI_RELATIONS_PATIENT foreign key (ID_P)
      references PATIENT (ID_P)
      on delete restrict on update restrict;

alter table HOSPITALROOM
   add constraint FK_HOSPITAL_RELATIONS_HOSPITAL foreign key (ID_H)
      references HOSPITAL (ID_H)
      on delete restrict on update restrict;

alter table LABTEST
   add constraint FK_LABTEST_RELATIONS_LAB foreign key (ID_L)
      references LAB (ID_L)
      on delete restrict on update restrict;

alter table LABTEST
   add constraint FK_LABTEST_RELATIONS_HOSPITAL foreign key (ID_H)
      references HOSPITAL (ID_H)
      on delete restrict on update restrict;

alter table PATIENT
   add constraint FK_PATIENT_RELATIONS_HOSPITAL foreign key (ID_R)
      references HOSPITALROOM (ID_R)
      on delete restrict on update restrict;
