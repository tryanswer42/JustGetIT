LOCK TABLES `categorieen` WRITE;
/*!40000 ALTER TABLE `categorieen` DISABLE KEYS */;
INSERT INTO `categorieen` (id, naam, parentId, isSubCategorie, winstmargeIsPercentage, winstMarge) VALUES
    (4,'boeken',NULL,0,1,10.00,1),
    (5,'CD\'s',NULL,0,1,10.00,1),
    (6,'elektronische toestellen',NULL,0,1,10.00,1),
    (7,'kleding',NULL,0,1,10.00,1),
    (8,'Fictie',4,1,1,10.00),
    (12,'Geschiedenis & Politiek',4,1,1,10.00),
    (13,'Mens & Maatschappij',4,1,1,10.00),
    (14,'Economie & Management',4,1,1,10.00),
    (9,'Pop',5,1,1,10.00),
    (15,'Jazz',5,1,1,10.00),
    (16,'Rock',5,1,1,10.00),
    (17,'Opera',5,1,1,10.00),
    (10,'Strijkijzers',6,1,1,10.00),
    (18,'Vaatwassers',6,1,1,10.00),
    (19,'Koelkasten',6,1,1,10.00),
    (20,'Diepvriezers',6,1,1,10.00),
    (11,'Herenkleding',7,1,1,10.00),
    (21,'Jongenskleding',7,1,1,10.00),
    (22,'Dameskleding',7,1,1,10.00),
    (23,'Meisjeskleding',7,0,1,10.00);
/*!40000 ALTER TABLE `categorieen` ENABLE KEYS */;
UNLOCK TABLES;
