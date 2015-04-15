select Jmeno, Prijmeni, Cas, Typ, Nazev, Kcal
from Jidelnicek J 
LEFT OUTER JOIN Uzivatel U ON J.IDUzivatel = U.IDUzivatel
LEFT OUTER JOIN Jidlo Ji ON Ji.IDJidlo = J.IDJidlo
