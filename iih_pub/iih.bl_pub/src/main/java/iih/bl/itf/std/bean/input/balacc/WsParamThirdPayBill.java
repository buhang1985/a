package iih.bl.itf.std.bean.input.balacc;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.balacc.sub.WsParamThirdPayBillItem;
import iih.bl.itf.std.bean.output.WsResult;

@XmlRootElement(name = "res")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamThirdPayBill extends WsResult{
	/**
	 * 编码
	 */
	@XmlElement(name = "code")
	private String code;
	/**
	 * 信息
	 */
	@XmlElement(name = "message")
	private String message;


	/**
	 * 支付信息集合
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "payInfo")
	private List<WsParamThirdPayBillItem> Items;

	public List<WsParamThirdPayBillItem> getItems() {
		return Items;
	}

	public void setItems(List<WsParamThirdPayBillItem> items) {
		Items = items;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
