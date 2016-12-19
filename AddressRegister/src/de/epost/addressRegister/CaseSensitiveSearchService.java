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

    HashMap<String, Address> addressMap;
    String address = "";
    String key;

    @Override
    public String searchByLastName(String lastName) {
        address = addressMap.get(lastName).toString();
        return address;
    }

    @Override
    public String searchByPrename(String preName) {
        Set addressSet = addressMap.entrySet();
        Iterator setIterator = addressSet.iterator();
        while (setIterator.hasNext()) {
            Map.Entry<String, Address> mentry = (Map.Entry) setIterator.next();
            if (mentry.getValue().getPrename().contains(preName)) {
                address = mentry.getValue().toString();     // der String aus der Bean wird zurückgegeben
            }
        }
        return address;
    }


    public String putAllOut() {
        Set set = addressMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            key = mentry.getKey().toString();
            if(address.equals("")) {
                address = addressMap.get(mentry.getKey()).toString();
            } else {
                address += "\n" + addressMap.get(mentry.getKey()).toString();
            }
        }
        return address;
    }

    @Override
    public void updateDatabase(Map<String, Address> newDatabase) {
        this.addressMap = (HashMap)newDatabase;
    }

}
