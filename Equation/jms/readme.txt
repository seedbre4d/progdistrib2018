- Am un furnizor si 3 tipuri de aplicatii (server, sender si receiver)
1. Modific toate bat-urile cu caile corecte: exec.bat, receiver.bat, sender.bat, server.bat 
(Inclusiv cele din JMS2/OpenMQ) - calea este la MessageQueue5.1 care trebuie downloadat
2. Se porneste serverul de mesagerie cu "startmq" din JMS2/OpenMQ si se lasa fereastra in jos
3. In Cmd din folderul JMS2/OpenMQ execut cpath
4. Execut spath
5. In Cmd din folderul equation execut javac src/*.java
6. Execut exec -> imi deschide 3 ferestre: una pt server, una pt sender si una pt receiver
7. Introduc in sender valoarea lui "n" si a topicului
8. In fereastra server vad ca a aparut un mesaj
9. In fereastra receiver introduc topic-ul si primesc raspunsul lui equation(n)
10. Inchid ferestrele in care mai ruleaza aplicatii cu CTRL+C