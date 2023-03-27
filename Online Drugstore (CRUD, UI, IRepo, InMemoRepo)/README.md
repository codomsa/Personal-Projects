# Farmacie online

Fiecare student își alege o problemă. Folosiți arhitectură stratificată cu domain, UI, service, repository. Tema se întinde pe 3 săptămâni (3 iterații).

1. Prima iterație (săptămâna 3): toate funcționalitățile CRUD, interfață de consolă, excepții. 
2. A doua iterație (săptămâna 4): minim 2 funcționalități non-CRUD, repository generic.
3. A treia iterație (săptămâna 5): toate funcționalitățile, test coverage de minim 90%, validări folosind clase proprii de excepții.  

---

1. **Farmacie Online**   
    1.1. CRUD medicament: id, nume, producător, preț, necesită rețetă. Prețul să fie strict pozitiv.  
    1.2. CRUD card client: id, nume, prenume, CNP, data nașterii (`dd.mm.yyyy`), data înregistrării (`dd.mm.yyyy`). CNP-ul trebuie să fie unic.  
    1.3. CRUD tranzacție:  id, id_medicament, id_card_client (poate fi nul), nr_bucăți, data și ora (`dd.mm.yyyy HH:mm`). Dacă există un card client, atunci aplicați o reducere de `10%` dacă medicamentul nu necesită rețetă și de `15%` dacă necesită. Se tipărește prețul plătit și reducerile acordate.  
    1.4. Căutare medicamente și clienți. Căutare full text.  
    1.5. Afișarea tuturor tranzacțiilor dintr-un interval de zile dat.  
    1.6. Afișarea medicamentelor ordonate descrescător după numărul de vânzări.  
    1.7. Afișarea cardurilor client ordonate descrescător după valoarea reducerilor obținute.  
    1.8. Ștergerea tuturor tranzacțiilor dintr-un anumit interval de zile.  
    1.9. Scumpirea cu un procentaj dat a tuturor medicamentelor cu prețul mai mic decât o valoare dată.  
