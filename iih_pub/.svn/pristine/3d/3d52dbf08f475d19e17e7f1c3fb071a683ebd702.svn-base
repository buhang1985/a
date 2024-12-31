package iih.bl.itf.std.bean.output.ippay.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPTypecostInfo;

/**
 * 汇总分类费用情况 具体看医院账单参照
 * @author hanjq 下午5:27:40
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPPayInc extends WsResultInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6625120623648183799L;

	//发票号码
	@XmlElement(name = "incNo")
	private String incNo;

	//账单项 床位费用 中成药 西成药 治疗费 检查费 化验费 手术费 输氧费 材料费
	@XmlElementWrapper(name = "IPTypecostInfo")
	@XmlElement(name = "typeInfo")
	private List<WsResultIPTypecostInfo> IPTypecostInfo;

	public String getIncNo() {
		return incNo;
	}

	public void setIncNo(String incNo) {
		this.incNo = incNo;
	}

	public List<WsResultIPTypecostInfo> getIPTypecostInfo() {
		return IPTypecostInfo;
	}

	public void setIPTypecostInfo(List<WsResultIPTypecostInfo> iPTypecostInfo) {
		IPTypecostInfo = iPTypecostInfo;
	}

}
