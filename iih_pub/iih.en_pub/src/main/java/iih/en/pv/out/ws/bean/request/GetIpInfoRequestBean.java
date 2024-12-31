package iih.en.pv.out.ws.bean.request;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetIpInfoRequestBean extends BaseWsParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 住院科室编码
    private String DeptCode;

    // 住院病区编码
    private String NurCode;

    // 查询状态 1 在院 2 出院
    private String Status;

    // 住院开始时间
    private String Date_b_in;

    // 住院结束时间
    private String Date_e_in;

    // 出院开始时间
    private String Date_b_out;

    // 出院结束时间
    private String Date_e_out;
    
    //患者住院号
    private String IpCode;
    
    // 患者code
    private String PatCode;

    // 住院次数
    private String Times_ip;

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getNurCode() {
        return NurCode;
    }

    public void setNurCode(String nurCode) {
        NurCode = nurCode;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate_b_in() {
        return Date_b_in;
    }

    public void setDate_b_in(String date_b_in) {
        Date_b_in = date_b_in;
    }

    public String getDate_e_in() {
        return Date_e_in;
    }

    public void setDate_e_in(String date_e_in) {
        Date_e_in = date_e_in;
    }

    public String getDate_b_out() {
        return Date_b_out;
    }

    public void setDate_b_out(String date_b_out) {
        Date_b_out = date_b_out;
    }

    public String getDate_e_out() {
        return Date_e_out;
    }

    public void setDate_e_out(String date_e_out) {
        Date_e_out = date_e_out;
    }

	public String getIpCode() {
		return IpCode;
	}

	public void setIpCode(String ipCode) {
		IpCode = ipCode;
	}

	public String getPatCode() {
		return PatCode;
	}

	public void setPatCode(String patCode) {
		PatCode = patCode;
	}

	public String getTimes_ip() {
		return Times_ip;
	}

	public void setTimes_ip(String times_ip) {
		Times_ip = times_ip;
	}

}