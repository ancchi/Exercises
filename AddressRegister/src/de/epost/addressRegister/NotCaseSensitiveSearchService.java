package de.epost.addressRegister;


import de.epost.addressRegister.model.Address;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NotCaseSensitiveSearchService implements SearchService {


    Map<String, Address> addressMapNotSensitive;
    Address address;


    @Override
    public String searchByLastName(String lastName) {
        address = addressMapNotSensitive.get(lastName);
        return address.toString();
    }


    @Override
    public String searchByPrename(String prename) {

        Set addressSet = addressMapNotSensitive.entrySet();
        Iterator setIterator = addressSet.iterator();
        while (setIterator.hasNext()) {
            Map.Entry<String, Address> mentry = (Map.Entry) setIterator.next();
            if (mentry.getValue().getPrename().contains(prename)) {
                address = mentry.getValue();     // der String aus der Bean wird zurückgegeben
            }
        }
        return address.toString();
    }

    @Override
    public void updateDatabase(Map<String, Address> newDatabase) {  // erhält die Map schon bei der Eingabe der Daten
        // Map wird in TreeMap reingegeben
        addressMapNotSensitive = new TreeMap<String, Address>(String.CASE_INSENSITIVE_ORDER);
//        this.addressMapNotSensitive.putAll(newDatabase);
        this.addressMapNotSensitive.putAll(newDatabase);   // HashMap newDatabase wird in TreeMap addressM... gepackt
    }

}
