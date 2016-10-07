CREATE TABLE Mapa (
  MapNombre VARCHAR(50)  NOT NULL  ,
  Nivel INTEGER(10)    ,
  Ancho INTEGER(10)    ,
  Largo INTEGER(10)      ,
PRIMARY KEY(MapNombre));



CREATE TABLE Jugador (
  Nombre VARCHAR(20)  NOT NULL  ,
  Contraseña VARCHAR(20)    ,
  FchCreacion DATE    ,
  FchUltAcceso DATE      ,
PRIMARY KEY(Nombre));



CREATE TABLE Nivel (
  Nivel INTEGER(10)  NOT NULL  ,
  ExperienciaMaxima INTEGER(10)      ,
PRIMARY KEY(Nivel));



CREATE TABLE TipoNPC (
  IdTipoNPC INTEGER(10)  NOT NULL  ,
  TipoNPCNombre VARCHAR(20)  NOT NULL    ,
PRIMARY KEY(IdTipoNPC));



CREATE TABLE Raza (
  idRaza INTEGER(10)  NOT NULL  ,
  Nombre VARCHAR(20)    ,
  Descripcion VARCHAR(20)    ,
  PorcAumentoSalud INTEGER(10)      ,
PRIMARY KEY(idRaza));



CREATE TABLE Item (
  idItem INTEGER(10)  NOT NULL  ,
  Nombre VARCHAR(50)    ,
  Descripcion VARCHAR(200)    ,
  BonusFuerzaEsPorc INTEGER(1000)    ,
  BonusFuerzaNum INTEGER(10)    ,
  BonusFuerzaPorc INTEGER(10)      ,
PRIMARY KEY(idItem));



CREATE TABLE NPC (
  NPCNombre VARCHAR(20)  NOT NULL  ,
  Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  TipoNPC_IdTipoNPC INTEGER(10)  NOT NULL  ,
  Nivel INTEGER(10)    ,
  ExpBaseQueOtorga INTEGER(10)    ,
  SaludTotal INTEGER(10)    ,
  SaludActual INTEGER(10)    ,
  UbicacionX INTEGER(10)    ,
  UbicacionY INTEGER(10)    ,
  EsPasivo BIT    ,
  FchRespawneo DATE    ,
  FchMuerte DATE    ,
  SegsRespawneo INTEGER(10)      ,
PRIMARY KEY(NPCNombre, Mapa_MapNombre, TipoNPC_IdTipoNPC)  ,
  FOREIGN KEY(Mapa_MapNombre)
    REFERENCES Mapa(MapNombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(TipoNPC_IdTipoNPC)
    REFERENCES TipoNPC(IdTipoNPC)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX NPC_FKIndex1 ON NPC (Mapa_MapNombre);



CREATE TABLE ItemPorNPC (
  Item_idItem INTEGER(10)  NOT NULL  ,
  NPC_NPCNombre VARCHAR(20)  NOT NULL  ,
  NPC_Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  NPC_TipoNPC_IdTipoNPC INTEGER(10)  NOT NULL  ,
  IdItemPorNPC INTEGER(10)  NOT NULL  ,
  ProbabilidadDropeo INTEGER(10)      ,
PRIMARY KEY(Item_idItem, NPC_NPCNombre, NPC_Mapa_MapNombre, NPC_TipoNPC_IdTipoNPC, IdItemPorNPC)    ,
  FOREIGN KEY(Item_idItem)
    REFERENCES Item(idItem)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(NPC_NPCNombre, NPC_Mapa_MapNombre, NPC_TipoNPC_IdTipoNPC)
    REFERENCES NPC(NPCNombre, Mapa_MapNombre, TipoNPC_IdTipoNPC)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX ItemPorNPC_FKIndex1 ON ItemPorNPC (Item_idItem);
CREATE INDEX ItemPorNPC_FKIndex2 ON ItemPorNPC (NPC_NPCNombre, NPC_Mapa_MapNombre, NPC_TipoNPC_IdTipoNPC);



CREATE TABLE Personaje (
  PerNombre VARCHAR(20)  NOT NULL  ,
  Nivel_Nivel INTEGER(10)  NOT NULL  ,
  Raza_idRaza INTEGER(10)  NOT NULL  ,
  Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  Jugador_Nombre VARCHAR(20)  NOT NULL  ,
  Experiencia INTEGER(10)    ,
  UbicacionX INTEGER(10)    ,
  UbicacionY INTEGER(10)    ,
  SaludTotal INTEGER(10)    ,
  EnergiaTotal INTEGER(10)    ,
  EnergiaActual INTEGER(10)    ,
  ManaTotal INTEGER(10)    ,
  ManaActual INTEGER(10)    ,
  Fuerza INTEGER(10)    ,
  Destreza INTEGER(10)    ,
  Inteligencia INTEGER(10)    ,
  FchCreacion DATE      ,
PRIMARY KEY(PerNombre, Nivel_Nivel, Raza_idRaza, Mapa_MapNombre, Jugador_Nombre)        ,
  FOREIGN KEY(Nivel_Nivel)
    REFERENCES Nivel(Nivel)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Jugador_Nombre)
    REFERENCES Jugador(Nombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Mapa_MapNombre)
    REFERENCES Mapa(MapNombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Raza_idRaza)
    REFERENCES Raza(idRaza)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX Personaje_FKIndex1 ON Personaje (Nivel_Nivel);
CREATE INDEX Personaje_FKIndex2 ON Personaje (Jugador_Nombre);
CREATE INDEX Personaje_FKIndex3 ON Personaje (Mapa_MapNombre);
CREATE INDEX Personaje_FKIndex4 ON Personaje (Raza_idRaza);



CREATE TABLE Casta (
  idCasta INTEGER(10)  NOT NULL  ,
  Personaje_Raza_idRaza INTEGER(10)  NOT NULL  ,
  Personaje_Nivel_Nivel INTEGER(10)  NOT NULL  ,
  Personaje_PerNombre VARCHAR(20)  NOT NULL  ,
  Personaje_Jugador_Nombre VARCHAR(20)  NOT NULL  ,
  Personaje_Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  Nombre VARCHAR(20)    ,
  Descripcion VARCHAR(200)  NOT NULL    ,
PRIMARY KEY(idCasta, Personaje_Raza_idRaza, Personaje_Nivel_Nivel, Personaje_PerNombre, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre)  ,
  FOREIGN KEY(Personaje_PerNombre, Personaje_Nivel_Nivel, Personaje_Raza_idRaza, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre)
    REFERENCES Personaje(PerNombre, Nivel_Nivel, Raza_idRaza, Jugador_Nombre, Mapa_MapNombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX Casta_FKIndex1 ON Casta (Personaje_PerNombre, Personaje_Nivel_Nivel, Personaje_Raza_idRaza, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre);



CREATE TABLE ItemPorPersonaje (
  Personaje_Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  Personaje_Jugador_Nombre VARCHAR(20)  NOT NULL  ,
  Personaje_Raza_idRaza INTEGER(10)  NOT NULL  ,
  Personaje_Nivel_Nivel INTEGER(10)  NOT NULL  ,
  Personaje_PerNombre VARCHAR(20)  NOT NULL  ,
  Item_idItem INTEGER(10)  NOT NULL    ,
PRIMARY KEY(Personaje_Mapa_MapNombre, Personaje_Jugador_Nombre, Personaje_Raza_idRaza, Personaje_Nivel_Nivel, Personaje_PerNombre, Item_idItem)    ,
  FOREIGN KEY(Personaje_PerNombre, Personaje_Nivel_Nivel, Personaje_Raza_idRaza, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre)
    REFERENCES Personaje(PerNombre, Nivel_Nivel, Raza_idRaza, Jugador_Nombre, Mapa_MapNombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Item_idItem)
    REFERENCES Item(idItem)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX ItemPorPersonaje_FKIndex1 ON ItemPorPersonaje (Personaje_PerNombre, Personaje_Nivel_Nivel, Personaje_Raza_idRaza, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre);
CREATE INDEX ItemPorPersonaje_FKIndex2 ON ItemPorPersonaje (Item_idItem);



CREATE TABLE Habilidad (
  idHabilidad INTEGER(10)  NOT NULL  ,
  Casta_Personaje_Mapa_MapNombre VARCHAR(50)  NOT NULL  ,
  Casta_Personaje_Jugador_Nombre VARCHAR(20)  NOT NULL  ,
  Casta_Personaje_PerNombre VARCHAR(20)  NOT NULL  ,
  Casta_Personaje_Nivel_Nivel INTEGER(10)  NOT NULL  ,
  Casta_Personaje_Raza_idRaza INTEGER(10)  NOT NULL  ,
  Casta_idCasta INTEGER(10)  NOT NULL  ,
  Nombre VARCHAR(20)    ,
  Descripcion VARCHAR(200)    ,
  NivelMinimo INTEGER(10)    ,
  CantDaño INTEGER(10)    ,
  CantSanacion INTEGER(10)      ,
PRIMARY KEY(idHabilidad, Casta_Personaje_Mapa_MapNombre, Casta_Personaje_Jugador_Nombre, Casta_Personaje_PerNombre, Casta_Personaje_Nivel_Nivel, Casta_Personaje_Raza_idRaza, Casta_idCasta)  ,
  FOREIGN KEY(Casta_idCasta, Casta_Personaje_Raza_idRaza, Casta_Personaje_Nivel_Nivel, Casta_Personaje_PerNombre, Casta_Personaje_Jugador_Nombre, Casta_Personaje_Mapa_MapNombre)
    REFERENCES Casta(idCasta, Personaje_Raza_idRaza, Personaje_Nivel_Nivel, Personaje_PerNombre, Personaje_Jugador_Nombre, Personaje_Mapa_MapNombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE INDEX Habilidad_FKIndex1 ON Habilidad (Casta_idCasta, Casta_Personaje_Raza_idRaza, Casta_Personaje_Nivel_Nivel, Casta_Personaje_PerNombre, Casta_Personaje_Jugador_Nombre, Casta_Personaje_Mapa_MapNombre);




