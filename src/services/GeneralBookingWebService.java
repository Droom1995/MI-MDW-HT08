package services;

import javax.jws.WebService;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Oleksandr on 18.12.2016.
 */
@WebService
public class GeneralBookingWebService {


    private SOAPMessage createBookingRequest(String name, String destination) throws Exception{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("ser", "http://services/");

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyAdd = soapBody.addChildElement("addBooking", "ser");
        SOAPElement soapBodyElem1 = soapBodyAdd.addChildElement("arg0");
        soapBodyElem1.addTextNode(name);
        SOAPElement soapBodyElem2 = soapBodyAdd.addChildElement("arg1");
        soapBodyElem1.addTextNode("0");
        soapMessage.saveChanges();
        return soapMessage;
    }

    private static SOAPMessage createFlightRequest(String name, String destination) throws Exception{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("ser", "http://services/");

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyAdd = soapBody.addChildElement("addBooking", "ser");
        SOAPElement soapBodyElem1 = soapBodyAdd.addChildElement("arg0");
        soapBodyElem1.addTextNode(name);
        SOAPElement soapBodyElem2 = soapBodyAdd.addChildElement("arg1");
        soapBodyElem1.addTextNode("0");
        SOAPElement soapBodyElem3 = soapBodyAdd.addChildElement("arg2");
        soapBodyElem1.addTextNode("PRA");
        SOAPElement soapBodyElem4 = soapBodyAdd.addChildElement("arg3");
        soapBodyElem1.addTextNode(destination);
        SOAPElement soapBodyElem5 = soapBodyAdd.addChildElement("arg4");
        soapBodyElem1.addTextNode("16:05");
        SOAPElement soapBodyElem6 = soapBodyAdd.addChildElement("arg4");
        soapBodyElem1.addTextNode("16:28");
        soapMessage.saveChanges();
        return soapMessage;
    }

    private void printSOAPResponse(SOAPMessage soapResponse) throws Exception
    {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.println("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

    public boolean addGeneralBooking(String type, String name, String destination) {

        SOAPConnectionFactory soapConnectionFactory = null;
        System.out.println(type+" "+name+" "+destination);
        if(type == null)
            return false;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();

            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            //Send SOAP Message to SOAP Server

            SOAPMessage msg = null;
            SOAPMessage soapResponse = null;

            if(type.equals("Flight")){
                try {
                    msg = createFlightRequest(name, destination);
                    String url = "http://localhost:7001/MI-MDW-HT08/FlightOrderServiceService";
                    soapResponse = soapConnection.call(msg, url);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }else if(type.equals("Booking")){
                try {
                    msg = createBookingRequest(name, destination);
                    String url = "http://localhost:7001/MI-MDW-HT08/BookingServiceService";
                    soapResponse = soapConnection.call(msg, url);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }


            // Process the SOAP Response
            printSOAPResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
