LOCK TABLES `producten` WRITE, categorieen READ;
/*!40000 ALTER TABLE `producten` DISABLE KEYS */;
select id from categorieen where naam='Fictie' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Duin Messias',20,30,@parent,20,1),
    ('God-Keizer op Duin',20,30,@parent,20,1),
    ('Duin',20,30,@parent,20,1),
    ('Kinderen van Duin',20,30,@parent,20,1),
    ('Duin kapitel',20,30,@parent,20,1),
    ('Ketters van Duin',20,30,@parent,20,1),
    ('Hitchhikers guide to the galaxy',20,30,@parent,20,1);
select id from categorieen where naam='Mens & Maatschappij' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Frans voor beginners',20,30,@parent,20,1);
select id from categorieen where naam='Geschiedenis & Politiek' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('1500-1599',20,30,@parent,20,1),
    ('1600-1699',20,30,@parent,20,1),
    ('1700-1799',20,30,@parent,20,1);
select id from categorieen where naam='Rock' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Slippery when wet',20,30,@parent,20,1);
select id from categorieen where naam='Opera' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('De Notenkraker',20,30,@parent,20,1);
select id from categorieen where naam='Pop' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Bat out of Hell',20,30,@parent,20,1),
    ('Abba greatest hits I',20,30,@parent,20,1),
    ('Abba greatest hits II',20,30,@parent,20,1);
select id from categorieen where naam='Herenkleding' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Boxer shorts big size',20,30,@parent,20,1),
    ('Heren funny socks',20,30,@parent,20,1),
    ('Overhemd blok 2568',20,30,@parent,20,1);
select id from categorieen where naam='Dameskleding' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Lingerie rode kant C',20,30,@parent,20,1),
    ('Rok bloem lang',20,30,@parent,20,1),
    ('Jurk bruids wit',20,30,@parent,20,1);
select id from categorieen where naam='Koelkasten' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Miele superkoel B12',20,30,@parent,20,1),
    ('Miele superkoel B11',20,30,@parent,20,1),
    ('Miele superkoel B10',20,30,@parent,20,1);
select id from categorieen where naam='Vaatwassers' into @parent;
INSERT INTO `producten` (naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelHoeveelheid) VALUES
    ('Miele Eco vaat 5',20,30,@parent,20,1),
    ('Miele Eco vaat 6',20,30,@parent,20,1),
    ('Miele Eco vaat 7',20,30,@parent,20,1),
    ('Miele Eco vaat 8',20,30,@parent,20,1),
    ('Miele Eco vaat 9',20,30,@parent,20,1);

/*!40000 ALTER TABLE `producten` ENABLE KEYS */;
UNLOCK TABLES;
