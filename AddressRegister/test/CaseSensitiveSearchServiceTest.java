import de.epost.addressRegister.CaseSensitiveSearchService;
import de.epost.addressRegister.model.Address;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by afischer on 02/12/2016.
 */
public class CaseSensitiveSearchServiceTest {

    HashMap<String, Address> addressMap;

//    @Test
//    public void testSearchServiceWithLastName() {
//        twoEntriesForTheMap();
//        CaseSensitiveSearchService caseSensitiveSearchService1 = new CaseSensitiveSearchService(addressMap);
//        assertEquals("Address anhand des Nachnamens nicht gefunden","Susanne Liebig", caseSensitiveSearchService1.searchByLastName("Liebig"));
//    }
//
//
//    @Test
//    public void testSearchServiceWithPreName() {
//        twoEntriesForTheMap();
//        CaseSensitiveSearchService caseSensitiveSearchService2 = new CaseSensitiveSearchService(addressMap);
//        assertEquals("Address anhand des Vornamens nicht gefunden","Wolfgang Hansen", caseSensitiveSearchService2.searchByPrename("Wolfgang"));
//    }
//
//    @Test
//    public void testPutAllOut() {
//        twoEntriesForTheMap();
//        CaseSensitiveSearchService caseSensitiveSearchService3 = new CaseSensitiveSearchService(addressMap);
//        assertEquals("Address anhand des Vornamens nicht gefunden", "Wolfgang Hansen\nSusanne Liebig",
//                caseSensitiveSearchService3.putAllOut());
//    }
//
//
//    public void twoEntriesForTheMap() {
//        addressMap = new HashMap<>();
//        Address address1 = new Address();
//        address1.setPrename("Susanne");
//        address1.setLastName("Liebig");
//        addressMap.put("Liebig", address1);
//        Address address2 = new Address();
//        address2.setPrename("Wolfgang");
//        address2.setLastName("Hansen");
//        addressMap.put("Hansen", address2);
//    }
}
