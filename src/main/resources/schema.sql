DROP TABLE IF EXISTS grade;
DROP TABLE IF EXISTS Cotisation;
CREATE table grade (
  	ID int,
	CODE varchar(10),
	NB_HEURES_BASE double,
 	TAUX_BASE double
);
CREATE table Cotisation (
  	ID int,
	CODE varchar(10),
	LIBELLE varchar(40),
	TAUX_SALARIALE double,
 	TAUX_PATRONALE double
);