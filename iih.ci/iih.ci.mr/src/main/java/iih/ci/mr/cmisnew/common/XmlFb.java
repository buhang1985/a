package iih.ci.mr.cmisnew.common;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.15
 * 2019-12-09T14:31:01.466+08:00
 * Generated source version: 3.1.15
 * 
 */
@WebServiceClient(name = "XmlFb", 
                  wsdlLocation = "file:/root/AppData/interface_manage/0001Z8100000001C0YB5/webservice/java/XmlFbPortType.wsdl",
                  targetNamespace = "http://paser.creating.com") 
public class XmlFb extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://paser.creating.com", "XmlFb");
    public final static QName XmlFbHttpSoap12Endpoint = new QName("http://paser.creating.com", "XmlFbHttpSoap12Endpoint");
    public final static QName XmlFbHttpSoap11Endpoint = new QName("http://paser.creating.com", "XmlFbHttpSoap11Endpoint");
    public final static QName XmlFbHttpEndpoint = new QName("http://paser.creating.com", "XmlFbHttpEndpoint");
    static {
        URL url = null;
        try {
            url = new URL("file:/root/AppData/interface_manage/0001Z8100000001C0YB5/webservice/java/XmlFbPortType.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(XmlFb.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/root/AppData/interface_manage/0001Z8100000001C0YB5/webservice/java/XmlFbPortType.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public XmlFb(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public XmlFb(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public XmlFb() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public XmlFb(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public XmlFb(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public XmlFb(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpSoap12Endpoint")
    public XmlFbPortType getXmlFbHttpSoap12Endpoint() {
        return super.getPort(XmlFbHttpSoap12Endpoint, XmlFbPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpSoap12Endpoint")
    public XmlFbPortType getXmlFbHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(XmlFbHttpSoap12Endpoint, XmlFbPortType.class, features);
    }


    /**
     *
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpSoap11Endpoint")
    public XmlFbPortType getXmlFbHttpSoap11Endpoint() {
        return super.getPort(XmlFbHttpSoap11Endpoint, XmlFbPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpSoap11Endpoint")
    public XmlFbPortType getXmlFbHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(XmlFbHttpSoap11Endpoint, XmlFbPortType.class, features);
    }


    /**
     *
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpEndpoint")
    public XmlFbPortType getXmlFbHttpEndpoint() {
        return super.getPort(XmlFbHttpEndpoint, XmlFbPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns XmlFbPortType
     */
    @WebEndpoint(name = "XmlFbHttpEndpoint")
    public XmlFbPortType getXmlFbHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(XmlFbHttpEndpoint, XmlFbPortType.class, features);
    }

}
