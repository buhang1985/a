
package iih.ci.mr.cmis.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the iih.ci.mr.cmis package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _XpServiceFbXml_QNAME = new QName("http://paser.creating.com", "xml");
    private final static QName _XpServiceFbXmlid_QNAME = new QName("http://paser.creating.com", "xmlid");
    private final static QName _XpServiceFbResponseReturn_QNAME = new QName("http://paser.creating.com", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: iih.ci.mr.cmis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XpServiceFbResponse }
     * 
     */
    public XpServiceFbResponse createXpServiceFbResponse() {
        return new XpServiceFbResponse();
    }

    /**
     * Create an instance of {@link XpServiceFb }
     * 
     */
    public XpServiceFb createXpServiceFb() {
        return new XpServiceFb();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paser.creating.com", name = "xml", scope = XpServiceFb.class)
    public JAXBElement<String> createXpServiceFbXml(String value) {
        return new JAXBElement<String>(_XpServiceFbXml_QNAME, String.class, XpServiceFb.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paser.creating.com", name = "xmlid", scope = XpServiceFb.class)
    public JAXBElement<String> createXpServiceFbXmlid(String value) {
        return new JAXBElement<String>(_XpServiceFbXmlid_QNAME, String.class, XpServiceFb.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paser.creating.com", name = "return", scope = XpServiceFbResponse.class)
    public JAXBElement<String> createXpServiceFbResponseReturn(String value) {
        return new JAXBElement<String>(_XpServiceFbResponseReturn_QNAME, String.class, XpServiceFbResponse.class, value);
    }

}
