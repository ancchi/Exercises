import de.epost.addressRegister.model.Address;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by afischer on 06/12/2016.
 */
public class NotCaseSensitiveSearchServiceTest {

    HashMap<String, Address> addressMap;


    @Test
    public void testGiveAddressByLastname() {

    }




    public void twoEntriesForTheMap() {
        addressMap = new HashMap<>();
        Address address1 = new Address();
        address1.setPrename("Susanne");
        address1.setLastName("Liebig");
        addressMap.put("Liebig", address1);
        Address address2 = new Address();
        address2.setPrename("Wolfgang");
        address2.setLastName("Hansen");
        addressMap.put("Hansen", address2);
    }

}
