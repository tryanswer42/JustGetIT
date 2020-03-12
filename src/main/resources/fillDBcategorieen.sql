LOCK TABLES `categorieen` WRITE;
INSERT INTO `categorieen` (naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    ('boeken',NULL,0,1,10.00),
    ('CD\'s',NULL,0,1,10.00),
    ('elektronische toestellen',NULL,0,1,10.00),
    ('kleding',NULL,0,1,10.00);
select id from categorieen where naam='boeken' into @parent;
INSERT INTO `categorieen` (naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    ('Fictie',@parent,1,1,10.00),
    ('Geschiedenis & Politiek',@parent,1,1,10.00),
    ('Mens & Maatschappij',@parent,1,1,10.00),
    ('Economie & Management',@parent,1,1,10.00);
select id from categorieen where naam='CD\'s' into @parent;
INSERT INTO `categorieen` (naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    ('Pop',@parent,1,1,10.00),
    ('Jazz',@parent,1,1,10.00),
    ('Rock',@parent,1,1,10.00),
    ('Opera',@parent,1,1,10.00);
select id from categorieen where naam='elektronische toestellen' into @parent;
INSERT INTO `categorieen` (naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    ('Strijkijzers',@parent,1,1,10.00),
    ('Vaatwassers',@parent,1,1,10.00),
    ('Koelkasten',@parent,1,1,10.00),
    ('Diepvriezers',@parent,1,1,10.00);
select id from categorieen where naam='kleding' into @parent;
INSERT INTO `categorieen` (naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    ('Herenkleding',@parent,1,1,10.00),
    ('Jongenskleding',@parent,1,1,10.00),
    ('Dameskleding',@parent,1,1,10.00),
    ('Meisjeskleding',@parent,0,1,10.00);
UNLOCK TABLES;

select * from categorieen;
