package de.deutschepost.epost.servlet.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import de.deutschepost.epost.servlet.model.Address;
import de.deutschepost.epost.servlet.persistence.AddressDao;
import de.deutschepost.epost.servlet.persistence.ConnectionFactory;
import de.deutschepost.epost.servlet.verification.Verify;

/**
 * This is a simple example servlet that just returns "HELLO WORLD!" for GET.
 */

public class SimpleServlet extends HttpServlet {

    AddressDao addressDao;
    Verify verificator;

    public SimpleServlet() { // wird vor init() aufgerufen gerufen
        addressDao = new AddressDao();
        verificator = new Verify();
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String servletAbsolutePath = getServletContext().getRealPath("/");
        System.out.println(servletAbsolutePath);
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
     *
     * javax.servlet.http.HTTPServeletResponse extends javax.servlet.ServeletResponse (Interface) -> enthält die Methode getOutputStream()
     * getOutputStream() gibt ein ServletOutputStream zurück, der in der Antwort zum Client binäre Daten enthält
     * binäre Dateien sparen aufgrund der höheren Informationsdichte Speicherplatz (im Gegensatz zu Textdateien)
     * binäre Dateien sind z.B. Audiodateien, Bilddateien, komprimierte Dateien, mit Datenbank verwaltete Daten
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OutputStream outputStream = resp.getOutputStream();

        if(req.getParameter("id") != null) {

            String id = req.getParameter("id");
            if(addressDao.verifyID(Long.parseLong(id)) == 1) {
                Address address = addressDao.findById(Long.parseLong(id));

                /**
                 * try (mit Ressourcen) zum Schliessen von Ressourcen
                 * ServeletOutputStream implements java.lang.AutoClosable und kann deswegen mit try (Ressource)
                 * verwendet werden
                 * AutoCloseable ist für eine Ressource die geschlossen werden muss, wenn sie nicht länger gebraucht wird
                 * d.h. das Objekt muss geschlossen werden, sobald es den Output an den Cleint gesendet hat
                 * man spart: final OutputStream responseOutput = [...] sowie ein finally (resp.close())
                 * */

                try (OutputStream responseOutput = resp.getOutputStream()) {
                    responseOutput.write(address.getPrename().getBytes());
                }
            } else {
                outputStream.write("Für diese ID ist kein Eintrag vorhanden.".getBytes());
            }
        } else {

            outputStream.write("Suchen, Loeschen, Anlegen".getBytes());  // auf Link von RESTClient weiterleiten?

        }
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
        PrintWriter printwriter = resp.getWriter();
        Address newAddress = new Address();
        String prename = null;
        String lastname = null;
        String street = null;
        String streetnumber = null;
        String postcode = null;
        String location = null;


            if(verificator.proofForOnlyLetters(req.getParameter("prename")) &&   // sollte eigentlich einzeln getestet werden
                    verificator.proofForOnlyLetters(req.getParameter("lastname")) &&
                            verificator.proofForOnlyLetters(req.getParameter("street")) &&
                                    verificator.proofForOnlyLetters(req.getParameter("location")) &&
                    verificator.proofForNoSpecialCharacters(req.getParameter("streetnumber")) &&
                    verificator.verifyPLZWith5NumbersOnly(req.getParameter("plz"))) {


                prename = verificator.checkIfMoreThenOneWord(req.getParameter("prename"));
                lastname = verificator.checkIfMoreThenOneWord(req.getParameter("lastname"));
                street = verificator.checkIfMoreThenOneWord(req.getParameter("street"));
                streetnumber = req.getParameter("streetnumber");
                postcode = req.getParameter("plz");
                location = verificator.checkIfMoreThenOneWord(req.getParameter("location"));



                newAddress.setPrename(prename);
                newAddress.setLastName(lastname);
                newAddress.setStreet(street);
                newAddress.setStreetNumber(streetnumber);
                newAddress.setPostCode(postcode);
                newAddress.setLocation(location);


                printwriter.println("Die Adresse ist: ");

                printwriter.println(prename + " " + lastname);
                printwriter.println(street + " " + streetnumber);
                printwriter.println(postcode + ", " + location);
                printwriter.flush();

                addressDao.save(newAddress);

            } else {
                printwriter.println("Fehler bei der Eingabe");
            }
    }


    /**
     * Serves the purpose of dealing with DELETE requests.
     *
     * javax.servlet.http.HTTPServeletResponse extends javax.servlet.ServeletResponse (Interface) -> enthält die Methode getWriter()
     * getWriter() gibt ein PrintWriter-Objekt zurück, das Buchstaben-Text an den Client senden kann
     *
     *
     *
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO please implement something useful

        PrintWriter printWriter = resp.getWriter();

        if(req.getParameter("id") != null) {
            String id = req.getParameter("id");

            if (addressDao.verifyID(Long.parseLong(id)) == 1) { // if true

                addressDao.delete(Long.parseLong(id)); // funktioniert - aber id wird nicht eingelesen

                printWriter.println("Der Eintrag fuer die ID " + id + " wurde soeben geloescht.");

            } else {
                printWriter.println("Fuer diese ID ist kein Eintrag vorhanden.");
            }
        } else {
            printWriter.println("Es wurde keine ID angegeben.");
        }

    }
}
