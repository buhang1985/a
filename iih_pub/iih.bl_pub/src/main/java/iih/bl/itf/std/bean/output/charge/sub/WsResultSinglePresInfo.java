package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 门诊自助支付-处方信息
 * 
 * @author shaokx 2019/01/14
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultSinglePresInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 申请单编号
	@XmlElement(name = "applyCode")
	private String applyCode;

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	
	
}
