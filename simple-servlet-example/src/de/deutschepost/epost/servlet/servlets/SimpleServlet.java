package de.deutschepost.epost.servlet.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import de.deutschepost.epost.servlet.model.Address;
import de.deutschepost.epost.servlet.persistence.AddressDao;
import de.deutschepost.epost.servlet.persistence.ConnectionFactory;
import de.deutschepost.epost.servlet.verification.OutputPolisher;
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
     * <p>
     * javax.servlet.http.HTTPServeletResponse extends javax.servlet.ServeletResponse (Interface) -> enthält die Methode getOutputStream()
     * getOutputStream() gibt ein ServletOutputStream zurück, der in der Antwort zum Client binäre Daten enthält
     * binäre Dateien sparen aufgrund der höheren Informationsdichte Speicherplatz (im Gegensatz zu Textdateien)
     * binäre Dateien sind z.B. Audiodateien, Bilddateien, komprimierte Dateien, mit Datenbank verwaltete Daten
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OutputStream outputStream = resp.getOutputStream();
        String newID = req.getParameter("id");

        if (newID != null) {
            if (verificator.verifyID_IfNumbersOnly(newID)) {

                Long id = Long.parseLong(newID);

                Optional<Address> addressOptional = addressDao.findById(id); // Klasse Optional angucken


                if (addressOptional.isPresent()) {
                    Address address = addressOptional.get();
                    /**
                     * try (mit Ressourcen) zum Schliessen von Ressourcen
                     * ServeletOutputStream implements java.lang.AutoClosable und kann deswegen mit try (Ressource)
                     * verwendet werden
                     * AutoCloseable ist für eine Ressource die geschlossen werden muss, wenn sie nicht länger gebraucht wird
                     * d.h. das Objekt muss geschlossen werden, sobald es den Output an den Client gesendet hat
                     * man spart: final OutputStream responseOutput = [...] sowie ein finally (resp.close())
                     * */

                    try (OutputStream responseOutput = resp.getOutputStream()) {
                        responseOutput.write(address.toString().getBytes());
                    }
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().println("<h1>Fehlercode 404<h1>");
                    outputStream.write("Für diese ID ist kein Eintrag vorhanden.".getBytes());
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("<h1>Fehlercode 400<h1>");
                resp.getWriter().println("Die ID muss eine Zahl sein.");
            }
        } else {
            outputStream.write("Suchen, Loeschen, Anlegen".getBytes());  // auf Link von RESTClient weiterleiten?
        }
    }

    /**
     * Serves the purpose of dealing with POST requests.
     *
     * @param req  The request object
     * @param resp The response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO please implement something useful
        PrintWriter printwriter = resp.getWriter();
        OutputPolisher outputPolisher = new OutputPolisher();


        Address newAddress = new Address();
        String prename = req.getParameter("prename");
        String lastname = req.getParameter("lastname");
        String street = req.getParameter("street");
        String streetnumber = req.getParameter("streetnumber");
        String postcode = req.getParameter("postcode");
        String location = req.getParameter("location");


        newAddress.setPrename(prename);
        newAddress.setLastName(lastname);
        newAddress.setStreet(street);
        newAddress.setStreetNumber(streetnumber);
        newAddress.setPostCode(postcode);
        newAddress.setLocation(location);

        if (verificator.proveInput(newAddress)) { // TODO funktioniert soweit, prüfen!
            newAddress = outputPolisher.polishInput(newAddress); // TODO funktionsfähig machen!!
            printwriter.println("Die Adresse ist: ");
            printwriter.println(newAddress.getPrename() + " " + newAddress.getLastName());
            printwriter.println(newAddress.getStreet() + " " + newAddress.getStreetNumber());
            printwriter.println(newAddress.getPostCode() + ", " + newAddress.getLocation());
            printwriter.flush();

            addressDao.save(newAddress);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("<h1>Fehlercode 400</h1>");
            resp.getWriter().println("Fehler bei der Eingabe.");
        }
    }


    /**
     * Serves the purpose of dealing with DELETE requests.
     * <p>
     * javax.servlet.http.HTTPServeletResponse extends javax.servlet.ServeletResponse (Interface) -> enthält die Methode getWriter()
     * getWriter() gibt ein PrintWriter-Objekt zurück, das Buchstaben-Text an den Client senden kann
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO please implement something useful

        PrintWriter printWriter = resp.getWriter();

        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");

            if (addressDao.verifyID(Long.parseLong(id)) == 1) { // if true

                addressDao.delete(Long.parseLong(id));

                printWriter.println("Der Eintrag fuer die ID " + id + " wurde soeben geloescht.");

            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().println("<h1>Fehlercode 404</h1>");
                resp.getWriter().println("Fuer diese ID ist kein Eintrag vorhanden.");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("<h1>Fehlercode 400</h1>");
            resp.getWriter().println("Es wurde keine ID angegeben.");
        }

    }
}
