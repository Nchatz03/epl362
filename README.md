# epl362

This is a project for the EPL362 Computer Science Course for the University of Cyprus.

Copyright (c) 2018 EPL362 Development Team, University of Cyprus


Για τους σκοπούς αυτού του project χρησιμοποιήσαμε την τεχνολογία OSGI. Τα συστατικά στοιχεία του συστήματος διαχωρίστηκαν σε bundles.
Τα bundles μας είναι 6, 1 για κάθε viewpoint(4), ένα που υλοποιεί την επικοινωνία μεταξύ προγράμματος και βάσης δεδομένων και ένα που 
περίεχει τα mysql query  . Ο φάκελος που βρίσκεται μέσα το bundle που υλοποιεί τη δύνδεση με τη βάση είναι το DBconnection το οποίο κάνει 
export 4 services, ένα για κάθε viewpoint bundle. Κάθε service υλοποιεί μεθόδους αποκλειστικές για κάθε viewpoint. Επίσης στο package test
του DBconnection μπορείτε να βρείτε το junits όπου εχουμε μια κλαση για καθε viewpoint,οπου τρεχουν μεσω του TestRunner . Τα άλλα bundles 
είναι receptionist,  Legal Staff, Management, LegalRecordsStaff . Επίσης για να μπορεί να τρέξει το project δημιουργήσαμε ακόμη ένα bundle
(com.mysql.jdbc) το οποίο περιέχει βιβλιοθήκες και κώδικα JDBC για σύνδεση σε βάση δεδομένων MySQL, το οποίο γίνεται import από το bundle 
DBconnection που υλοποιεί τη δύνδεση στη βάση.  Για να τρέξει το πρόγραμμα πρέπει από το OSGI framework να επιλεγεί το bundle 
com.mysql.jdbc για ένωση στη βάση, το bundle DBconnection για την υλοποίηση της ένωσης στη βάση και τις λειτουργίες του κάθε viewport και
έπειτα ένα από τα 4 viewpoint bundles. 

