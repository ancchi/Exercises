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

    // gefüllte Map


    @Test
    public void testSearchServiceWithPreName() {
        twoEntriesForTheMap();
        CaseSensitiveSearchService caseSensitiveSearchService2 = new CaseSensitiveSearchService();
        caseSensitiveSearchService2.updateDatabase(addressMap);
        // assertEquals("eigene Message nur innerhalb des Tests", "Erwartetes Ergebnis", "Wirkliches Ergebnis")
        assertEquals("Adresse anhand des Vornamens nicht gefunden","Wolfgang Hansen", caseSensitiveSearchService2.searchByPrename("Wolfgang"));
    }

    @Test
    public void testSearchServiceWithLastName() {
        twoEntriesForTheMap();
        CaseSensitiveSearchService caseSensitiveSearchService1 = new CaseSensitiveSearchService();
        caseSensitiveSearchService1.updateDatabase(addressMap);
        assertEquals("Adresse anhand des Nachnamens nicht gefunden.","Susanne Liebig", caseSensitiveSearchService1.searchByLastName("Liebig"));
    }


    @Test
    public void testPutAllOut() {
        twoEntriesForTheMap();
        CaseSensitiveSearchService caseSensitiveSearchService3 = new CaseSensitiveSearchService();
        caseSensitiveSearchService3.updateDatabase(addressMap);
        assertEquals("Es wurden keine Adressen aus der Map ausgegeben.", "\nWolfgang Hansen\nSusanne Liebig",
                caseSensitiveSearchService3.putAllOut());
    }

    @Test
    public void shouldNotFindEntryIfNoFittingPrename() {
        twoEntriesForTheMap();
        CaseSensitiveSearchService caseSensitiveSearchService3 = new CaseSensitiveSearchService();
        caseSensitiveSearchService3.updateDatabase(addressMap);
        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
                caseSensitiveSearchService3.searchByPrename("quatsch"));
    }


    @Test
    public void shouldNotFindEntryIfNoFittingLastname() {
        twoEntriesForTheMap();
        CaseSensitiveSearchService caseSensitiveSearchService3 = new CaseSensitiveSearchService();
        caseSensitiveSearchService3.updateDatabase(addressMap);
        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
                caseSensitiveSearchService3.searchByLastName("quatsch"));
    }

    // Leere Map

    @Test
    public void testShouldFindNothingForEmptyRegisterWithOutputAll() {
        CaseSensitiveSearchService caseSensitiveSearchService2 = new CaseSensitiveSearchService();
        String result = caseSensitiveSearchService2.putAllOut();
        assertEquals("Kein Eintrag vorhanden.", result);
    }

    @Test
    public void testShouldFindNothingForEmptyRegisterWithSearchByPrename() {
        CaseSensitiveSearchService caseSensitiveSearchService2 = new CaseSensitiveSearchService();
        String result = caseSensitiveSearchService2.searchByPrename("irgendwas");
        assertEquals("Kein Eintrag vorhanden.", result);
    }

    @Test
    public void testShouldFindNothingForEmptyRegisterWithSearchByLastName() {
        CaseSensitiveSearchService caseSensitiveSearchService2 = new CaseSensitiveSearchService();
        String result = caseSensitiveSearchService2.searchByLastName("irgendwas anderes");
        assertEquals("Kein Eintrag vorhanden.", result);
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
