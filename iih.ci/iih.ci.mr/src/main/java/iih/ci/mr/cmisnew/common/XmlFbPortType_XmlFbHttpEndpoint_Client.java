
package iih.ci.mr.cmisnew.common;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.15
 * 2019-12-09T14:31:01.414+08:00
 * Generated source version: 3.1.15
 * 
 */
public final class XmlFbPortType_XmlFbHttpEndpoint_Client {

    private static final QName SERVICE_NAME = new QName("http://paser.creating.com", "XmlFb");

    private XmlFbPortType_XmlFbHttpEndpoint_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = XmlFb.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        XmlFb ss = new XmlFb(wsdlURL, SERVICE_NAME);
        XmlFbPortType port = ss.getXmlFbHttpEndpoint();  
        
        {
        System.out.println("Invoking xpServiceFb...");
        java.lang.String _xpServiceFb_xml = "";
        java.lang.String _xpServiceFb_xmlid = "";
        java.lang.String _xpServiceFb__return = port.xpServiceFb(_xpServiceFb_xml, _xpServiceFb_xmlid);
        System.out.println("xpServiceFb.result=" + _xpServiceFb__return);


        }
        {
        System.out.println("Invoking parsexml...");
        port.parsexml();


        }

        System.exit(0);
    }

}