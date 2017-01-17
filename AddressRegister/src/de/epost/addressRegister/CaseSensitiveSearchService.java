package de.epost.addressRegister;
import de.epost.addressRegister.model.Address;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by afischer on 02/12/2016.
 */
public class CaseSensitiveSearchService implements SearchService{

    HashMap<String, Address> addressMap = new HashMap<>();  // leere Initialisierung, damit keine NullPointerexception, wenn noch kein Eintrag
    String address;
    String key;

    @Override
    public String searchByLastName(String lastName) {
        if(addressMap.get(lastName) != null) {
            address = addressMap.get(lastName).toString();
        } else {
            noEntry();
        }
            return address;

    }

    @Override
    public String searchByPrename(String preName) {
        Set addressSet = addressMap.entrySet();
        Iterator setIterator = addressSet.iterator();
        address = "";
        while (setIterator.hasNext()) {
            Map.Entry<String, Address> mentry = (Map.Entry) setIterator.next();
            //if (mentry.getValue().getPrename().contains(preName)) {
                if (mentry.getValue().getPrename().equals(preName)) {
                address = mentry.getValue().toString();     // der String aus der Bean wird zurückgegeben
            }
        }
        if (address.equals("")) {
            noEntry();
        }
        return address;
    }


    public String putAllOut() {
        Set set = addressMap.entrySet();
        Iterator iterator = set.iterator();
        address = "";
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            key = mentry.getKey().toString();
                address += "\n" + addressMap.get(mentry.getKey()).toString();
        }
        if (address.equals("")) {
            noEntry();
        }

        return address;
    }

    public void noEntry() {
        address = "Kein Eintrag vorhanden.";
    }

    @Override
    public void updateDatabase(Map<String, Address> newDatabase) {
        this.addressMap = (HashMap)newDatabase;
    }

}
