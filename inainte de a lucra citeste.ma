27032018 2225 explicatii
in model gasiti clasele care mapeaza informatia despre tabelele din baza de date
in dao sunt clasele care tin selecturile si metodele cu care sunt aduse obiecte din baza de date
in controller am pus:
-objectservice care tine metode care leaga room de appointment
-webcontroller care tine metode care mapeaza datele din baza de pagini ale aplicatiei

26032018 1735
appointment si room din model au fost comentate si am pus in ele cam ce am reusit sa gasesc pe net
ca fiind necesar pentru clase model/entity
next step: de refacut elementele din pachetul DAO

26032018 1410

acum controller are metode REST dar sunt doar de test. pasii urmatori sunt:
curat controller astfel incat sa ramana strict pentru management-ul obiectelor
sa fac webcontroller pentru REST
sa finalizez elementele din pachetul DAO: interfete si clase pentru ambele modele care sa contina toate functiile pentru modificarile pe db
sa fac o interfata html simpla

26032018 840

cred ca am inteles: fiindca appointment este declarata ca fiind tabela si pun in ea si Room si RoomDaoImpl,
 hibernate incearca sa lege aceste proprietati de coloane din tabela si nu stie care cu cine.
presupun ca legatura dintre Appointment si Room trebuie sa stea intr-un layer suplimentar
trebuie sa ma gandesc cum implementez asta.
cred ca o sa o pun in controller. iar pentru REST o sa fac un webcontroller

26032018 830

teoretic, nevoia de mai sus e usor de facut. dar fiindca selectul pe baza e facut in RoomDaoImpl nu reusesc sa fac o legatura intre
RoomDaoImpl si Room
o sa incerc sa mut selectul pe baza direct in Appointment

24032018 1400

vreau ca atunci cand afisez un obiect de tip appointment, in loc de room id sa aduc room name
in consecinta, roomid va deveni room de tip Room si
getroomid va intoarce un obiect de tip room pe baza id-ului
si in tostring pun getroom().roomname()








