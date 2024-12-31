package iih.mbh.ci.order.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class DrRptDTO {

	// 第三方url
	@RPCField(id = 1)
	private String rpturl;
	// 报告集合
	@RPCField(id = 2)
	private List<CiorderInfoDTO> rptarrays;

	public String getRpturl() {
		return rpturl;
	}

	public void setRpturl(String rpturl) {
		this.rpturl = rpturl;
	}

	public List<CiorderInfoDTO> getRptarrays() {
		return rptarrays;
	}

	public void setRptarrays(List<CiorderInfoDTO> rptarrays) {
		this.rptarrays = rptarrays;
	}

}
