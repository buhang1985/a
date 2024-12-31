package iih.bl.itf.std.bean.output.charge;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultEntInfoNew;

/**
 * 门诊自助支付待缴查询结果数据新
 * @author shaokx 2019/07/19
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoOpGetNoPayNew extends WsResultInfo{

    private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name="OEPEntList")
	@XmlElement(name = "entInfo")
	private List<WsResultEntInfoNew> oepEntList;

	public List<WsResultEntInfoNew> getOepEntList() {
		return oepEntList;
	}

	public void setOepEntList(List<WsResultEntInfoNew> oepEntList) {
		this.oepEntList = oepEntList;
	}
	
}
