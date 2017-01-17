package de.epost.addressRegister;


import de.epost.addressRegister.model.Address;


import java.util.*;

public class NotCaseSensitiveSearchService implements SearchService {


    Map<String, Address> addressMapNotSensitive = new TreeMap<String, Address>(String.CASE_INSENSITIVE_ORDER);

    String address;


    @Override
    public String searchByLastName(String lastName) {
        if(addressMapNotSensitive.get(lastName) != null) {
            address = addressMapNotSensitive.get(lastName).toString();
        } else {
            noEntry();
        }
        return address;
    }


    @Override
    public String searchByPrename(String prename) {

        Set addressSet = addressMapNotSensitive.entrySet();
        Iterator iterator = addressSet.iterator();
        address = "";
        while(iterator.hasNext()) {
            Map.Entry<String, Address> mentry = (Map.Entry) iterator.next();
            if(mentry.getValue().getPrename().toLowerCase().equals(prename.toLowerCase())) {  // kein case_insensitive, deswegen beides gleichsetzen
                address = mentry.getValue().toString();
            }
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
    public void updateDatabase(Map<String, Address> newDatabase) {  // erhält die Map schon bei der Eingabe der Daten
        this.addressMapNotSensitive.putAll(newDatabase);   // HashMap newDatabase wird in TreeMap addressM... gepackt
    }

}
