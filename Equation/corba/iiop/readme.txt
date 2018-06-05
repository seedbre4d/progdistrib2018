CORBA-RMI/IIOP(Internet Inter Orb Protocol) - JAVA 9 ONLY

1. Copiem MyAnt.bat in folderele i, s si c
2. Configuram fisierele MyAnt.bat
3. Din "i" executam in cmd MyAnt Compile
4. Din "s" executam in cmd MyAnt Compile
5. Din "s" executam in cmd MyAnt Orb pt a porni serviciul CORBA si lasam fereastra deoparte
6. Din "s" executam intr-o alta fereastra cmd MyAnt Server pt a porni serverul si lasam fereastra jos
7. Din "c" executam in cmd MyAnt Compile
8. Din "c" executam in cmd - in loc de MyAnt Run pt ca nu merge - prima linie din readme.txt pentru a 
porni aplicatia client, si anume "java --add-modules java.corba -cp mods equation.iiop.c.EquationClient"
9. Inchidem ferestrele server si orb cu CTRL+C