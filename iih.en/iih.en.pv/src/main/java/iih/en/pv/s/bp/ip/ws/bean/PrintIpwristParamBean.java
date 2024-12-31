package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrintIpwristParamBean extends BaseWsParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 患者编码
    private String PatCode;

    // 住院次数
    private String Times_ip;

    
    public String getPatCode() {
        return PatCode;
    }

    public void setPatCode(String patCode) {
        this.PatCode = patCode;
    }

    public String getTimes_ip() {
        return Times_ip;
    }

    public void setTimes_ip(String times_ip) {
        Times_ip = times_ip;
    }
}
