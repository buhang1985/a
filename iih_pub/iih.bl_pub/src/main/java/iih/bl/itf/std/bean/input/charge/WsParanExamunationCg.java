package iih.bl.itf.std.bean.input.charge;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.charge.sub.ExaminationtfgCgDto;

@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParanExamunationCg implements Serializable  {
	private static final long serialVersionUID = 1L;

	//查询条件
	@XmlElement(name = "orderItem")
	private List<ExaminationtfgCgDto> orderItem;

	public List<ExaminationtfgCgDto> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<ExaminationtfgCgDto> orderItem) {
		this.orderItem = orderItem;
	}

	
}
