package de.deutschepost.epost.addressRegister.persistence;


import de.deutschepost.epost.addressRegister.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;




public class SearchDao extends AbstractDao<Address> {

    private Connection con;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public Address findById(long id) {
        con = getConnection();
        Address address = null;

        try {

            String byIdQuery = "SELECT * FROM address_list WHERE address_id = ?";
            preparedStatement = con.prepareStatement(byIdQuery);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                final Address item = new Address(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7)
                );
                address = item;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return address;
    }

    @Override
    public List<Address> findAll() {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();

        try {
            String findAllQuery = "SELECT * FROM address_list";
            preparedStatement = con.prepareStatement(findAllQuery);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address addressItem = new Address(

                resultSet.getLong("address_id"),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7)
                );
                addressList.add(addressItem);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return addressList;
    }

    @Override
    public Address save(Address entity) {

        con = getConnection();
        Address savedAddress = new Address();

        try {
            String savingItem = "INSERT INTO address_list (vorname, nachname, strasse, hausnummer, plz, ort) " +
                    "VALUES(?, ?, ?,?, ?, ?)";
            preparedStatement = con.prepareStatement(savingItem);
            preparedStatement.setString(1, entity.getPrename());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.setString(4, entity.getStreetNumber());
            preparedStatement.setString(5, entity.getPostCode());
            preparedStatement.setString(6, entity.getLocation());
            preparedStatement.execute();



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return savedAddress;
    }


    @Override
    public void update(Address entity) {
        con = getConnection();
        try {
            String updateItem = "UPDATE address_list SET vorname = ?, nachname = ?, strasse = ?, " +
                    "hausnummer = ?, plz = ?, ort = ? WHERE address_id = ?";
            preparedStatement = con.prepareStatement(updateItem);
            preparedStatement.setString(1, entity.getPrename());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.setString(4, entity.getStreetNumber());
            preparedStatement.setString(5, entity.getPostCode());
            preparedStatement.setString(6, entity.getLocation());
            preparedStatement.setLong(7, entity.getAddressID());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }

    @Override
    public void delete(long id) {

        con = getConnection();
        try {

            int yesOrNo = verifyID(id);
            System.out.println("YesOrNo: " + yesOrNo);
            if(yesOrNo == 1) {

                String deleteAddress = "DELETE FROM address_list WHERE address_id = ?";
                preparedStatement = con.prepareStatement(deleteAddress);
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
            } else {
                System.out.println("Die ID ist nicht vorhanden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }


    public int verifyID(long id) {
        int idExists = 0;
        try {
            String ifExistQuery = "SELECT COUNT(*) FROM address_list WHERE address_id = ?";
            preparedStatement = con.prepareStatement(ifExistQuery);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            idExists = resultSet.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return idExists;
    }


       private void closeConn() {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zusätzliche Methoden
     */


    @Override
    public List<Address> globalSearch(String searchTerm) {

        List<Address> hits = new ArrayList<>();
        con = getConnection();

        try {
            String globalSearchQuery = "SELECT * FROM address_list WHERE " +
                    "upper(vorname) LIKE '%' || ? || '%' or upper(nachname) LIKE '%' || ? || '%' or upper(strasse) LIKE '%' || ? || '%' " +
                    "or upper(hausnummer) LIKE '%' || ? || '%' or upper(plz) LIKE '%' || ? || '%' or upper(ort) LIKE '%' || ? || '%'";

            preparedStatement = con.prepareStatement(globalSearchQuery);

            preparedStatement.setString(1, searchTerm.toUpperCase());
            preparedStatement.setString(2, searchTerm.toUpperCase());
            preparedStatement.setString(3, searchTerm.toUpperCase());
            preparedStatement.setString(4, searchTerm.toUpperCase());
            preparedStatement.setString(5, searchTerm.toUpperCase());
            preparedStatement.setString(6, searchTerm.toUpperCase());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address searchItem = new Address(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                hits.add(searchItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }


        return hits;
    }


    public List<Address> searchByPrename(String prename) {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();

        try {
            String prenameQuery = "SELECT * FROM address_list WHERE vorname = ?";
            preparedStatement = con.prepareStatement(prenameQuery);
            preparedStatement.setString(1, prename);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address item = new Address(
                  resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                addressList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return addressList;
    }

    public List<Address> searchByLastname(String lastname) {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();

        try {
            String lastnameQuery = "SELECT * FROM address_list WHERE nachname = ?";
            preparedStatement = con.prepareStatement(lastnameQuery);
            preparedStatement.setString(1, lastname);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address item = new Address(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                addressList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return addressList;
    }

    public List<Address> searchByPrenameInsensitive(String searchItem) {
        List<Address> addressList = new ArrayList<>();
        con = getConnection();

        try {
            String insensitiveQuery = "SELECT * FROM address_list WHERE upper(vorname) LIKE '%' || ? || '%'";
            preparedStatement = con.prepareStatement(insensitiveQuery);
            preparedStatement.setString(1, searchItem.toUpperCase());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address addressItem = new Address(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7)
                );
                addressList.add(addressItem);
            }

        } catch (SQLException e) {
            closeConn();
        }
        return addressList;
    }


    public List<Address> searchByLastnameInsensitive(String searchItem) {
        List<Address> addressList = new ArrayList<>();
        con = getConnection();

        try {
            String insensitiveQuery = "SELECT * FROM address_list WHERE lower(nachname) LIKE '%' || ? || '%'";
            preparedStatement = con.prepareStatement(insensitiveQuery);
            preparedStatement.setString(1, searchItem.toLowerCase());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Address addressItem = new Address(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                addressList.add(addressItem);
            }

        } catch (SQLException e) {
            closeConn();
        }
        return addressList;
    }


    //    Map<String, Address> addressMapNotSensitive = new TreeMap<String, Address>(String.CASE_INSENSITIVE_ORDER);
//
//    String address;


//    @Override
//    public String searchByLastName(String lastName) {
//        if(addressMapNotSensitive.get(lastName) != null) {
//            address = addressMapNotSensitive.get(lastName).toString();
//        } else {
//            noEntry();
//        }
//        return address;
//    }
//
//
//    @Override
//    public String searchByPrename(String prename) {
//
//        Set addressSet = addressMapNotSensitive.entrySet();
//        Iterator iterator = addressSet.iterator();
//        address = "";
//        while(iterator.hasNext()) {
//            Map.Entry<String, Address> mentry = (Map.Entry) iterator.next();
//            if(mentry.getValue().getPrename().toLowerCase().equals(prename.toLowerCase())) {  // kein case_insensitive, deswegen beides gleichsetzen
//                address = mentry.getValue().toString();
//            }
//        }
//        if (address.equals("")) {
//            noEntry();
//        }
//        return address;
//    }
//
//
//    public void noEntry() {
//        address = "Kein Eintrag vorhanden.";
//    }
//
//    @Override
//    public void updateDatabase(Map<String, Address> newDatabase) {  // erhält die Map schon bei der Eingabe der Daten
//        this.addressMapNotSensitive.putAll(newDatabase);   // HashMap newDatabase wird in TreeMap addressM... gepackt
//    }

}
