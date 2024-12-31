package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class GetCancIpInfoBean extends BaseWsParam implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //住院号
    private String IpCode;
    
    //住院次数
    private String Times_ip;
    
    //退院时间
    private String Dt_canc;

    //患者code
    private String PatCode;
    
    //更新时间
  	private String Update_time = "";
  	
  	public String getUpdate_time() {
  		return Update_time;
  	}

  	public void setUpdate_time(String update_time) {
  		Update_time = update_time;
  	}
    
    public String getIpCode() {
        return IpCode;
    }

    public void setIpCode(String ipCode) {
        IpCode = ipCode;
    }

    public String getTimes_ip() {
        return Times_ip;
    }

    public void setTimes_ip(String times_ip) {
        Times_ip = times_ip;
    }

    public String getDt_canc() {
        return Dt_canc;
    }

    public void setDt_canc(String dt_canc) {
        Dt_canc = dt_canc;
    }

    public String getPatCode() {
        return PatCode;
    }

    public void setPatCode(String patCode) {
        PatCode = patCode;
    }

    @Override
    public String toString() {
        return "GetCancIpInfoBean [IpCode=" + IpCode + ", Times_ip=" + Times_ip + ", Dt_canc=" + Dt_canc + ", PatCode=" + PatCode + "]";
    }
}
