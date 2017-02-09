package de.deutschepost.epost.servlet.persistence;


import de.deutschepost.epost.servlet.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.oracle.jrockit.jfr.ContentType.Address;


public class AddressDao extends AbstractDao<Address> {

    private Connection con;


    @Override
    public Address findById(long id) {
        con = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Address address = new Address();

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
           closeConn(preparedStatement, resultSet);
        }
        return address;
    }



    @Override
    public List<Address> findAll() {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String findAllQuery = "SELECT * FROM address_list";
            preparedStatement = con.prepareStatement(findAllQuery);
            resultSet = preparedStatement.executeQuery();

            addressList = getfullResultset(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(preparedStatement, resultSet);
        }

        return addressList;
    }



    @Override
    public void save(Address entity) {

        con = getConnection();
//        Address savedAddress = new Address();
        PreparedStatement preparedStatement = null;


        try {
            String savingItem = "INSERT INTO address_list (vorname, nachname, strasse, hausnummer, plz, ort) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
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
            closeConn(preparedStatement);
        }

//        return savedAddress;
    }



    @Override
    public void update(Address entity) {
        con = getConnection();
        PreparedStatement preparedStatement = null;

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
            closeConn(preparedStatement);
        }
    }



    @Override
    public void delete(long id) {
        con = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String deleteAddress = "DELETE FROM address_list WHERE address_id = ?";
            preparedStatement = con.prepareStatement(deleteAddress);
            System.out.println(id);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(preparedStatement);
        }
    }


    public int verifyID(long id) {
        con = getConnection();
        int idExists = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String ifExistQuery = "SELECT COUNT(*) FROM address_list WHERE address_id = ?";
            preparedStatement = con.prepareStatement(ifExistQuery);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                idExists = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idExists;
    }


       private void closeConn(PreparedStatement preparedStatement, ResultSet resultSet) {
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


    private void closeConn(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

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
                        resultSet.getLong(1),
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
            closeConn(preparedStatement, resultSet);
        }

        return hits;
    }



    public List<Address> searchByPrename(String prename) {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String prenameQuery = "SELECT * FROM address_list WHERE vorname = ?";
            preparedStatement = con.prepareStatement(prenameQuery);
            preparedStatement.setString(1, prename);
            resultSet = preparedStatement.executeQuery();

            addressList = getfullResultset(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(preparedStatement, resultSet);
        }
        return addressList;
    }

    public List<Address> searchByLastname(String lastname) {
        con = getConnection();
        List<Address> addressList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String lastnameQuery = "SELECT * FROM address_list WHERE nachname = ?";
            preparedStatement = con.prepareStatement(lastnameQuery);
            preparedStatement.setString(1, lastname);
            resultSet = preparedStatement.executeQuery();

            addressList = getfullResultset(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(preparedStatement, resultSet);
        }
        return addressList;
    }



    public List<Address> searchByPrenameInsensitive(String searchItem) {
        List<Address> addressList = new ArrayList<>();
        con = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String insensitiveQuery = "SELECT * FROM address_list WHERE upper(vorname) LIKE '%' || ? || '%'";
            preparedStatement = con.prepareStatement(insensitiveQuery);
            preparedStatement.setString(1, searchItem.toUpperCase());
            resultSet = preparedStatement.executeQuery();

            addressList = getfullResultset(resultSet);

        } catch (SQLException e) {
            closeConn(preparedStatement, resultSet);
        }
        return addressList;
    }



    public List<Address> searchByLastnameInsensitive(String searchItem) {
        List<Address> addressList = new ArrayList<>();
        con = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String insensitiveQuery = "SELECT * FROM address_list WHERE lower(nachname) LIKE '%' || ? || '%'";
            preparedStatement = con.prepareStatement(insensitiveQuery);
            preparedStatement.setString(1, searchItem.toLowerCase());
            resultSet = preparedStatement.executeQuery();

            addressList = getfullResultset(resultSet);

        } catch (SQLException e) {
            closeConn(preparedStatement, resultSet);
        }
        return addressList;
    }


    private List<Address> getfullResultset(ResultSet resultSet) throws SQLException {
        List<Address> addressList = new ArrayList<>();
        while (resultSet.next()) {
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
        return addressList;
    }

}
