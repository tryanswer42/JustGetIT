insert into categorieen (naam, isSubcategorie, winstmargeType, winstmarge)
VALUES ('testParent', 1, 1, 10);
insert into categorieen (naam, parentCategorie, isSubcategorie, winstmargeType, winstmarge)
VALUES ('testSub', (select id from categorieen where naam= 'testParent'), 0, 1, 10);

