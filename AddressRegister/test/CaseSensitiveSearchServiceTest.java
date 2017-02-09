

import static junit.framework.TestCase.assertEquals;

/**
 * Created by afischer on 02/12/2016.
 */
public class CaseSensitiveSearchServiceTest {

//    HashMap<String, Address> addressMap;
//
//    // gefüllte Map
//
//
//    @Test
//    public void testSearchServiceWithPreName() {
//        twoEntriesForTheMap();
//        SensitiveSearchDao caseSensitiveSearchService2 = new SensitiveSearchDao();
//        caseSensitiveSearchService2.updateDatabase(addressMap);
//        // assertEquals("eigene Message nur innerhalb des Tests", "Erwartetes Ergebnis", "Wirkliches Ergebnis")
//        assertEquals("Adresse anhand des Vornamens nicht gefunden","Wolfgang Hansen", caseSensitiveSearchService2.searchByPrename("Wolfgang"));
//    }
//
//    @Test
//    public void testSearchServiceWithLastName() {
//        twoEntriesForTheMap();
//        SensitiveSearchDao caseSensitiveSearchService1 = new SensitiveSearchDao();
//        caseSensitiveSearchService1.updateDatabase(addressMap);
//        assertEquals("Adresse anhand des Nachnamens nicht gefunden.","Susanne Liebig", caseSensitiveSearchService1.searchByLastName("Liebig"));
//    }
//
//
//    @Test
//    public void testPutAllOut() {
//        twoEntriesForTheMap();
//        SensitiveSearchDao caseSensitiveSearchService3 = new SensitiveSearchDao();
//        caseSensitiveSearchService3.updateDatabase(addressMap);
//        assertEquals("Es wurden keine Adressen aus der Map ausgegeben.", "\nWolfgang Hansen\nSusanne Liebig",
//                caseSensitiveSearchService3.putAllOut());
//    }
//
//    @Test
//    public void shouldNotFindEntryIfNoFittingPrename() {
//        twoEntriesForTheMap();
//        SensitiveSearchDao caseSensitiveSearchService3 = new SensitiveSearchDao();
//        caseSensitiveSearchService3.updateDatabase(addressMap);
//        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
//                caseSensitiveSearchService3.searchByPrename("quatsch"));
//    }
//
//
//    @Test
//    public void shouldNotFindEntryIfNoFittingLastname() {
//        twoEntriesForTheMap();
//        SensitiveSearchDao caseSensitiveSearchService3 = new SensitiveSearchDao();
//        caseSensitiveSearchService3.updateDatabase(addressMap);
//        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
//                caseSensitiveSearchService3.searchByLastName("quatsch"));
//    }
//
//    // Leere Map
//
//    @Test
//    public void testShouldFindNothingForEmptyRegisterWithOutputAll() {
//        SensitiveSearchDao caseSensitiveSearchService2 = new SensitiveSearchDao();
//        String result = caseSensitiveSearchService2.putAllOut();
//        assertEquals("Kein Eintrag vorhanden.", result);
//    }
//
//    @Test
//    public void testShouldFindNothingForEmptyRegisterWithSearchByPrename() {
//        SensitiveSearchDao caseSensitiveSearchService2 = new SensitiveSearchDao();
//        String result = caseSensitiveSearchService2.searchByPrename("irgendwas");
//        assertEquals("Kein Eintrag vorhanden.", result);
//    }
//
//    @Test
//    public void testShouldFindNothingForEmptyRegisterWithSearchByLastName() {
//        SensitiveSearchDao caseSensitiveSearchService2 = new SensitiveSearchDao();
//        String result = caseSensitiveSearchService2.searchByLastName("irgendwas anderes");
//        assertEquals("Kein Eintrag vorhanden.", result);
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
