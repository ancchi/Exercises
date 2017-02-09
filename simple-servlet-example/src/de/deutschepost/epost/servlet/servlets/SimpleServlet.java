package de.deutschepost.epost.servlet.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;


import de.deutschepost.epost.servlet.model.Address;
import de.deutschepost.epost.servlet.persistence.AddressDao;
import de.deutschepost.epost.servlet.persistence.ConnectionFactory;

/**
 * This is a simple example servlet that just returns "HELLO WORLD!" for GET.
 */

public class SimpleServlet extends HttpServlet {

    AddressDao addressDao;

    public SimpleServlet() { // wird vor init() gerufen
        addressDao = new AddressDao();

    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String servletAbsolutePath = getServletContext().getRealPath("/");
        String h2DBPath = servletAbsolutePath + "WEB-INF/database/AddressDB";

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance(h2DBPath);
        try {
            addressDao.setConnectionFactory(connectionFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Serves the purpose of dealing with GET requests.
     * @param req The request object
     * @param resp The response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String servletAbsolutePath = getServletContext().getRealPath("/");
//        String h2DBPath = servletAbsolutePath + "WEB-INF/database/AddressDB";

        Address address = addressDao.findById(2);
//        String auto = "rot";

        try (OutputStream responseOutput = resp.getOutputStream()) {

            responseOutput.write(address.getPrename().getBytes());
        }

//        PrintWriter printwriter = resp.getWriter();
//        printwriter.println("Die Adresse ist: " + address.getPrename() + " " + address.getLastName() +
//                " " + address.getStreet());
//        printwriter.flush();

    }

    /**
     * Serves the purpose of dealing with POST requests.
     * @param req The request object
     * @param resp The response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO please implement something useful

        String prename = req.getParameter("prename");
        String lastname = req.getParameter("lastname");
        String street = req.getParameter("street");
        String streetnumber = req.getParameter("streetnumber");
        String postcode = req.getParameter("plz");
        String location = req.getParameter("location");

        Address newAddress = new Address();
        newAddress.setPrename(prename);
        newAddress.setLastName(lastname);
        newAddress.setStreet(street);
        newAddress.setStreetNumber(streetnumber);
        newAddress.setPostCode(postcode);
        newAddress.setLocation(location);

        addressDao.save(newAddress);


        PrintWriter printwriter = resp.getWriter();
        printwriter.println("Die Adresse ist: " + prename + " " + lastname + " " + street);
        printwriter.flush();

    }

    /**
     * Serves the purpose of dealing with DELETE requests.
     * @param req The request object
     * @param resp The response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO please implement something useful
//        super.doDelete(req, resp);


    }
}
