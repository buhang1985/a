package iih.bl.itf.std.bean.output.settle.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 汇总分类费用情况 具体看医院账单参照
 * @author hanjq 下午5:27:40
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPTypecostInfo extends WsResultInfo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1046607255738270748L;

	//编码
	@XmlElement(name = "typeCode")
	private String typeCode;
	
	//名称
	@XmlElement(name = "typeName")
	private String typeName;
	
	//金额
	@XmlElement(name = "typeAmount")
	private String typeAmount;

	public WsResultIPTypecostInfo() {
		super();
	}

	public WsResultIPTypecostInfo(String typeCode, String typeName, String typeAmount) {
		super();
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.typeAmount = typeAmount;
	}

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
