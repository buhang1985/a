package iih.ei.std.consis.v1.task.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 药房药品货位JavaBean
 * 
 * @author dj.zhang
 * @data 2018年8月12日下午11:17:31
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PharmDgLocDateBean extends BaseWsParam {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "DISPENSARY")
	private String dispensary;
	@XmlElement(name = "DRUG_CODE")
	private String drug_code;
	@XmlElement(name = "LOCATIONINFO")
	private String locationinfo;
	@XmlElement(name = "BATCHID")
	private String batchid;
	@XmlElement(name = "BATCHNO")
	private String batchno;
	@XmlElement(name = "PRODUCEDATE")
	private String producedate;
	@XmlElement(name = "DISABLEDDATE")
	private String disableddate;
	@XmlElement(name = "QUANTITY")
	private String quantity;

	/**
	 * 发药药局
	 * 
	 * @return
	 */
	public String getDispensary() {
		return dispensary;
	}

	/**
	 * 发药药局
	 * 
	 * @param dispensary
	 */
	public void setDispensary(String dispensary) {
		this.dispensary = dispensary;
	}

	/**
	 * 药品编号
	 * 
	 * @return
	 */
	public String getDrug_code() {
		return drug_code;
	}

	/**
	 * 药品编号
	 * 
	 * @param drug_code
	 */
	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	/**
	 * 货位信息
	 * 
	 * @return
	 */
	public String getLocationinfo() {
		return locationinfo;
	}

	/**
	 * 货位信息
	 * 
	 * @param locationinfo
	 */
	public void setLocationinfo(String locationinfo) {
		this.locationinfo = locationinfo;
	}

	/**
	 * 药品批次
	 * 
	 * @return
	 */
	public String getBatchid() {
		return batchid;
	}

	/**
	 * 药品批次
	 * 
	 * @param batchid
	 */
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	/**
	 * 药品批号
	 * 
	 * @return
	 */
	public String getBatchno() {
		return batchno;
	}

	/**
	 * 药品批号
	 * 
	 * @param batchno
	 */
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	/**
	 * 生产日期
	 * 
	 * @return
	 */
	public String getProducedate() {
		return producedate;
	}

	/**
	 * 生产日期
	 * 
	 * @param producedate
	 */
	public void setProducedate(String producedate) {
		this.producedate = producedate;
	}

	/**
	 * 失效日期
	 * 
	 * @return
	 */
	public String getDisableddate() {
		return disableddate;
	}

	/**
	 * 失效日期
	 * 
	 * @param disableddate
	 */
	public void setDisableddate(String disableddate) {
		this.disableddate = disableddate;
	}

	/**
	 * 药品货位库存数量
	 * 
	 * @return
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * 药品货位库存数量【	 * 
	 * @param quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
