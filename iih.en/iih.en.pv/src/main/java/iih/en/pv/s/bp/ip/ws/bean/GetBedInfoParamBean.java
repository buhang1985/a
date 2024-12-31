package iih.en.pv.s.bp.ip.ws.bean;
import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetBedInfoParamBean extends BaseWsParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //病区编码
    private String NurCode;

    public String getNurCode() {
        return NurCode;
    }

    public void setNurCode(String nurCode) {
        NurCode = nurCode;
    }

    @Override
    public String toString() {
        return "GetBedInfoParamBean [NurCode=" + NurCode + "]";
    }
}
