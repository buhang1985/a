
package iih.pmp.yilutong.i;

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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.15
 * 2019-01-14T16:51:02.012+08:00
 * Generated source version: 3.1.15
 * 
 */
public final class IWindowPayWebServiceV2_WindowPayWebServiceImplV2Port_Client {

    private static final QName SERVICE_NAME = new QName("http://www.witontek.com/ehospital/", "WindowPayWebServiceImplV2Service");

    private IWindowPayWebServiceV2_WindowPayWebServiceImplV2Port_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WindowPayWebServiceImplV2Service.WSDL_LOCATION;
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
      
        WindowPayWebServiceImplV2Service ss = new WindowPayWebServiceImplV2Service(wsdlURL, SERVICE_NAME);
        IWindowPayWebServiceV2 port = ss.getWindowPayWebServiceImplV2Port();  
        
        {
        System.out.println("Invoking qryOrderStatus...");
        java.lang.String _qryOrderStatus_inputStr = "";
        java.lang.String _qryOrderStatus__return = port.qryOrderStatus(_qryOrderStatus_inputStr);
        System.out.println("qryOrderStatus.result=" + _qryOrderStatus__return);


        }
        {
        System.out.println("Invoking scanRefund...");
        java.lang.String _scanRefund_inputStr = "";
        java.lang.String _scanRefund__return = port.scanRefund(_scanRefund_inputStr);
        System.out.println("scanRefund.result=" + _scanRefund__return);


        }
        {
        System.out.println("Invoking queryRefundStatus...");
        java.lang.String _queryRefundStatus_inputStr = "";
        java.lang.String _queryRefundStatus__return = port.queryRefundStatus(_queryRefundStatus_inputStr);
        System.out.println("queryRefundStatus.result=" + _queryRefundStatus__return);


        }
        {
        System.out.println("Invoking qrCodeReverse...");
        java.lang.String _qrCodeReverse_inputStr = "";
        java.lang.String _qrCodeReverse__return = port.qrCodeReverse(_qrCodeReverse_inputStr);
        System.out.println("qrCodeReverse.result=" + _qrCodeReverse__return);


        }
        {
        System.out.println("Invoking closeOrder...");
        java.lang.String _closeOrder_inputStr = "";
        java.lang.String _closeOrder__return = port.closeOrder(_closeOrder_inputStr);
        System.out.println("closeOrder.result=" + _closeOrder__return);


        }
        {
        System.out.println("Invoking refund...");
        java.lang.String _refund_inputStr = "";
        java.lang.String _refund__return = port.refund(_refund_inputStr);
        System.out.println("refund.result=" + _refund__return);


        }
        {
        System.out.println("Invoking reverseOrder...");
        java.lang.String _reverseOrder_inputStr = "";
        java.lang.String _reverseOrder__return = port.reverseOrder(_reverseOrder_inputStr);
        System.out.println("reverseOrder.result=" + _reverseOrder__return);


        }
        {
        System.out.println("Invoking createOrder...");
        java.lang.String _createOrder_inputStr = "";
        java.lang.String _createOrder__return = port.createOrder(_createOrder_inputStr);
        System.out.println("createOrder.result=" + _createOrder__return);


        }
        {
        System.out.println("Invoking refundReverse...");
        java.lang.String _refundReverse_inputStr = "";
        java.lang.String _refundReverse__return = port.refundReverse(_refundReverse_inputStr);
        System.out.println("refundReverse.result=" + _refundReverse__return);


        }
        {
        System.out.println("Invoking microPay...");
        java.lang.String _microPay_inputStr = "";
        java.lang.String _microPay__return = port.microPay(_microPay_inputStr);
        System.out.println("microPay.result=" + _microPay__return);


        }
        {
        System.out.println("Invoking qryPayStatus...");
        java.lang.String _qryPayStatus_inputStr = "";
        java.lang.String _qryPayStatus__return = port.qryPayStatus(_qryPayStatus_inputStr);
        System.out.println("qryPayStatus.result=" + _qryPayStatus__return);


        }
        {
        System.out.println("Invoking qryRefund...");
        java.lang.String _qryRefund_inputStr = "";
        java.lang.String _qryRefund__return = port.qryRefund(_qryRefund_inputStr);
        System.out.println("qryRefund.result=" + _qryRefund__return);


        }

        System.exit(0);
    }

}
