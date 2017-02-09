import de.deutschepost.epost.addressRegister.persistence.SearchDao;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by afischer on 06/12/2016.
 */
public class NotCaseSensitiveSearchServiceTest {

//    HashMap<String, Address> addressMap;
//
//    // gefüllte Map
//
//    @Test
//    public void testSearchServiceWithPrename() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        // assertEquals("eigene Message nur innerhalb des Tests", "Erwartetes Ergebnis", "Wirkliches Ergebnis")
//        assertEquals("Adresse anhand des Vornamens nicht gefunden","Wolfgang Hansen", notCaseSensitiveSearchService.
//                searchByPrename("Wolfgang"));
//    }
//
//
//    @Test
//    public void testSearchServiceWithPrenameCaseInsensitive() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        assertEquals("Addresse aufgrund Groß-/Kleinschreibung nicht gefunden.", "Susanne Liebig", notCaseSensitiveSearchService.
//                searchByPrename("SusAnNe"));
//    }
//
//    @Test
//    public void testSearchServiceWithLastname() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        assertEquals("Adresse anhand des Vornamens nicht gefunden","Susanne Liebig", notCaseSensitiveSearchService.
//                searchByLastName("Liebig"));
//    }
//
//    @Test
//    public void testSearchServiceWithLastnameCaseInsensitive() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        assertEquals("Addresse aufgrund Groß-/Kleinschreibung nicht gefunden.", "Wolfgang Hansen", notCaseSensitiveSearchService.
//                searchByLastName("hANseN"));
//    }
//
//
//
//    @Test
//    public void shouldNotFindEntryIfNoFittingPrename() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
//                notCaseSensitiveSearchService.searchByPrename("quatsch"));
//    }
//
//
//    @Test
//    public void shouldNotFindEntryIfNoFittingLastname() {
//        twoEntriesForTheMap();
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        notCaseSensitiveSearchService.updateDatabase(addressMap);
//        assertEquals("Es wurden keine passenden Einträge gefunden.", "Kein Eintrag vorhanden.",
//                notCaseSensitiveSearchService.searchByLastName("quatsch"));
//    }
//
//    // Leere Map
//
//
//    @Test
//    public void testShouldFindNothingForEmptyRegisterWithSearchByPrename() {
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        String result = notCaseSensitiveSearchService.searchByPrename("irgendwas");
//        assertEquals("Kein Eintrag vorhanden.", result);
//    }
//
//    @Test
//    public void testShouldFindNothingForEmptyRegisterWithSearchByLastName() {
//        SearchDao notCaseSensitiveSearchService = new SearchDao();
//        String result = notCaseSensitiveSearchService.searchByLastName("irgendwas anderes");
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
