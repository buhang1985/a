package iih.bl.itf.std.bean.output.inc.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊自助支付待缴数据-发票号明细
 * 
 * @author shaokx 2019/01/16
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetIncList implements Serializable {

	private static final long serialVersionUID = 1L;

	// 门诊发票号
	@XmlElement(name = "incNo")
	private String incNo;

	@XmlElementWrapper(name = "incItemDetail")
	@XmlElement(name = "itemDetail")
	private List<WsResultGetIncItmDetail> itemDetail;

	public String getIncNo() {
		return incNo;
	}

	public void setIncNo(String incNo) {
		this.incNo = incNo;
	}

	public List<WsResultGetIncItmDetail> getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(List<WsResultGetIncItmDetail> itemDetail) {
		this.itemDetail = itemDetail;
	}

}
