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
                Address item = new Address(
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
        return null;
    }

    @Override
    public Address save(Address entity) {
        return null;
    }

    @Override
    public void update(Address entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Address> search(String searchTerm) {
        return null;
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
