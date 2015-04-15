USE Kcal
GO
INSERT INTO Funkce(Nazev,Popis) VALUES ('Admin','Spr�vce a zam�stnanec')
INSERT INTO Funkce(Nazev,Popis) VALUES ('User','U�ivatel a z�kazn�k')

INSERT INTO Uzivatel(IDFunkce,Jmeno,Prijmeni,Email,Heslo,DatumNarozeni,Potvrzen) VALUES (1,'Petr','Weissar','p@w.pw','admin888','05-07-1934',1)
INSERT INTO Uzivatel(IDFunkce,Jmeno,Prijmeni,Email,Heslo,DatumNarozeni) VALUES (2,'Ota','Trolovic','o@t.ot','heslo123','05-07-1944')
INSERT INTO Uzivatel(IDFunkce,Jmeno,Prijmeni,Email,Heslo,DatumNarozeni) VALUES (2,'Pavel','Kmotr','p@k.pk','heslo123','05-07-1954')

INSERT INTO Jidlo(Nazev,VahaGramy,Kcal,Bilkoviny) VALUES('Ku�ec� prsn� ��zek',100,98.50,23.2)
INSERT INTO Jidlo(Nazev,VahaGramy,Kcal) VALUES('M�slo',100,654.50)

INSERT INTO Status(IDUzivatel,Vaha) VALUES (2,75.5)

INSERT INTO Jidelnicek(IDUzivatel,IDJidlo,Typ) VALUES(2,2,'Sn�dan�')
INSERT INTO Jidelnicek(IDUzivatel,IDJidlo,Typ,Poznamka) VALUES(2,1,'Ob�d','P�e�ral jsem se jak hovado')
