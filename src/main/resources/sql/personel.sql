/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/10/10 22:10:13                          */
/*==============================================================*/

CREATE DATABASE personel_db default character set = 'utf8';

use personel_db;

drop table if exists Admin;

drop table if exists DepartTransfer;

drop table if exists Department;

drop table if exists Dimission;

drop table if exists Post;

drop table if exists PostTransfer;

drop table if exists Staff;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   adminId              char(20) not null,
   adminName            char(20) not null,
   adminPWord           char(20) not null,
   primary key (adminId)
);

/*==============================================================*/
/* Table: DepartTransfer                                        */
/*==============================================================*/
create table DepartTransfer
(
   deTrId               int not null auto_increment,
   staffId              int,
   newDepart            char(20) not null,
   oldDepart            char(20) not null,
   deType               char(20) not null,
   deReson              char(50) not null,
   deRemark             text,
   deDate               date not null,
   primary key (deTrId)
);

/*==============================================================*/
/* Table: Department                                            */
/*==============================================================*/
create table Department
(
   deId                 int not null,
   deName               char(20) not null,
   primary key (deId)
);

/*==============================================================*/
/* Table: Dimission                                             */
/*==============================================================*/
create table Dimission
(
   dimId                int not null auto_increment,
   staffId              int,
   dimDate              date not null,
   dimType              char(20) not null,
   dimDirection         char(50),
   dimRemark            text,
   primary key (dimId)
);

/*==============================================================*/
/* Table: Post                                                  */
/*==============================================================*/
create table Post
(
   poId                 int not null,
   deId                 int,
   poName               char(20) not null,
   primary key (poId)
);

/*==============================================================*/
/* Table: PostTransfer                                          */
/*==============================================================*/
create table PostTransfer
(
   poTrId               int not null auto_increment,
   staffId              int,
   newPost              char(20) not null,
   oldPost              char(20) not null,
   poType               char(20) not null,
   poReson              char(50) not null,
   poRemark             text,
   poDate               date not null,
   primary key (poTrId)
);

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
create table Staff
(
   staffId              int not null,
   poId                 int,
   staffname            char(20) not null,
   sex                  bool not null,
   birthday             date not null,
   idCard               char(20) not null,
   inDay                date not null,
   workDay              date not null,
   workType             char(20) not null,
   source               char(20) not null,
   political            char(20),
   nation               char(20),
   nativePlace          char(20),
   phone                char(20),
   email                char(20),
   height               int,
   bloodType            char(20),
   marital              char(20),
   birthPlace           char(50),
   huKou                char(50),
   education            char(20),
   degree               char(20),
   college              char(50),
   major                char(50),
   graduationDate       date,
   primary key (staffId)
);

alter table DepartTransfer add constraint FK_departTransfer foreign key (staffId)
      references Staff (staffId) on delete restrict on update restrict;

alter table Dimission add constraint FK_staffLeave foreign key (staffId)
      references Staff (staffId) on delete restrict on update restrict;

alter table Post add constraint FK_departmentPost foreign key (deId)
      references Department (deId) on delete restrict on update restrict;

alter table PostTransfer add constraint FK_postTransfer foreign key (staffId)
      references Staff (staffId) on delete restrict on update restrict;

alter table Staff add constraint FK_postStaff foreign key (poId)
      references Post (poId) on delete restrict on update restrict;

