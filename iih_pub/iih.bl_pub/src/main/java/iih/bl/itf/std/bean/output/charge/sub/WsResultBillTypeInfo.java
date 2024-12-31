package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 费用清单账单项信息
 * 
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultBillTypeInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 账单项编码
	@XmlElement(name = "typeCode")
	private String typeCode;
	
	// 账单项名称
	@XmlElement(name = "typeName")
	private String typeName;
	
	// 账单金额
	@XmlElement(name = "typeAmount")
	private String typeAmount;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeAmount() {
		return typeAmount;
	}

	public void setTypeAmount(String typeAmount) {
		this.typeAmount = typeAmount;
	}
}
