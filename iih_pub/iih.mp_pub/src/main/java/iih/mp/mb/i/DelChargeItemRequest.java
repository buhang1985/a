package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DelChargeItemRequest
{
    @JsonProperty(value = "detailSn")
    private String detailSn;
    @JsonProperty(value = "patientid")
    private String patientid;
    @JsonProperty(value = "num")
    private String num;
    
    public void setDetailSn(String detailSn)
    {
        this.detailSn = detailSn;
    }
    public String getDetailSn()
    {
        return this.detailSn;
    }
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
    
}
