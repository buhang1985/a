package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊自助支付待缴费项目入参
 * 
 * @author shaokx 2019/01/14
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultSingleEntInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 门诊就诊编码
	@XmlElement(name = "entCode")
	private String entCode;

	// 门诊就诊处方费用明细列表，缴费的基本单位为处方
	@XmlElementWrapper(name = "entPresList")
	@XmlElement(name = "presInfo")
	private List<WsResultSinglePresInfo> entPresList;

	public String getEntCode() {
		return entCode;
	}

	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}

	public List<WsResultSinglePresInfo> getEntPresList() {
		return entPresList;
	}

	public void setEntPresList(List<WsResultSinglePresInfo> entPresList) {
		this.entPresList = entPresList;
	}
	
	
}
