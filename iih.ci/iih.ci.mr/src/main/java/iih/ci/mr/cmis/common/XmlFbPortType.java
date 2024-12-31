
package iih.ci.mr.cmis.common;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "XmlFbPortType", targetNamespace = "http://paser.creating.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface XmlFbPortType {


    /**
     * 
     */
    @WebMethod(action = "urn:parsexml")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public void parsexml();

    /**
     * 
     * @param xml
     * @param xmlid
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "XpServiceFb", action = "urn:XpServiceFb")
    @WebResult(targetNamespace = "http://paser.creating.com")
    @RequestWrapper(localName = "XpServiceFb", targetNamespace = "http://paser.creating.com", className = "iih.ci.mr.cmis.XpServiceFb")
    @ResponseWrapper(localName = "XpServiceFbResponse", targetNamespace = "http://paser.creating.com", className = "iih.ci.mr.cmis.XpServiceFbResponse")
    public String xpServiceFb(
        @WebParam(name = "xml", targetNamespace = "http://paser.creating.com")
        String xml,
        @WebParam(name = "xmlid", targetNamespace = "http://paser.creating.com")
        String xmlid);

}