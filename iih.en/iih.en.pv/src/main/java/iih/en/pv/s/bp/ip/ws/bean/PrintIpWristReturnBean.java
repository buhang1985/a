package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsResult;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrintIpWristReturnBean extends BaseWsResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //打印次数
    private int times_print; 
    
    public int getTimes_print() {
        return times_print;
    }

    public void setTimes_print(int times_print) {
        this.times_print = times_print;
    }

}
