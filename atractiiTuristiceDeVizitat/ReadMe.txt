Atractii turistice de vizitat folosind un Priority Queue

Buna. 
Scopul proiectului este de a afla cele mai apropiate K atractii fata de un punct (0,0). 
Acest proiect isi propune a citi si stoca informatiile citite din fisier intr-un priority queue.

Functionalitatile acestuia sunt:
- adaugarea unei atractii noi format: |nume coordX coordY|
- afisarea celor mai apropiate K locatii fara a disparea din lista, folosind un PriorityQueue temp;
- afisarea numarului de locatii pe care le putem parcurge in distanta maxima data de utilizator.

Cum am reusit sa evitam stergerea din lista la parcurgere?
Folosind un alt Priority Queue temp bazat pe cel folosit pt stocare pt aflarea informatiilor necesare.

Utilizare:
Modificati variabila filePath cu path-ul nou al fisierului text destinatii.txt (se afla 
in "eclipse-workspace\atractiiTuristiceDeVizitat\src\model\") 
Formatul de adaugare este |nume coordX coordY|. Fisierul text are urmatorul format:
_________________
nume coord coord
nume coord coord
nume coord coord
nume coord coord
nume coord coord
nume coord coord    
________________       <- atentie sa nu avem linii goale la final!